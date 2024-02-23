package com.fromni.backend.controller;

import com.fromni.backend.entity.User;
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
    public ResponseEntity<Boolean> addUser(@RequestBody User user) {
        Boolean savedUser = userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/checkUser")
    public ResponseEntity<Boolean> checkUser(@RequestBody User user) {
        Boolean checkedUser = userService.checkUser(user);
        return new ResponseEntity<>(checkedUser, HttpStatus.ACCEPTED);
    }
}
