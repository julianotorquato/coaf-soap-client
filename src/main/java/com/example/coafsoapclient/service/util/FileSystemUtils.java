package com.example.coafsoapclient.service.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class FileSystemUtils {

    public static String getOcorrenciaPath() throws IOException {
        return new ClassPathResource("/static/ocorrencia.xml").getFile().getPath();
    }

    public static String getPFXFile() throws IOException {
        return new ClassPathResource("/static/DEMO.pfx").getFile().getPath();
    }
}
