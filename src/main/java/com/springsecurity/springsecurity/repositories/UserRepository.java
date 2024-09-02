package com.springsecurity.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
