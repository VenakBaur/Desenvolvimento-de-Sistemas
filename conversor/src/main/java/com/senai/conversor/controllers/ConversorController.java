package com.senai.conversor.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/conversor")


public class ConversorController {
    
    @PostMapping("/temperatura")
    
    public ResponseEntity<> converteTemperatura () {
        
        return ResponseEntity.of(body)
        
    }
    
    @PostMapping("/comprimento")
    
    public ResponseEntity<> converteComprimento () {
        
        return ResponseEntity.of(body)
        
    }
    
    @PostMapping("/massa")
    
    public ResponseEntity<> converteMassa () {
        
        return ResponseEntity.of(body)
        
    }
    
    @PostMapping("/volume")
    
    public ResponseEntity<> converteVolume () {
        
        return ResponseEntity.of(body)
        
    }
    
}
