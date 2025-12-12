package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data ///getters and setters
@AllArgsConstructor //construstor parametrizado (con todos los atributos)
@NoArgsConstructor //constructor sin parametros
public class CustomRequest {

    String data;

    
}
