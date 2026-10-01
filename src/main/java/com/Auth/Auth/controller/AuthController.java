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

        System.out.println("Nom : " + request.getNom());
        System.out.println("Prénom : " + request.getPrenom());
        System.out.println("Password : " + request.getPassword());
        System.out.println("Email : " + request.getEmail());

        return ResponseEntity.ok(request);
    }
}
