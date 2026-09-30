package com.Auth.Auth.entity;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "role",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_role_name",
                        columnNames = "name"
                )
        }
)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Utilisateur> utilisateurs = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();

    // getters et setters
}
