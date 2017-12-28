package com.mohit.hibernate.demo;

import com.mohit.hibernate.demo.entity.Course;
import com.mohit.hibernate.demo.entity.Instructor;
import com.mohit.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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

            // create some courses
            Course tempCourse1 = new Course("Air Guitar - The ultimate guide");
            Course tempCourse2 = new Course("The pinball master class");

            // add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // save the courses
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
