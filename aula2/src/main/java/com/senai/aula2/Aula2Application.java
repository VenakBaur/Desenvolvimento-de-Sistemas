package com.senai.aula2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Aula2Application {

    public static void main(String[] args) {
        SpringApplication.run(Aula2Application.class, args);
    }
    
    @GetMapping("/")
    public ResponseEntity<Numero> helloworld() {
        
        return "oi";
        
    }
    
    @PostMapping("/")
    public String post() {
        
        return "post";
        
    }
    
}
