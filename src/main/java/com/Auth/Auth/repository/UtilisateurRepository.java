package com.Auth.Auth.repository;

import java.util.Optional;


import com.Auth.Auth.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    boolean existsByEmail(String email);
    Optional<Utilisateur> findByEmail(String email);

}
