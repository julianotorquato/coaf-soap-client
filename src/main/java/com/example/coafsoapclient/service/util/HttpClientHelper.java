package com.example.coafsoapclient.service.util;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class HttpClientHelper {


    public static final String BEARER = "Bearer";
    public static final String BASIC = "Basic";

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    public HttpClientHelper() {
    }

    public HttpClientHelper(Boolean skipSSl) throws Exception{
        if (Boolean.TRUE.equals(skipSSl)){
            createRestTemplateNoSsl();
        }
    }

    private void createRestTemplateNoSsl() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        this.restTemplate = restTemplate;
    }

    private void setContentTypeApplicationJson(){
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    private void setToken(String token){
        if (token == null)return;
        headers.add(HttpHeaders.AUTHORIZATION, token);
    }

    public ResponseEntity<String> doPost(String uri, String objectJson) throws RestClientException {
        return execute(HttpMethod.POST, uri, null, objectJson);
    }

    public <T> ResponseEntity<T> doPost(String uri, String objectJson, Class<T> var4) throws RestClientException {
        return execute(HttpMethod.POST, uri, null, objectJson, var4);
    }

    public ResponseEntity<String> doPost(String uri, String token, String objectJson) throws RestClientException {
        return execute(HttpMethod.POST, uri, token, objectJson);
    }

    public <T> ResponseEntity<T> doPost(String uri, String token, String objectJson, Class<T> var4) throws RestClientException {
        return execute(HttpMethod.POST, uri, token, objectJson, var4);
    }

    public ResponseEntity<String> doGet(String uri, String token) throws RestClientException {
        return execute(HttpMethod.GET, uri, token, "");
    }

    public <T> ResponseEntity<T> doGet(String uri, String token, Class<T> var4) throws RestClientException {
        return execute(HttpMethod.GET, uri, token, "", var4);
    }

    public ResponseEntity<String> doPut(String uri, String token,  String objectJson) throws RestClientException {
        return execute(HttpMethod.PUT, uri, token, objectJson);
    }

    private ResponseEntity<String> execute(HttpMethod method, String uri, String token, String objectJson) throws RestClientException {
        this.setContentTypeApplicationJson();
        this.setToken(token);
        HttpEntity<String> entity = new HttpEntity<String>(objectJson, headers);
        return restTemplate.exchange(uri, method, entity, String.class);
    }


    private <T> ResponseEntity<T> execute(HttpMethod method, String uri, String token, String objectJson, Class<T> var4) throws RestClientException {
        return execute(method, uri, token, objectJson, var4, new Object[]{});
    }

    private <T> ResponseEntity<T> execute(HttpMethod method, String uri, String token, String objectJson, Class<T> var4, Object... var5) throws RestClientException {
        this.setContentTypeApplicationJson();
        this.setToken(token);
        HttpEntity<String> entity = new HttpEntity<String>(objectJson, headers);
        return restTemplate.exchange(uri, method, entity, var4, var5);
    }

}
