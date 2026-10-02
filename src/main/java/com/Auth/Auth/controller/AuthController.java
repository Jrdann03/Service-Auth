package com.Auth.Auth.controller;

import com.Auth.Auth.dto.UtilisateurRequest;
import com.Auth.Auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody UtilisateurRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

}
