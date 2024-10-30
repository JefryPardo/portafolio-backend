/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.providers;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author jeffry
 */
@Slf4j
@Data
@Component
public class OpenaiProvider {
 
    @Value("${openai.config-request.max-tokens}")
    private Integer maxTokens;
    
    @Value("${openai.config-request.model}")
    private String model;
    
    @Value("${openai.config-request.temperature}")
    private Double temperature;
    
    @Value("${openai.config-request.top-p}")
    private Double topp;
    
    @Value("${openai.url}")
    private String openaiUrl;
    
    @Value("${openai.api-key}")
    private String openaiKey;
    
    @PostConstruct
    void init() {
        log.info("ApplicationProvider: [{}]", this.toString());
    }
}