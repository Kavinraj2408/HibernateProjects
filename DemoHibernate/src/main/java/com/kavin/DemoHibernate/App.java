package com.kavin.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kavin.DemoHibernate.model.Alien;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien = new Alien();
//        alien.setAid(4);
//        alien.setAname("Harsi");
//        alien.setColor("Yellow");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        alien = (Alien)session.get(Alien.class, 4);
        System.out.println(alien.toString());
//        session.save(alien);
        tx.commit();
    }
}
