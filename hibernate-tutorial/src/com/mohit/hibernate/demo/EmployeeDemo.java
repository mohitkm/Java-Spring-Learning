package com.mohit.hibernate.demo;

import com.mohit.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDemo {
    public static void main(String... args){
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // create session object
        Session session = factory.getCurrentSession();

        try{
            // Save a few Employee objects to the DB
            Employee tempEmpl1 = new Employee("John", "Doe", "Google");
            Employee tempEmpl2 = new Employee("Khushi", "Patel", "IBM");
            Employee tempEmpl3 = new Employee("Shrinidhi", "Seshadri", "Thousand Eyes");
            Employee tempEmpl4 = new Employee("Pani Aravind", "Kondudu Venkata", "Visa");
            Employee tempEmpl5 = new Employee("Mohit", "Mulchandani", "MongoDB");

            session.beginTransaction();

            session.save(tempEmpl1);
            session.save(tempEmpl2);
            session.save(tempEmpl3);
            session.save(tempEmpl4);
            session.save(tempEmpl5);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee myEmployee = session.get(Employee.class, 1);

            session.getTransaction().commit();

            System.out.println("Employee with id=1");
            System.out.println(myEmployee);

            session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> emplList = session.createQuery("from Employee where company = 'IBM'")
                    .getResultList();

            for(Employee empl: emplList){
                System.out.println(empl);
            }

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee toBeDeleted = session.get(Employee.class, 1);

            session.delete(toBeDeleted);

            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}
