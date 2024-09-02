package com.springsecurity.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
