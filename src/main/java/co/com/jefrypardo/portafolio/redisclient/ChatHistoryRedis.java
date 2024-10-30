/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.redisclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author jeffry
 */
@RedisHash(value = "ChatHistory", timeToLive = 20 * 60)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatHistoryRedis {
    
    @Id
    String id;
    
//    @Builder.Default()
//    List<Message> chatHistory = null;
}