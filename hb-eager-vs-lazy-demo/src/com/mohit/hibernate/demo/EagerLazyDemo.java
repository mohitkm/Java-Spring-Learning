package com.mohit.hibernate.demo;

import com.mohit.hibernate.demo.entity.Course;
import com.mohit.hibernate.demo.entity.Instructor;
import com.mohit.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String... args){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            int tempId = 1;

            // get the instructor from db
            Instructor tempInstructor = session.get(Instructor.class, tempId);

            System.out.println("luv2code: Instructor: " + tempInstructor);

            // get course for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            session.close();

            System.out.println("\nluv2code: The session is now closed! \n");

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            System.out.println("luv2code: Done!");
        }finally {
            // clean up code

            session.close();
            factory.close();
        }
    }
}
