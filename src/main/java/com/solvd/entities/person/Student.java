package com.solvd.entities.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Student.class);
    private String career;
    private String status;

    public Student(String name,int age, String career, String status) {
        super(name,age);
        this.career = career;
        this.status = status;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        LOGGER.info("Student : " + this.getName() + " With id: " + this.getId() + " its: " + this.status + " This career: " + this.career);
        return "Student : " + this.getName() + " With id: " + this.getId() + " its: " + this.status + " This career: " + this.career;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return ((this.getName().equals(((Student) obj).getName())) && (this.getId().equals(((Student) obj).getId())));
        } else {
            return false;
        }
    }
}
