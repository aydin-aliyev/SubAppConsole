package model;

import java.util.ArrayList;
import java.util.List;

public class Player extends InHouse {
    String name;
    String lastName;
    String belt;
    int age;

    public Player() {

    }

    public Player(String name, String lastName, String belt, int age) {

        this.name = name;
        this.lastName = lastName;
        this.belt = belt;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", belt='" + belt + '\'' +
                ", age=" + age +
                '}';
    }
}