package com.mohit.hibernate.demo;

import com.mohit.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {
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
            int theId = 1;
            Student theStudent = session.get(Student.class, theId);
            System.out.println("\nLoaded student: " + theStudent);
            System.out.println("Courses of student: " + theStudent.getCourses());

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
