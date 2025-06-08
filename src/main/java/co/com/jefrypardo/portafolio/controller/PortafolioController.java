/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.controller;

import co.com.jefrypardo.portafolio.dto.PortafolioResponse;
import co.com.jefrypardo.portafolio.dto.portafolio.PromptRequest;
import co.com.jefrypardo.portafolio.service.PortafolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeffry
 */
@RestController
@RequestMapping("portafolio")
public class PortafolioController {
    
    private static final Logger log = LoggerFactory.getLogger(PortafolioController.class);
    
    @Autowired
    private PortafolioService portafolioService;
    
    @PostMapping("chat")
    public ResponseEntity<PortafolioResponse> chatPortafolio(@RequestBody PromptRequest req) {
        
        log.info("Request chatPortafolio: [{}]", req);
        PortafolioResponse resp = portafolioService.askChatGPT(req);
        
        return ResponseEntity.ok(resp);
    }
}