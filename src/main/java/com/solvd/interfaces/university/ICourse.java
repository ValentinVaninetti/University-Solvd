package com.solvd.interfaces.university;

import com.solvd.entities.person.Student;

public interface ICourse {
    /**
     *
     * This method count all students by Status (Active or Inactive)
     *
     * @return
     */
    int countStudentsByStatus(String status);

    /**
     *
     * This method returns the Total number of students on a Course.
     *
     * @return
     */
    int getCourseTotalStudents();

    /**
     *
     * This method returns an Object Student from an Id.
     *
     * @return
     */
    Student getStudentById(String id);

    /**
     *
     * Print all the Key and Values of the Map containing Students.
     *
     */
    void printStudentsGrade();

    /**
     *
     * Print the grade for a specific Student and Course
     *
     * @param student
     */
    void printGradeByStudent(Student student);
}
