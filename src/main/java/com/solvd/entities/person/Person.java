package com.solvd.entities.person;

import java.util.UUID;

public abstract class Person {
    protected String name;
    protected final String id = UUID.randomUUID().toString();
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object person) {
        if (person instanceof Person) {
            return (this.name.equals(((Person) person).getName()) && this.id.equals(((Person) person).getId()));
        } else {
            return false;
        }
    }


}
