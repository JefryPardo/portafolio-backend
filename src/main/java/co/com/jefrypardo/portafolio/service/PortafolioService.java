/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.service;

import co.com.jefrypardo.portafolio.client.OpenaiClient;
import co.com.jefrypardo.portafolio.dto.PortafolioResponse;
import co.com.jefrypardo.portafolio.dto.portafolio.PromptRequest;
import co.com.jefrypardo.portafolio.redisclient.ChatHistoryRedisRepository;
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
    private ChatHistoryRedisRepository chatHistoryRedisRepository;
    
    @Autowired
    private OpenaiClient openaiClient;
    
    @Override
    public void afterPropertiesSet() {System.out.println("==== Starting Chat GPT ====");}
    
    public PortafolioResponse askChatGPT(PromptRequest question, String ip) {
        
        PortafolioResponse portafolioRespuesta = new PortafolioResponse();
        
        try {
            
            String estado_respuesta = generarPregunta(question.getPrompt());
//            if (question.getInicializarChat()) {
//
//                if(estado_respuesta) {
//
//                    Message mensaje = new Message();
//                    mensaje.setContent("Hola soy jefry");
//                    mensaje.setRole("Hola jefry");
//
//                    List<Message> chatHistory = new ArrayList<>();
//                    chatHistory.add(mensaje);
//
//                    ChatHistoryRedis save = new ChatHistoryRedis();
//                    save.setId("1234");
//                    save.setChatHistory(chatHistory);
//
//
//                    chatHistoryRedisRepository.save(save);
//                }
//
//                Iterable<ChatHistoryRedis> all = chatHistoryRedisRepository.findAll();
//                for (ChatHistoryRedis chatHistoryRedis : all) {
//                    if(chatHistoryRedis != null) {
//
//                        log.info("chat:");
//                        log.info("id:", chatHistoryRedis.getId());
//
//                        for (Message mensajes : chatHistoryRedis.getChatHistory()) {
//
//                            log.info("content:", mensajes.getContent());
//                            log.info("role:", mensajes.getRole());
//                        }
//                    }
//                }
//                
//            }
                portafolioRespuesta.setStatus("200");
                portafolioRespuesta.setCodigo("PT003");
                portafolioRespuesta.setMensaje(estado_respuesta);
        } catch (Exception e) {
        
            log.error("Error askChatGPT: [{}]",e);
            
            portafolioRespuesta.setStatus("500");
            portafolioRespuesta.setCodigo("PT001");
            portafolioRespuesta.setMensaje("Algo salio mal, por intentalo de nuevo.");
            
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