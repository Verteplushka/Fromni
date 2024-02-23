package com.fromni.backend.controller;

import com.fromni.backend.dto.UserDto;
import com.fromni.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<Boolean> addUser(@RequestBody UserDto userDto) {
        Boolean savedUser = userService.addUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/checkUser")
    public ResponseEntity<Boolean> checkUser(@RequestBody UserDto userDto) {
        Boolean checkedUser = userService.checkUser(userDto);
        return new ResponseEntity<>(checkedUser, HttpStatus.ACCEPTED);
    }
}
