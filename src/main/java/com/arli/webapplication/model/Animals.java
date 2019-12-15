package com.arli.webapplication.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.util.converter.LocalDateStringConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Animals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nickname;

    @DateTimeFormat
    private Date date;

    public AnimalGender getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(AnimalGender animalGender) {
        this.animalGender = animalGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return id == animals.id &&
                Objects.equals(nickname, animals.nickname) &&
                Objects.equals(date, animals.date) &&
                animalGender == animals.animalGender &&
                Objects.equals(users, animals.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, date, animalGender, users);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", date=" + date +
                ", animalGender=" + animalGender +
                ", users=" + users +
                '}';
    }

    @Enumerated
    private AnimalGender animalGender;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JoinColumn(name = "users_id",  referencedColumnName = "id")
    @ManyToOne
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
