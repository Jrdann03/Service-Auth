package com.Auth.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Auth.Auth.entity.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
