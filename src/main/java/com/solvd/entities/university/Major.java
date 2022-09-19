package com.solvd.entities.university;

import com.solvd.entities.person.Student;
import com.solvd.interfaces.university.IMajor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.UUID;

public class Major implements IMajor {
    private String id = UUID.randomUUID().toString();
    private String majorName;
    private List<Course> courseList;

    public Major(String majorName, List<Course> courseList) {
        this.majorName = majorName;
        this.courseList = courseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return getClass().getName() + " of " + this.majorName + "\n" + "Students: ";
    }

    @Override
    public void careerProgress(Student student) {

    }
}
