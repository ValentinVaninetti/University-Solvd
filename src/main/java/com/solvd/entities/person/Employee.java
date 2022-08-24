package com.solvd.entities.person;

import com.solvd.enums.Job;

public class Employee extends Person {
    private Job job;
    private int salary;

    public Employee(String name, int age, Job job, int salary) {
        super(name, age);
        this.job = job;
        this.salary = salary;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "job=" + job +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
