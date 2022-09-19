package com.solvd;

import com.solvd.db.SingletonDatabaseConnection;
import com.solvd.entities.library.Book;
import com.solvd.entities.library.Library;
import com.solvd.entities.person.Employee;
import com.solvd.entities.person.Person;
import com.solvd.entities.person.Student;
import com.solvd.entities.person.Teacher;
import com.solvd.entities.scholarships.Scholarship;
import com.solvd.entities.university.*;
import com.solvd.enums.Career;
import com.solvd.enums.Job;
import com.solvd.enums.Status;
import com.solvd.exceptions.DepartmentNotFoundException;
import com.solvd.exceptions.StudentNotFoundException;
import com.solvd.exceptions.UnknownBookException;
import com.solvd.utils.CommonUtils;
import com.solvd.utils.CustomLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws DepartmentNotFoundException,
            UnknownBookException, StudentNotFoundException, InterruptedException, IOException, SQLException {

        //********************************************** PERSONS *******************************************************//

        Person john = new Student("john Johnson", 18, Career.BIOLOGY, Status.ACTIVE);
        Person andrew = new Student("Andrew Lopez", 22, Career.ENGINEERING, Status.ACTIVE);
        Person charles = new Student("Charles Chaplin", 23, Career.MATHEMATICS, Status.INACTIVE);
        Person juan = new Student("Juan Zappa", 17, Career.BIOLOGY, Status.SUSPENDED);
        Person steve = new Student("Steve Stevenson", 32, Career.ENGINEERING, Status.ACTIVE);
        Person chad = new Student("Chad Chadson", -1, Career.PHYSICS, Status.INACTIVE);
        Person josh = new Teacher("Josh", 29, 10);
        Person greg = new Teacher("Greg", 28, 12);
        Person gandalf = new Teacher("Gandalf", 42, 4);

        Person dave = new Employee("dave", 47, Job.DIRECTOR, Integer.parseInt(Job.DIRECTOR.getSalary()));
        Person martha = new Employee("martha", 52, Job.LIBRARIAN, Integer.parseInt(Job.LIBRARIAN.getSalary()));

        //-------------- FILLING STUDENT LIST ------------------------//

        LoadEntitiesThread t = new LoadEntitiesThread((Student) john, (Student) andrew, (Student) charles, (Student) juan, (Student) steve, (Student) chad);

        new Thread(t).start();
        Thread.sleep(5000);


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
        Course programming = new Course(t.getStudentsListByCareer(Career.ENGINEERING), engineeringTeachers, "Programming", programmingStudentGrades, 8);
        Course algebra = new Course(t.getStudentsListByCareer(Career.ENGINEERING), engineeringTeachers, "Algebra I", programmingStudentGrades, 8);
        Course web = new Course(t.getStudentsListByCareer(Career.ENGINEERING), engineeringTeachers, "Web I", programmingStudentGrades, 6);
        Course anatomy = new Course(t.getStudentsListByCareer(Career.BIOLOGY), marinebiologyTeachers, "Anatomy", biologyStudentGrade, 12);
        Course latinAmericaEconomy = new Course(t.getStudentsListByCareer(Career.MATHEMATICS), economyTeachers, "Latin America Economy XX Century", economicStudentGrade, 18);

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
        LinkedList<String> benefits = new LinkedList<>();
        benefits.add("Free bus ticket");
        benefits.add("Food discount");
        benefits.add("Photocopy discount");
        benefits.add("Computer");

        // --------------- CREATING UNIVERSITY ---------------------//
        University unicen = new PublicUniversity("UNICEN", "TANDIL", unicenDepartments, benefits);
        University fasta = new PrivateUniversity("FASTA", "BUENOS AIRES", fastaDepartments, 1500, "USD");
        //********************************************* LIBRARY *******************************************************//

        //------------ CREATING BOOKS -----------------//
        Book book1 = new Book("Java for Dummies", false, "Programming II");
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

        //******************************************** CUSTOM LINKED LIST *********************************************//
        CustomLinkedList<String> customList = new CustomLinkedList<>();
        customList.insertAtFirst("Something");
        customList.insertAtEnd("Another Benefit");

        //*************************** EXECUTION ***********************//
        Book b = library.withdrawBook("Java for Dummies");
        science.getDepartmentTotalStudents();
        System.out.println(dave.toString());


        library.returnBook(book2);
        System.out.println("there is this amount of total books in the " + library + " library : " + library.getTotalBooks());

        programming.printStudentsGrade();
        science.getDepartmentTotalStudents();

        programming.getStudentById("7");

        System.out.println(book1.hashCode());
        System.out.println(programming.hashCode());

        System.out.println(programming.hashCode());
        programming.printStudentsGrade();
        programming.printGradeByStudent((Student) steve);
        programming.printGradeByStudent((Student) john);
        programming.countStudentsByStatus(Status.ACTIVE);
        programming.countStudentsByStatus(Status.INACTIVE);
        programming.countStudentsByStatus(Status.SUSPENDED);
        System.out.println(customList);
        System.out.println(customList.getFirst().getData());
        System.out.println(customList.getLast().getData());
        System.out.println(CommonUtils.readPropertiesFile("src/main/resources/configuration.properties", "MONTHLY_STATE_SUBSIDY"));
        System.out.println(((PublicUniversity) unicen).getMonthlyStateSubsidy());
        System.out.println(((PublicUniversity) unicen).getCoinType());

        SingletonDatabaseConnection.getInstance();
        Connection s = SingletonDatabaseConnection.getConnection();
        System.out.println(s);
        Connection d = SingletonDatabaseConnection.getConnection();
        System.out.println(d);
    }

}
