package com.solvd.interfaces.university;

public interface IDepartment {

    void shareSchedule();

    /**
     * This function returns the Total of students on a department, by iterating each CourseList on the majorList in
     * Deparment
     *
     * @return
     */
    int getDepartmentTotalStudents();
}
