package sk.kosickaakademia.jdbc.Artem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kosickaakademia.jdbc.Artem.demo.entity.StudentDemo;


public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentDemo.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save Java object

            // create a student object
            System.out.println("Creating new student object...");
            StudentDemo studentDemo = new StudentDemo("Paul", "Wall", "paul@gamail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(studentDemo);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
