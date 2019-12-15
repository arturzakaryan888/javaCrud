package com.arli.webapplication.service;

import com.arli.webapplication.model.Users;
import com.arli.webapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Users getById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public void save(Users users) {
            userRepository.save(users);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);


    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(Users users) {
        userRepository.save(users);
    }

    @Override
    public boolean existsByLogin(String login) {
        if(userRepository.existsByLogin(login)){
            return false;
        }
        else {
            return true;
        }

    }

    public Users signIn(String login, String password) {
        Users users = userRepository.getByLoginAndPassword(login, password);
        return users;

    }
}
