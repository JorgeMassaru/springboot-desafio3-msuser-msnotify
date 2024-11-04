package com.jorgeMassaru.desafio3.controllers;

import com.jorgeMassaru.desafio3.dto.UserRecordDto;
import com.jorgeMassaru.desafio3.model.User;
import com.jorgeMassaru.desafio3.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        User user = new User();
        BeanUtils.copyProperties(userRecordDto, user);

        // Salva o usuário e preenche o endereço usando o ViaCep
        user = userService.register(user);

        // Retorna o objeto `User` salvo como resposta com o status HTTP 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
