package com.fromni.backend.controller;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.dto.WrapperDto;
import com.fromni.backend.entity.Message;
import com.fromni.backend.entity.User;
import com.fromni.backend.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @PostMapping("/createMessage")
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto messageDto){
        MessageDto savedMessage = messageService.createMessage(messageDto);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/getMessages")
    public ResponseEntity<List<MessageDto>> getMessages(@RequestBody User user){
        List<MessageDto> foundMessages = messageService.getMessagesByUser(user);
        return ResponseEntity.ok(foundMessages);
    }

    @PostMapping("/updateMessage")
    public ResponseEntity<MessageDto> updateMessage(@RequestBody MessageDto messageDto){
        MessageDto updatedMessage = messageService.updateMessage(messageDto);
        return ResponseEntity.ok(updatedMessage);
    }
}
