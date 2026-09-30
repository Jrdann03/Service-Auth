package com.Auth.Auth.entity;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "permission",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_permission_name",
                        columnNames = "name"
                )
        }
)
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    // getters et setters
}

