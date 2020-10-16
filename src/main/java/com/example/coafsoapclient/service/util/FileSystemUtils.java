package com.example.coafsoapclient.service.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class FileSystemUtils {

    private static final String DEMO_PFX = "/static/DEMO.pfx";
    private static final String OCCURRENCE_XML = "/wsdl/ocorrencia.xml";
    private static final String RECEIPT_XML = "/wsdl/solicitacao_recibo.xml";

    public static String getReceiptPath() throws IOException {
        return getPathFrom(RECEIPT_XML);
    }

    public static String getOcorrenciaPath() throws IOException {
        return getPathFrom(OCCURRENCE_XML);
    }

    public static String getPFXFile() throws IOException {
        return getPathFrom(DEMO_PFX);
    }

    private static String getPathFrom(String relativePath) throws IOException {
        return new ClassPathResource(relativePath).getFile().getPath();
    }


}
