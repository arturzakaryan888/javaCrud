package com.arli.webapplication.service;

import com.arli.webapplication.model.Animals;
import com.arli.webapplication.model.Users;
import com.arli.webapplication.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalsServiceRepository implements AnimalsService {

    @Autowired
    AnimalsRepository animalsRepository;
    @Override
    public List<Animals> getAllByUsers(Users users) {
        return animalsRepository.getAllByUsers(users) ;
    }

    @Override
    public void update(Animals animals) {
        animalsRepository.save(animals);
    }

    @Override
    public void save(Animals animals) {
        animalsRepository.save(animals);
    }

    @Override
    public void delete(int id) {
        animalsRepository.delete(id);
    }
}
