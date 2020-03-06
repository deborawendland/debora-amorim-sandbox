package com.deborawendland.petstore.model;

public class Pet {

    private String name;
    private String race;
    private int age;

    public Pet(String name, String race, int age) {
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nRace: " + race +
                "\nAge: " + age;
    }
}
