package sk.kosickaakademia.jdbc.Artem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kosickaakademia.jdbc.Artem.demo.entity.StudentDemo;


public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentDemo.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save Java object

            // create a student object
            System.out.println("Creating new student object...");
            StudentDemo studentDemo = new StudentDemo("Daffy", "Duck", "daffy@gamail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(studentDemo);

            // commit transaction
            session.getTransaction().commit();

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + studentDemo.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("Getting student with id: " + studentDemo.getId());

            StudentDemo studentDemo1 = session.get(StudentDemo.class, studentDemo.getId()); // Spring will return that student object and assign it. If not - return null

            System.out.println("Get complete: "  +studentDemo1);
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
