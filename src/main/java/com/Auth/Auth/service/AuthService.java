package com.Auth.Auth.service;

import com.Auth.Auth.dto.AuthResponse;
import com.Auth.Auth.dto.LoginRequest;
import com.Auth.Auth.dto.UtilisateurRequest;
import com.Auth.Auth.entity.Utilisateur;
import com.Auth.Auth.repository.UtilisateurRepository;
import com.Auth.Auth.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UtilisateurRepository utilisateurRepository;
    private final JwtService jwtService;

    public AuthService(
            PasswordEncoder passwordEncoder,
            UtilisateurRepository utilisateurRepository,
            JwtService jwtService) {

        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
        this.jwtService = jwtService;
    }

    public Utilisateur register(UtilisateurRequest request) {

        String hashedPassword =
                passwordEncoder.encode(request.getPassword());

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNom(request.getNom());
        utilisateur.setPrenom(request.getPrenom());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setPassword(hashedPassword);

        LocalDateTime now = LocalDateTime.now();
        utilisateur.setCreatedAt(now);
        utilisateur.setUpdatedAt(now);

        return utilisateurRepository.save(utilisateur);
    }

    public AuthResponse login(LoginRequest request) {

        Utilisateur utilisateur = utilisateurRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Utilisateur introuvable"));

        boolean passwordCorrect = passwordEncoder.matches(
                request.getPassword(),
                utilisateur.getPassword()
        );

        if (!passwordCorrect) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        String token = jwtService.generateToken(
                utilisateur.getEmail()
        );

        return new AuthResponse(token);
    }
}
