--Création de la table utilisateur contient tous les utilisateurs (admin, clients, etc...)
CREATE TABLE utilisateur (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uk_utilisateur_email UNIQUE (email)
);


CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,

    CONSTRAINT uk_role_name UNIQUE (name)
);


CREATE TABLE permission (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,

    CONSTRAINT uk_permission_name UNIQUE (name)
);


CREATE TABLE utilisateur_role (
    utilisateur_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,

    CONSTRAINT pk_utilisateur_role
        PRIMARY KEY (utilisateur_id, role_id),

    CONSTRAINT fk_utilisateur_role_utilisateur
        FOREIGN KEY (utilisateur_id)
        REFERENCES utilisateur(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_utilisateur_role_role
        FOREIGN KEY (role_id)
        REFERENCES role(id)
        ON DELETE CASCADE
);


CREATE TABLE role_permission (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,

    CONSTRAINT pk_role_permission
        PRIMARY KEY (role_id, permission_id),

    CONSTRAINT fk_role_permission_role
        FOREIGN KEY (role_id)
        REFERENCES role(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_role_permission_permission
        FOREIGN KEY (permission_id)
        REFERENCES permission(id)
        ON DELETE CASCADE
);
