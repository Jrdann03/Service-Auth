package com.Auth.Auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "utilisateur",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_utilisateur_email",
                        columnNames = "email"
                )
        }
)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 100)
    private String prenom;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utilisateur_role",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // getters et setters
}
