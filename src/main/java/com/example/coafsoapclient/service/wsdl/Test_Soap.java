package com.example.coafsoapclient.service.wsdl;

import br.gov.fazenda.coaf.ComunicacaoService_Service;
import com.example.coafsoapclient.service.AssigneXMLA3Service;
import com.example.coafsoapclient.service.util.FileSystemUtils;

public class Test_Soap {

    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws Exception{
        AssigneXMLA3Service assigneXMLA3 = new AssigneXMLA3Service();
        info("");
        String xmlFileSystem = assigneXMLA3.readXML(FileSystemUtils.getOcorrenciaPath());
        String xmlEnviNFeAssinado = assigneXMLA3.applySignature(xmlFileSystem, PASSWORD);

        ComunicacaoService_Service comunicacaoService_Service = new ComunicacaoService_Service();
        String result = comunicacaoService_Service.getComunicacaoServicePort().enviarLoteComunicacao(xmlEnviNFeAssinado);
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
