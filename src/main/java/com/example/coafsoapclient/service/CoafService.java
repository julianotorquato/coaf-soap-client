package com.example.coafsoapclient.service;

import br.gov.fazenda.coaf.ComunicacaoService_Service;
import com.example.coafsoapclient.config.ApplicationProperties;
import com.example.coafsoapclient.service.util.FileSystemUtils;
import com.example.coafsoapclient.service.util.XMLUtils;
import org.springframework.stereotype.Service;

@Service
public class CoafService {

    private final ApplicationProperties applicationProperties;
    private final SignatureXMLA3Service signatureXMLA3Service;

    public CoafService(ApplicationProperties applicationProperties, SignatureXMLA3Service signatureXMLA3Service) {
        this.applicationProperties = applicationProperties;
        this.signatureXMLA3Service = signatureXMLA3Service;
    }

    public Object sendComunication()throws Exception{
        String xmlFileSystem = XMLUtils.readXML(FileSystemUtils.getOcorrenciaPath());
        String signedXML = signatureXMLA3Service.applySignature(xmlFileSystem, applicationProperties.getPasswordPfx());
        String result = new ComunicacaoService_Service().getComunicacaoServicePort().enviarLoteComunicacao(signedXML);
        return result;
    }

    public Object getReceipt()throws Exception{
        String xmlFileSystem = XMLUtils.readXML(FileSystemUtils.getReceiptPath());
        String signedXML = signatureXMLA3Service.applySignature(xmlFileSystem, applicationProperties.getPasswordPfx());
        String result = new ComunicacaoService_Service().getComunicacaoServicePort().enviarLoteComunicacao(signedXML);
        return result;
    }

}
