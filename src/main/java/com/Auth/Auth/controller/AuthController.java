package com.Auth.Auth.controller;

import com.Auth.Auth.dto.UtilisateurRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<UtilisateurRequest> register(
            @RequestBody UtilisateurRequest request) {
        return ResponseEntity.ok(request);
    }
}
