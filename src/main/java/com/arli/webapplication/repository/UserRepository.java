package com.arli.webapplication.repository;

import com.arli.webapplication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    boolean existsByLogin(String login);
    Users getByLoginAndPassword(String login,String password);
}
