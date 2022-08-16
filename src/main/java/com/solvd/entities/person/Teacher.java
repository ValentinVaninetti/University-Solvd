package com.solvd.entities.person;

public class Teacher extends Person {

    private int experience;

    public Teacher(String name,int age, int experience) {
        super(name,age);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return this.getName() + "has" + this.getExperience() + "Years of Experience";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Teacher) {
            return ((this.getName().equals(((Teacher) obj).getName())) && (this.getId().equals(((Teacher) obj).getId())));
        } else {
            return false;
        }
    }
}
