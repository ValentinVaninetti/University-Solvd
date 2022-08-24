package com.solvd.enums;

public enum Job {
    CONCIERGE("5000"),
    DIRECTOR("10000"),
    CLEANING("6000"),
    PRECEPTOR("7000"),
    LIBRARIAN("8000"),
    COOK("7500");

    private final String salary;

    private Job(String salary) {
        this.salary = salary;
    }

    public String getSalary() {
        return this.salary;
    }
}
