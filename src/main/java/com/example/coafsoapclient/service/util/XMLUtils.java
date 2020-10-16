package com.example.coafsoapclient.service.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class XMLUtils {

    public static String outputXML(Document doc) throws TransformerException {
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
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileXML)));
        while ((linha = in.readLine()) != null) {
            xml.append(linha);
        }
        in.close();
        return xml.toString();
    }

    public static Document createDocumentFrom(String xml) throws SAXException,
            IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = factory.newDocumentBuilder().parse(
                new ByteArrayInputStream(xml.getBytes()));
        return document;
    }

    public static ArrayList<Transform> createTransformListFrom(XMLSignatureFactory signatureFactory) throws Exception {
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

}
