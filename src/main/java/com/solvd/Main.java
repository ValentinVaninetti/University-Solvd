package com.solvd;

import com.solvd.entities.library.Book;
import com.solvd.entities.library.Library;
import com.solvd.entities.person.Employee;
import com.solvd.entities.person.Person;
import com.solvd.entities.person.Student;
import com.solvd.entities.person.Teacher;
import com.solvd.entities.scholarships.Scholarship;
import com.solvd.entities.university.*;
import com.solvd.exceptions.DepartmentNotFoundException;
import com.solvd.exceptions.StatusNotAllowedException;
import com.solvd.exceptions.UnknownBookException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws DepartmentNotFoundException,
            StatusNotAllowedException,
            UnknownBookException
             {

        //********************************************** PERSONS *******************************************************//

        Person john = new Student("john Johnson", 18, "Biology", "Active");
        Person andrew = new Student("Andrew Lopez", 22, "System Engineer", "Active");
        Person charles = new Student("Charles Chaplin", 23, "Mathematics", "Active");
        Person juan = new Student("Juan Zappa", 17, "Physics", "Inactive");
        Person steve = new Student("Steve Stevenson", 32, "System Engineer", "Inactive");
        Person chad = new Student("Chad Chadson", -1, "Football", "Active");

        Person josh = new Teacher("Josh", 29, 10);
        Person greg = new Teacher("Greg", 28, 12);
        Person gandalf = new Teacher("Gandalf", 42, 4);

        Person dave = new Employee("dave", 47);
        Person martha = new Employee("martha", 52);

        //-------------- FILLING STUDENT LIST ------------------------//
        List<Person> allStudents = new ArrayList<>();
        allStudents.add(john);
        allStudents.add(andrew);
        allStudents.add(charles);
        allStudents.add(juan);
        allStudents.add(steve);
        allStudents.add(chad);

        List<Student> engineeringStudents = new ArrayList<>();
        engineeringStudents.add((Student) andrew);
        engineeringStudents.add((Student) steve);

        List<Student> marineBiologyStudents = new ArrayList<>();
        marineBiologyStudents.add((Student) juan);
        marineBiologyStudents.add((Student) chad);

        List<Student> economyStudents = new ArrayList<>();
        economyStudents.add((Student) charles);
        economyStudents.add((Student) john);

        //--------------- FILLING TEACHER LIST ----------------------//

        List<Teacher> marinebiologyTeachers = new ArrayList<>();
        marinebiologyTeachers.add((Teacher) josh);
        marinebiologyTeachers.add((Teacher) gandalf);

        List<Teacher> engineeringTeachers = new ArrayList();
        engineeringTeachers.add((Teacher) gandalf);

        List<Teacher> economyTeachers = new ArrayList<>();
        economyTeachers.add((Teacher) greg);

        //------------- FILLING COURSE LIST --------------//
        List<Course> engineeringCourseList = new ArrayList<>();


        //********************************************** UNIVERSITY *******************************************************//

        //-------------------- COURSES -------------------//
        Map<Student, Integer> programmingStudentGrades = new HashMap<>();
        programmingStudentGrades.put((Student) andrew, 8);
        programmingStudentGrades.put((Student) steve, 5);

        Map<Student, Integer> biologyStudentGrade = new HashMap<>();
        biologyStudentGrade.put((Student) john, 6);

        Map<Student, Integer> economicStudentGrade = new HashMap<>();
        economicStudentGrade.put((Student) charles, 9);

        //----------- CREATING COURSES -------------------//
        Course programming = new Course(engineeringStudents, engineeringTeachers, "Programming", programmingStudentGrades, 8);
        Course algebra = new Course(engineeringStudents, engineeringTeachers, "Algebra I", programmingStudentGrades, 8);
        Course web = new Course(engineeringStudents, engineeringTeachers, "Web I", programmingStudentGrades, 6);
        Course anatomy = new Course(marineBiologyStudents, marinebiologyTeachers, "Anatomy", biologyStudentGrade, 12);
        Course latinAmericaEconomy = new Course(economyStudents, economyTeachers, "Latin America Economy XX Century", economicStudentGrade, 18);

        //-----FILLING COURSE LIST -------//
        List<Course> engineeringCourses = new ArrayList<>();
        engineeringCourses.add(programming);
        engineeringCourses.add(algebra);
        engineeringCourses.add(web);

        List<Course> biologyCourses = new ArrayList<>();
        biologyCourses.add(anatomy);

        List<Course> economyCourses = new ArrayList<>();
        economyCourses.add(latinAmericaEconomy);

        //--------------- CREATING MAJOR ---------//
        Major systemEngineer = new Major("System Engineering", engineeringCourses);
        Major marineBiology = new Major("Marine Biology", biologyCourses);
        Major accountant = new Major("Certified Public Accountant", economyCourses);

        //--------------- FILLING MAJORS LISTS -----------------------//
        List<Major> scienceMajors = new ArrayList<>();
        scienceMajors.add(marineBiology);
        scienceMajors.add(systemEngineer);

        List<Major> accountantMajors = new ArrayList<>();
        accountantMajors.add(accountant);

        //--------------- CREATING DEPARTMENT ----------//
        Department science = new Department("Mathematics", scienceMajors);
        Department economy = new Department("Economy", accountantMajors);
        Department test = new Department("test", accountantMajors);
        Department test2 = new Department(null, null);

        //--------------- FILLING DEPARTMENTS LISTS ----------------//
        List<Department> unicenDepartments = new ArrayList<>();
        unicenDepartments.add(science);

        List<Department> fastaDepartments = new ArrayList<>();
        fastaDepartments.add(economy);

        //--------------- FILLING BENEFITS LIST ----------------//
        List<String> benefits = new ArrayList<>();
        benefits.add("something");

        // --------------- CREATING UNIVERSITY ---------------------//
        University unicen = new PublicUniversity("UNICEN", "TANDIL", unicenDepartments, benefits);
        University fasta = new PrivateUniversity("FASTA", "BUENOS AIRES", fastaDepartments, 1500, "USD");

        //********************************************* LIBRARY *******************************************************//

        //------------ CREATING BOOKS -----------------//
        Book book1 = new Book("Java for Dummies", true, "Programming II");
        Book book2 = new Book("The importance of having a liver", true, "Science");
        Book book3 = new Book("How to get to the end of the month", false, "Economics");

        //------------ FILLING BOOK LIST -------------//
        List<Book> bookList = new ArrayList<>();
        bookList.add(book2);
        bookList.add(book3);

        List<Book> booklist2 = new ArrayList<>();
        booklist2.add(book1);

        //-------------- CREATING LIBRARIES --------------//
        Library library = new Library(bookList, "Fasta");
        Library library2 = new Library(booklist2, "Unicen");

        //********************************************** SCHOLARSHIPS *****************************************************//
        Scholarship scholarship = new Scholarship("test", "test");
        //should check if student is available to get a scholarship, but i will need some grades class, student wage
        //

        //*************************** EXECUTION ***********************//
        library.withdrawBook("Java for Dummies");
        library.returnBook(book2);
        System.out.println("there is this amount of total books in the " + library + " library : " + library.getTotalBooks());

        programming.printStudentsGrade();
        science.getDepartmentTotalStudents();

        programming.getStudentById("7");

         System.out.println(book1.hashCode());
         System.out.println(programming.hashCode());

         System.out.println(programming.hashCode());
         programming.countStudentsByStatus(" ");
         programming.printStudentsGrade();
                 programming.printGradeByStudent((Student)steve);
                 programming.printGradeByStudent((Student) john);

    }

}
