package com.solvd.entities.university;

import com.solvd.entities.person.Student;
import com.solvd.entities.person.Teacher;
import com.solvd.enums.Status;
import com.solvd.exceptions.StudentNotFoundException;
import com.solvd.interfaces.university.ICourse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Course implements ICourse {
    private static final Logger LOGGER = LogManager.getLogger(Course.class);
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private String courseName;
    private Map<Student, Integer> studentGrade;
    private int hoursPerWeek;


    public Course(List<Student> studentList, List<Teacher> teacherList,
                  String courseName, Map<Student, Integer> studentGrade, int hoursPerWeek) {
        this.studentList = studentList;
        this.teacherList = teacherList;
        this.courseName = courseName;
        this.studentGrade = studentGrade;
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Map<Student, Integer> getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Map<Student, Integer> studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, studentGrade, hoursPerWeek);
    }

    @Override
    public Student getStudentById(String id) {
        if (id != null) {
            for (Student s : studentList) {
                if (s.getId().equals(id)) {
                    return s;
                }
            }
        }
        LOGGER.info("The Student with id: " + id + " is not found.");
        return null;
    }

    @Override
    public int countStudentsByStatus(Status status) {
        if (this.studentList != null) {
            int total = 0;
            for (Student s : studentList) {
                if (s.getStatus() == status) {
                    total++;
                }
            }
            LOGGER.info("The Total of " + status + " students " + "in the Course of " + this.courseName + " is: " + total);
            return total;
        }
        LOGGER.info("There are no Students with the status: " + status);
        return 0;
    }

    @Override
    public int getCourseTotalStudents() {
        return this.studentList != null ? this.studentList.size() : 0;
    }

    @Override
    public void printStudentsGrade() {
        for (Student s : this.studentGrade.keySet()) {
            int value = this.studentGrade.get(s);
            LOGGER.info(s.getName() + " got a: " + value);
        }
    }

    @Override
    public void printGradeByStudent(Student student) throws StudentNotFoundException {
        if (student != null) {
            if (studentGrade.containsKey(student)) {
                int grade = this.studentGrade.get(student);
                LOGGER.info("The student " + student.getName() + " with id: " + student.getId() + " got a: " + grade + " in " + this.getCourseName());
            } else {
                LOGGER.info("STUDENT NOT FOUND");
            }
        } else {
            throw new StudentNotFoundException("Student not found");
        }

    }

}
