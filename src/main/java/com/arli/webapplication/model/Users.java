package com.arli.webapplication.model;




import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String surname;
    private String password;
    private int age;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

//Uni-directional

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                age == users.age &&
                login.equals(users.login) &&
                surname.equals(users.surname) &&
                password.equals(users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, surname, password, age);
    }
}
