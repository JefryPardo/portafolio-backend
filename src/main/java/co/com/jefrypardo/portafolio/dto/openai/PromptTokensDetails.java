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
 * @author jeffry
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromptTokensDetails {
 
    @JsonProperty("cached_tokens")
    private int cachedTokens;
}