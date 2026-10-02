package com.Auth.Auth.service;

import com.Auth.Auth.dto.UtilisateurRequest;
import com.Auth.Auth.entity.Utilisateur;
import com.Auth.Auth.repository.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;

    private final UtilisateurRepository utilisateurRepository;

    public AuthService(
            PasswordEncoder passwordEncoder,
            UtilisateurRepository utilisateurRepository) {

        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
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


}