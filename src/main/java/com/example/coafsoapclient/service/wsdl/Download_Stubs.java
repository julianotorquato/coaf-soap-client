package com.example.coafsoapclient.service.wsdl;

import com.example.coafsoapclient.service.util.HttpClientHelper;
import org.springframework.http.ResponseEntity;

public class Download_Stubs {

    public static void main(String[] args) throws Exception{
        getXMLStubs();
    }

    private static void getXMLStubs()throws Exception{
        HttpClientHelper httpClientHelper =  new HttpClientHelper(Boolean.TRUE);
        String url = "https://treina.siscoaf.coaf.gov.br/siscoaf-internet/ComunicacaoService?wsdl";
        ResponseEntity<String> responseEntity = httpClientHelper.doGet(url, null);
        System.out.println(responseEntity.getBody());
    }
}
