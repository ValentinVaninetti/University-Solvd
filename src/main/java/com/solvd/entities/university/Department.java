package com.solvd.entities.university;

import com.solvd.interfaces.university.IDepartment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class Department implements IDepartment {
    private static final Logger LOGGER = LogManager.getLogger(Department.class);
    private String type;
    private List<Major> majors;

    public Department(String type, List<Major> majors) {
        this.type = type;
        this.majors = majors;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(Object obj) {
        return this.type;
    }

    @Override
    public int getDepartmentTotalStudents() {
        int count = 0;
        for (Major m : this.majors) {
            for (Course c : m.getCourselist()) {
                count += c.getCourseTotalStudents();
            }
        }
        this.LOGGER.info("The number of students in " + this.type + " is: " + count);
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Department) {
            return (this.type.equals(((Department) obj).getType()));
        } else {
            return false;
        }
    }

    @Override
    public void shareSchedule() {

    }
}
