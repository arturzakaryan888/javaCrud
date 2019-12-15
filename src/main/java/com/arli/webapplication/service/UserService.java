package com.arli.webapplication.service;

import com.arli.webapplication.model.Animals;
import com.arli.webapplication.model.Users;

import java.util.List;

public interface UserService {
    Users getById(int id);
    void save(Users users);
    void delete(int id);
    List<Users> getAll();
    void update(Users users);
    boolean existsByLogin(String login);
    Users signIn(String login,String password);
}
