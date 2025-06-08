/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.dto.openai;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Usage {
 
    @JsonProperty("prompt_tokens")
    private int promptTokens;
    
    @JsonProperty("completion_tokens")
    private int completionTokens;
    
    @JsonProperty("total_tokens")
    private int totalTokens;
    
    @JsonProperty("prompt_tokens_details")
    private PromptTokensDetails promptTokensDetails;
    
    @JsonProperty("completion_tokens_details")
    private CompletionTokensDetails completionTokensDetails;
}