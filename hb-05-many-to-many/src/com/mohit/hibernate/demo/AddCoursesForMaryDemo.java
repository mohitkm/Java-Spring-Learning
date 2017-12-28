package com.mohit.hibernate.demo;

import com.mohit.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
    public static void main(String... args){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // get the student mary from database
            int theId = 2;
            Student theStudent = session.get(Student.class, theId);
            System.out.println("\nLoaded student: " + theStudent);
            System.out.println("Courses of student: " + theStudent.getCourses());

            // create more courses
            Course tempCourse1 = new Course("Rubik's cube -- how to speed cube");
            Course tempCourse2 = new Course("Atari 2600 - Game development");


            // add student to courses
            tempCourse1.addStudent(theStudent);
            tempCourse2.addStudent(theStudent);

            // save the courses
            System.out.println("\nSaving the courses....");
            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
            // clean up code

            session.close();
            factory.close();
        }
    }
}
