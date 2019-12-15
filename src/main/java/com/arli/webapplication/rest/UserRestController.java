package com.arli.webapplication.rest;


import com.arli.webapplication.model.Animals;
import com.arli.webapplication.model.Users;
import com.arli.webapplication.service.AnimalsService;
import com.arli.webapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/test/")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnimalsService animalsService;
    public Timer timer;
    public int count = 10;
    public int seconds  = 3600;




    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveUser(@RequestBody @Valid Users users){
        if(users.getLogin() == null && users.getPassword() == null){
            return new ResponseEntity("Login and Password are required",HttpStatus.NOT_ACCEPTABLE);
        }
        else if(!userService.existsByLogin(users.getLogin())){
            return new ResponseEntity("Login already in use" ,HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            this.userService.save(users);
            return new ResponseEntity(users, HttpStatus.CREATED);
        }
    }



    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "existsByUsername", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> existsByUsername(@RequestBody Users users){
        System.out.println(users.getLogin());
        if (!userService.existsByLogin(users.getLogin())){
            return new ResponseEntity<>("Login already in use",HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            return new ResponseEntity<Object>(true,HttpStatus.OK);
        }

    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "signIn", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity signIn(@RequestBody @Valid Users users){
        Users users1 =  userService.signIn(users.getLogin(),users.getPassword());
        if(users1 == null){
            count--;
            if(count < 1){
                return new ResponseEntity(count,HttpStatus.REQUEST_TIMEOUT);
            }
            else if(count == 9){
                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        seconds--;
                        System.out.println(seconds);

                        if(seconds == 0){
                            System.out.println(count);
                            timer.stop();
                            count = 10;
                            seconds = 3600;
                        }

                    }
                });
                timer.start();
            }
            return new ResponseEntity(count,HttpStatus.UNAUTHORIZED);
        }
        else {
            count = 10;
            return new ResponseEntity<Object>(users1, HttpStatus.OK);
        }



    }



    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "animals", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Animals>> animals(@RequestBody Users users){

        List<Animals> animalsList = animalsService.getAllByUsers(users);
        return new ResponseEntity<>(animalsList ,HttpStatus.OK);

    }



    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "animals/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity animalsUpdate(@RequestBody Animals animals){
        if(animals.getNickname().equals("") || animals.getDate() == null || animals.getAnimalGender() == null){
            return new ResponseEntity( "All fields are required ",HttpStatus.NOT_ACCEPTABLE);
        }
        else
        {
            System.out.println(animals.getAnimalGender());
            animalsService.save(animals);
            return new ResponseEntity(HttpStatus.OK);
        }
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "animalsDelete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity animalsDelete(@PathParam("id") @PathVariable int id){
        if(id == 0){
            return new ResponseEntity( "Wrong animal selected",HttpStatus.BAD_REQUEST);
        }
        else {
            animalsService.delete(id);
            return new ResponseEntity(true,HttpStatus.OK);
        }

    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "animals/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity animalsSave(@RequestBody Animals animals){
        if(animals.getDate() == null || animals.getNickname() == null){
            return new ResponseEntity("All fields are required",HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            animalsService.save(animals);
            return new ResponseEntity(true,HttpStatus.CREATED);
        }
    }




}
