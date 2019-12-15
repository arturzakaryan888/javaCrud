package com.arli.webapplication.repository;

import com.arli.webapplication.model.Animals;
import com.arli.webapplication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalsRepository extends JpaRepository<Animals,Integer> {
    List<Animals> getAllByUsers(Users users);
}
