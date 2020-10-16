package com.example.coafsoapclient.service;

import com.example.coafsoapclient.service.util.CertificateUtils;
import com.example.coafsoapclient.service.util.FileSystemUtils;
import com.example.coafsoapclient.service.util.XMLUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class SignatureXMLA3Service {

    private static final String TAG_APPLY_SIGNER = "OCORRENCIAS";

    public String applySignature(String xml, String password) throws Exception {
        return applySignature(xml, TAG_APPLY_SIGNER, password);
    }

    private String applySignature(String xml, String signedTag, String password) throws Exception {
        Document document = XMLUtils.createDocumentFrom(xml);
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = XMLUtils.createTransformListFrom(signatureFactory);
        PrivateKey privateKey = CertificateUtils.getPrivateKeyFromPKCS12(password, FileSystemUtils.getPFXFile());
        KeyInfo keyInfo = CertificateUtils.getKeyInfo(password,FileSystemUtils.getPFXFile(), signatureFactory);
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName(signedTag).getLength(); i++) {
            signerXML(signatureFactory, transformList, privateKey, keyInfo, document, i, signedTag);
        }
        return XMLUtils.outputXML(document);
    }

    private void signerXML(XMLSignatureFactory fac, ArrayList<Transform> transformList, PrivateKey privateKey,
                           KeyInfo ki, Document document, int indexNFe, String signerTag) throws Exception {
        NodeList elements = document.getElementsByTagName(signerTag);
        Element el = (Element) elements.item(0);
        String id = el.getAttribute("ID");
        el.setIdAttribute("ID", true);
        Reference ref = fac.newReference("#" + id,fac.newDigestMethod(DigestMethod.SHA1, null), transformList,null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac
                        .newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));
        XMLSignature signature = fac.newXMLSignature(si, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey,
                document.getDocumentElement().getElementsByTagName(signerTag).item(indexNFe));
        signature.sign(dsc);
    }


}
