package com.solvd;


import com.solvd.entities.person.Student;
import com.solvd.enums.Career;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoadEntitiesThread implements Runnable {
    private List<Student> studentsList = new ArrayList<>();

    public LoadEntitiesThread(Student... student) {
        for (Student s : student) {
            studentsList.add(s);
            System.out.println(s.getName());
        }
        System.out.println("List succesfully loaded");
    }

    public List<Student> getStudentsListByCareer(Career filter) {
        return this.studentsList.stream()
                .filter(student -> student.getCareer().equals(filter))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudents() {
        return studentsList;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            this.studentsList.toString();
            System.out.println("ending");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
