package com.springboot.thymeleaf.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.thymeleaf.models.entity.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	@Query("FROM User u WHERE u.name LIKE :name OR u.surname LIKE :name")
    public List<User> findByNameContaining(@Param("name") String name);

}
