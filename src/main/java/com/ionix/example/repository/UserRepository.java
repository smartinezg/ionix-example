package com.ionix.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ionix.example.persistence.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findByEmail(@Param("email") String email);
}