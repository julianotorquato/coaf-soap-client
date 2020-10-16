package com.example.coafsoapclient.web.rest;

import com.example.coafsoapclient.service.CoafService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coaf")
public class CoafResource {

    private final Logger log = LoggerFactory.getLogger(CoafResource.class);

    private final CoafService coafService;

    public CoafResource(CoafService coafService) {
        this.coafService = coafService;
    }

    @RequestMapping(value = "/send-communication", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> sendComunication() throws Exception{
        log.debug("REST request to sendComunication : {}");
        Object resposta = coafService.sendComunication();
        log.info("Resposta: {}", resposta);
        return ResponseEntity.ok(resposta.toString());
    }


    @RequestMapping(value = "/receipt", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getReceipt() throws Exception{
        log.debug("REST request to getReceipt : {}");
        Object resposta = coafService.getReceipt();
        log.info("Response: {}", resposta);
        return ResponseEntity.ok(resposta.toString());
    }

}
