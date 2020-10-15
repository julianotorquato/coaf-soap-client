package com.example.coafsoapclient.service.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.net.ssl.KeyManagerFactory;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.*;

public class CertificateUtils {

    public static Certificate getSampleCertificateFromPKCS12() throws IOException, GeneralSecurityException {
        String alias = "{ecaf2712-4631-4f0e-94d1-fa6fcbff329f}";
        String password = "1234";

        Resource resource = new ClassPathResource("/static/Pierre_de_Fermat.pfx");
        InputStream fileStream = resource.getInputStream();
        KeyStore certStore = KeyStore.getInstance("pkcs12");
        certStore.load(fileStream, password.toCharArray());
        Certificate certificate = certStore.getCertificate(alias);
        fileStream.close();
        return certificate;
    }

    public static Key getSampleKeyFromPKCS12() throws IOException, GeneralSecurityException {
        String alias = "{ecaf2712-4631-4f0e-94d1-fa6fcbff329f}";
        String password = "1234";

        Resource resource = new ClassPathResource("/static/Pierre_de_Fermat.pfx");
        InputStream fileStream = resource.getInputStream();
        KeyStore certStore = KeyStore.getInstance("pkcs12");
        certStore.load(fileStream, password.toCharArray());
        Key pkey = certStore.getKey(alias, password.toCharArray());
        fileStream.close();
        return pkey;
    }

    public static PrivateKey getPrivateKeyFromPKCS12(String pw, String absolutePathPFX) throws Exception {
        return (PrivateKey) getFromPKCS12( pw, absolutePathPFX, PrivateKey.class);
    }

    public static Certificate getCertificateFromPKCS12(String pw, String absolutePathPFX) throws Exception {
        return (Certificate) getFromPKCS12( pw, absolutePathPFX, Certificate.class);
    }

    public static Key getKeyFromPKCS12(String pw, String absolutePathPFX) throws Exception {
        return (Key) getFromPKCS12(pw, absolutePathPFX, Key.class);
    }

    private static Object getFromPKCS12(String pw, String absolutePathPFX, Class returnType) throws Exception {
        KeyManagerFactory kmf = javax.net.ssl.KeyManagerFactory.getInstance("SunX509");
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        char[] password = pw.toCharArray();
        keystore.load(new FileInputStream(absolutePathPFX),password);
        kmf.init(keystore, password);
        Enumeration<String> aliases = keystore.aliases();
        KeyStore.PrivateKeyEntry pkEntry = null;
        while(aliases.hasMoreElements()){
            String alias = aliases.nextElement();
            if(keystore.getCertificate(alias).getType().equals("X.509")){
                if (returnType == Key.class){
                    return keystore.getKey(alias, password);
                }else if ( returnType == PrivateKey.class){
                    pkEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry(alias,
                            new KeyStore.PasswordProtection(password));
                    return pkEntry.getPrivateKey();
                }else if ( returnType == Certificate.class){
                    return keystore.getCertificate(alias);
                }
            }
        }
        return null;
    }


    public static KeyInfo getKeyInfo(String password, String absolutePathPFX, XMLSignatureFactory signatureFactory) throws Exception{
        Certificate cert = getCertificateFromPKCS12(password, absolutePathPFX);
        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<Certificate> x509Content = new ArrayList<Certificate>();
        x509Content.add(cert);
        X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
        return keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
    }

    public static Map<String, Object> findExpire(String password, String absolutePathPFX) throws Exception{
        KeyManagerFactory kmf = javax.net.ssl.KeyManagerFactory.getInstance("SunX509");
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        char[] pw= password.toCharArray();
        keystore.load(new FileInputStream(FileSystemUtils.getPFXFile()),pw);
        kmf.init(keystore, pw);
        Enumeration<String> aliases = keystore.aliases();
        Date expDate = null;
        Date fromDate = null;
        while(aliases.hasMoreElements()){
            String alias = aliases.nextElement();
            if(keystore.getCertificate(alias).getType().equals("X.509")){
                expDate = ((X509Certificate) keystore.getCertificate(alias)).getNotAfter();
                fromDate= ((X509Certificate) keystore.getCertificate(alias)).getNotBefore();
            }
        }
        Map<String, Object> result = new HashMap();
        result.put("expDate", expDate);
        result.put("fromDate", fromDate);
        return result;
    }
}
