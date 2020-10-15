package com.example.coafsoapclient.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.example.coafsoapclient.service.util.CertificateUtils;
import com.example.coafsoapclient.service.util.FileSystemUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AssigneXMLA3Service {

    private static final String TAG_APPLY_SIGNATURE = "OCORRENCIAS";

    public String applySignature(String xml, String password) throws Exception {
        Document document = documentFactory(xml);
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);
        PrivateKey privateKey = CertificateUtils.getPrivateKeyFromPKCS12(password, FileSystemUtils.getPFXFile());
        KeyInfo keyInfo = CertificateUtils.getKeyInfo(password,FileSystemUtils.getPFXFile(), signatureFactory);
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName(TAG_APPLY_SIGNATURE).getLength(); i++) {
            signerOcorrencia(signatureFactory, transformList, privateKey, keyInfo, document, i);
        }
        return outputXML(document);
    }

    private void signerOcorrencia(XMLSignatureFactory fac,
                                  ArrayList<Transform> transformList, PrivateKey privateKey,
                                  KeyInfo ki, Document document, int indexNFe) throws Exception {

        NodeList elements = document.getElementsByTagName(TAG_APPLY_SIGNATURE);
        Element el = (Element) elements.item(0);
        String id = el.getAttribute("ID");
        el.setIdAttribute("ID", true);

        Reference ref = fac.newReference("#" + id,
                fac.newDigestMethod(DigestMethod.SHA1, null), transformList,
                null, null);

        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac
                        .newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));

        XMLSignature signature = fac.newXMLSignature(si, ki);

        DOMSignContext dsc = new DOMSignContext(privateKey,
                document.getDocumentElement().getElementsByTagName(TAG_APPLY_SIGNATURE).item(indexNFe));
        signature.sign(dsc);
    }



    private ArrayList<Transform> signatureFactory(
            XMLSignatureFactory signatureFactory)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ArrayList<Transform> transformList = new ArrayList<Transform>();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = signatureFactory.newTransform(
                Transform.ENVELOPED, tps);
        Transform c14NTransform = signatureFactory.newTransform(
                "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);
        return transformList;
    }

    private Document documentFactory(String xml) throws SAXException,
            IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = factory.newDocumentBuilder().parse(
                new ByteArrayInputStream(xml.getBytes()));
        return document;
    }



    private String outputXML(Document doc) throws TransformerException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(os));
        String xml = os.toString();
        if ((xml != null) && (!"".equals(xml))) {
            xml = xml.replaceAll("\\r\\n", "");
            xml = xml.replaceAll(" standalone=\"no\"", "");
        }
        return xml;
    }

    public static String readXML(String fileXML) throws IOException {
        String linha = "";
        StringBuilder xml = new StringBuilder();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileXML)));
        while ((linha = in.readLine()) != null) {
            xml.append(linha);
        }
        in.close();

        return xml.toString();
    }
}
