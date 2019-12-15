package com.arli.webapplication.service;

import com.arli.webapplication.model.Animals;
import com.arli.webapplication.model.Users;

import java.util.List;

public interface AnimalsService {
    List<Animals> getAllByUsers(Users Users);
    void update(Animals animals);
    void save(Animals animals);
    void delete(int id);
}
