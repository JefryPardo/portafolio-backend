/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.dto.openai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jeffr
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    
    private int index;
    private Message message;
    private Object logprobs;
    private String finishReason;
}
