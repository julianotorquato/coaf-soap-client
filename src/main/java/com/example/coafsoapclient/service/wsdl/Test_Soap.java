package com.example.coafsoapclient.service.wsdl;

import br.gov.coaf.ComunicacaoService_Service;
import com.example.coafsoapclient.service.SignatureXMLA3Service;
import com.example.coafsoapclient.service.util.FileSystemUtils;
import com.example.coafsoapclient.service.util.SSLUtilities;
import com.example.coafsoapclient.service.util.XMLUtils;

public class Test_Soap {

    static {
        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
    }


    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws Exception{
        SignatureXMLA3Service assigneXMLA3 = new SignatureXMLA3Service();
        ComunicacaoService_Service coafClient = new ComunicacaoService_Service();
        info("");
//        String xmlFileSystem = XMLUtils.readXML(FileSystemUtils.getOcorrenciaPath());
//        String signedXML = assigneXMLA3.applySignature(xmlFileSystem, PASSWORD);
//        String result = coafClient.getComunicacaoServicePort().enviarLoteComunicacao(xmlEnviNFeAssinado);

        String xmlFileSystem = XMLUtils.readXML(FileSystemUtils.getReceiptPath());
        String signedXML = assigneXMLA3.applySignature(xmlFileSystem, PASSWORD);
        String result = coafClient.getComunicacaoServicePort().reciboLoteComunicacao(signedXML);
        info(result);
    }

    /**
     * Log INFO.
     *
     * @param info
     */
    private static void info(String info) {
        System.out.println("| INFO: " + info);
    }
}
