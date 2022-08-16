package com.solvd.entities.university;

import com.solvd.exceptions.DepartmentNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class University {
    protected Logger LOGGER;
    protected String name;
    protected String location;
    protected List<Department> departmentList;

    public University(String name, String location, List<Department> departmentList) {
        this.name = name;
        this.location = location;
        this.departmentList = departmentList;
    }

    protected List<Department> getDepartmentList() {
        return departmentList;
    }

    protected void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    protected void setLocation(String location) {
        this.location = location;
    }

    protected String getLocation() {
        return location;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getTotalStudents() {
        this.LOGGER = LogManager.getLogger(University.class);
        int countAllStudents = getCountAllStudents();
        this.LOGGER.info("The number of students in this university " + this.name + " located at " + this.location + " is: " + countAllStudents);
        return countAllStudents;
    }

    private int getCountAllStudents() {
        int countAllStudents = 0;
        for (Department d : this.departmentList) {
            countAllStudents += d.getDepartmentTotalStudents();
        }
        return countAllStudents;
    }

    protected void removeDepartment(Department department) throws DepartmentNotFoundException {
        this.LOGGER = LogManager.getLogger(University.class);
        if (!this.departmentList.contains(department)) {
            this.LOGGER.error("Something went wrong when trying to remove " + department.getType() + " from DepartmentList.");
            throw new DepartmentNotFoundException("Department not found on the List");
        }
        this.departmentList.remove(department);
        this.LOGGER.info("Succesfully removed " + department.getType() + " from list");

    }
}
