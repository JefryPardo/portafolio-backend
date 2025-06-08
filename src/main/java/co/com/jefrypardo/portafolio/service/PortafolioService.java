/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.service;

import co.com.jefrypardo.portafolio.client.OpenaiClient;
import co.com.jefrypardo.portafolio.dto.PortafolioResponse;
import co.com.jefrypardo.portafolio.dto.portafolio.PromptRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeffry
 */
@Slf4j
@Service
public class PortafolioService implements InitializingBean {
 
    @Autowired
    private OpenaiClient openaiClient;
    
    @Override
    public void afterPropertiesSet() {System.out.println("==== Starting Chat GPT ====");}
    
    public PortafolioResponse askChatGPT(PromptRequest question) {
        
        PortafolioResponse portafolioRespuesta = new PortafolioResponse();
        
        try {
            
            String estado_respuesta = generarPregunta(question.getPrompt());
            portafolioRespuesta.setStatus("200");
            portafolioRespuesta.setCodigo("PT003");
            portafolioRespuesta.setMensaje(estado_respuesta);
            
        } catch (Exception e) {
        
            log.error("Error askChatGPT: [{}]",e);
            
            portafolioRespuesta.setStatus("500");
            portafolioRespuesta.setCodigo("PT001");
            portafolioRespuesta.setMensaje("Algo salio mal, intentalo de nuevo.");
            
        }
        
        return portafolioRespuesta;
            
    }
    
    private String generarPregunta(String pregunta) {
    
       log.info("Consultando ChatGPT con la pregunta: {}", pregunta);
        
        try {
            
            return openaiClient.generarPrompt(pregunta);
            
        } catch (Exception e) {
            
            log.error("Error al consultar ChatGPT: {}", e.getMessage(), e);
        }
        
        return "Algo salio mal.";
    }
    
}