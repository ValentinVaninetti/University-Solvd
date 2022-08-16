package com.solvd.entities.university;

import com.solvd.entities.person.Student;
import com.solvd.interfaces.university.IMajor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.UUID;

public class Major implements IMajor {
    private static final Logger LOGGER = LogManager.getLogger(Major.class);
    private String id = UUID.randomUUID().toString();
    private String majorName;
    private List<Course> courselist;

    public Major(String majorName, List<Course> courseList) {
        this.majorName = majorName;
        this.courselist = courseList;
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

    public List<Course> getCourselist() {
        return courselist;
    }

    public void setCourselist(List<Course> courselist) {
        this.courselist = courselist;
    }

    @Override
    public String toString() {
        return getClass().getName() + " of " + this.majorName + "\n" + "Students: ";
    }

    @Override
    public void careerProgress(Student student) {

    }
}
