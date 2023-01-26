import com.sun.tools.javac.Main;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import persistence.entity.HibernateConfiguration;
import persistence.entity.Student;
import persistence.repository.StudentOurRepository;

import java.util.List;
import java.util.Map;


public class HibernateApplication {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
        var sessionFactory = ctx.getBean(SessionFactory.class);
        var session = sessionFactory.openSession();

        var student1 = new Student();
        student1.setName("Omelchenko");
        student1.setEmail("natom654@gmail.com");

        var student2 = new Student();
        student2.setName("Ivanov");
        student2.setEmail("natom@gmail.com");

        var student3 = new Student();
        student2.setName("Petrov");
        student2.setEmail("nat@gmail.com");

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);

        Query query = session.createQuery("students");
        List<Student> studentList = (query).list();
        for (Student student : studentList) {
            System.out.println("List of Students : " + student.getId() + "," + student.getName() + ",");
        }

        session.detach(student1);
        session.close();
    }
}