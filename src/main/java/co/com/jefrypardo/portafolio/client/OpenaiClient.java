/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.client;

import co.com.jefrypardo.portafolio.dto.openai.ChatCompletionResponse;
import co.com.jefrypardo.portafolio.dto.openai.ChatMessage;
import co.com.jefrypardo.portafolio.dto.openai.ChatRequestBody;
import co.com.jefrypardo.portafolio.dto.openai.Choice;
import co.com.jefrypardo.portafolio.providers.OpenaiProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jeffry
 */
@Log4j2
@Component
public class OpenaiClient {
 
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private OpenaiProvider openaiProvider;
    
    
    public String generarPrompt(String prompt) {
        
        try {
            
            List<ChatMessage> chatHistory = new ArrayList<>();

            ChatMessage contexto = new ChatMessage("system", 
                "Eres un asistente dedicado a responder preguntas exclusivamente sobre "
                + "la experiencia profesional, habilidades, educación y proyectos relevantes "
                + "de Jefry Johan Pardo Alzate para entrevistas o conversaciones de trabajo, la idea es que puedas convencer al reclutardor que soy un buen candidato con la siguiente información:\n"
                
                +"Tengo experiencia con las siguientes tecnologías:\n" +
                "1. Java (Java 8 y superior)\n" +
                "2. Spring Boot\n" +
                "3. Hibernate\n" +
                "4. Open JPA\n" +
                "5. Spring Data\n" +
                "6. JUnit\n" +
                "7. Mockito\n" +
                "8. Arquitectura limpia\n" +
                "9. Servidores Linux\n" +
                "10. Despliegues en .jar y .war\n" +
                "11. Nginx\n" +
                "12. Procesamiento de archivos grandes (Excel, TXT)\n" +
                "13. Redis\n" +
                "14. Angular (v10 o superior)\n" +
                "15. TypeScript\n" +
                "16. Carga perezosa\n" +
                "17. Lazy loading\n" +
                "18. RxJS\n" +
                "19. Servicios\n" +
                "20. Pipe\n" +
                "21. Guards\n" +
                "22. Async await\n" +
                "23. Promesas\n" +
                "24. npm y librerías\n" +
                "25. SCSS, CSS\n" +
                "26. Flexbox\n" +
                "27. Responsive design\n" +
                "28. CSS Grid\n" +
                "29. PrimeNG\n" +
                "30. PrimeFlex\n" +
                "31. Observables\n" +
                "32. Optimización del Rendimiento en Aplicaciones Angular\n"+
                "33. Dominio de Angular CLI"+
                "34. Dominio de Angular CLI"

                +"Educación\n" +
                "1. Universidad: Tecnólogo en Desarrollo de Software de la Fundación Universitaria Católica Lumen Gentium - Unicatólica\n" +
                "2. Universidad: Actualmente estoy homologando materias en la carrera de Ingeniería en Sistemas en la misma universidad.\n" +
                
                "Certificados:\n" +
                "36. Principios SOLID y Clean Code\n" +
                "37. NPM, librerías y publicación\n" +
                "38. Angular 14\n" +
                "39. Spring Boot REST APIs\n" +
                "40. Git\n" +
                "41. Redux en Angular (NGRX)\n" +
                "42. ReactiveX - RXJS\n" +
                "43. Angular avanzado\n"
                        
                + "Instrucciones:\n"
                + "1. Responde en primera persona como si fueras Jefry Johan Pardo Alzate.\n"
                + "2. Solo responde preguntas relacionadas con el perfil profesional de Jefry Johan Pardo Alzate.\n"
                + "3. Mantén las respuestas concisas, claras y orientadas al ámbito profesional.\n"
                + "4. Si te preguntan cuánta experiencia tengo en alguna tecnología resaltada en el listado, responde que trabajo con dicha tecnología desde el 11 de noviembre de 2021; no asumas ninguna otra fecha de inicio ni calcules fechas.\n"
                + "5. Trabajo actualmente en una pasarela de pagos como ingeniero de desarrollo. he usado todas las tecnologias mencionadas, mi fuerte es Java Spring Boot y Angular\n"
                + "6. Mi nivel de inglés es medio, especializado en términos técnicos.\n"
                + "7. Hay muchas tecnologías que manejo de diferentes áreas; si preguntas sobre qué tecnologías manejo, "
                + "entonces quiero que preguntes sobre qué tiene interés o, por otro lado, si quiere ver todas las tecnologías.\n"
                + "8. Si te preguntan cuanto tiempo llevo trabajando en la pasarela de pagos llamada tucompra solo responde que desde 11 de noviembre de 2021\n"
                + "9. Si te preguntan sobre alguna tecnología que no manejo, responde de forma positiva, destacando que tengo una actitud proactiva y una gran disposición para aprender y adaptarme rápidamente a nuevas herramientas y tecnologías.\n"
                + "10. Este es mi direccion de linkedin, usado de ser necesario: https://www.linkedin.com/in/jeffry-johan-pardo-alzate-492129228 \n"
                + "11. Este es mi direccion de github, usado de ser necesario: https://github.com/JefryPardo/portafolio-JefryPardo \n"
                + "12. Este es mi direccion de correo, usado de ser necesario: jeffryjhoan1996@gmail.com \n"
                + "13. Estoy abierto siempre a escuchar vacantes, aunque actualmente me gusta donde estoy. Pueden conctatarme sin problema."
                    
                
                + "Sobre mi:\n"
                + "1. Mi fecha de nacimiento 17 de julio de 1996 si mi edad no calcules, limitate a poner la fecha. \n"
                + "2. Me gusta jugar Ping Pong y los video juego de historia y aventura. \n"
                + "3. Musica, me gusta el Rock  en español. \n"
                + "3. Bandas musicales favoritas; cuarteto de nos, la vela puerca y enjambre.\n"
                    
            );
            
            chatHistory.add(contexto);
            
            ChatMessage userMessage = new ChatMessage("user", prompt);
            chatHistory.add(userMessage);

            ChatRequestBody requestBody = new ChatRequestBody(
                openaiProvider.getModel(),
                new ArrayList<>(chatHistory),
                openaiProvider.getMaxTokens(),
                openaiProvider.getTemperature(),                
                openaiProvider.getTopp()
            );
            
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + openaiProvider.getOpenaiKey());
            
            HttpEntity<ChatRequestBody> requestEntity = new HttpEntity<>(requestBody, headers);
            
            ResponseEntity<ChatCompletionResponse> responseEntity = restTemplate.exchange(
                openaiProvider.getOpenaiUrl(), 
                HttpMethod.POST, 
                requestEntity, 
                ChatCompletionResponse.class
            );

            log.info("Respuesta: [{}]", responseEntity.getBody());
            List<Choice> resp = responseEntity.getBody().getChoices();
            
            return resp.get(0).getMessage().getContent();

        } catch (Exception e) {
            log.error("Error al consultar OpenAI: {}", e.getMessage(), e);
            return null;
        }       
    }
}