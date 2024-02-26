package com.kavin.HibernateRelations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kavin.HibernateRelations.entity.Laptop;
import com.kavin.HibernateRelations.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Laptop lap = new Laptop();
    	lap.setLid(102);
    	lap.setLname("Dell");
    	
    	List<Laptop> list = new ArrayList<>();
    	list.add(lap);
    	List<Student> studList = new ArrayList<>();
    	Student stud = new Student();
    	stud.setMarks(99);
    	stud.setsId(1);
    	stud.setsName("Kavin");
    	stud.setLaptop(list);
    	
    	studList.add(stud);
    	lap.setStudent(studList);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);

    	SessionFactory sf = con.buildSessionFactory();

    	Session session = sf.openSession();

    	Transaction tx = session.beginTransaction();
        
        session.save(lap);
        session.save(stud);
        
        tx.commit();
    }
}
