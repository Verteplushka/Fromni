package com.fromni.backend.controller;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.entity.Message;
import com.fromni.backend.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @PostMapping("/createMessage")
    public ResponseEntity<Message> createMessage(@RequestBody MessageDto messageDto){
        Message savedMessage = messageService.createMessage(messageDto);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }
}
