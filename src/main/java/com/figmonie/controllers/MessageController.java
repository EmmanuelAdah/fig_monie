package com.figmonie.controllers;

import com.figmonie.services.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {
    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
