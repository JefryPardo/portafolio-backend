/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.jefrypardo.portafolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jeffry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortafolioResponse {
 
    private String status;
    private String mensaje;
    private String codigo;
}