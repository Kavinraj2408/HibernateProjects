package com.kavin.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.kavin.DemoHibernate.model.Alien;
import com.kavin.DemoHibernate.model.AlienName;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AlienName an = new AlienName();
//    	an.setfName("Harsi");
//    	an.setlName("Prathap");
        Alien alien = new Alien();
//        alien.setAid();
//        alien.setAname(an);
//        alien.setColor("Yellow");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session1 = sf.openSession();
        
        Transaction tx = session1.beginTransaction();
        
//        alien = (Alien)session1.get(Alien.class, 4);
        
        Query q1 = session1.createQuery("from Alien where aid = '4'");
        q1.setCacheable(true);
        alien = (Alien)q1.uniqueResult();
        System.out.println(alien.toString());
        tx.commit();
        session1.close();
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
//        alien = session2.get(Alien.class, 4);

        Query q2 = session2.createQuery("from Alien where aid = '4'");
        q2.setCacheable(true);
        alien = (Alien)q2.uniqueResult();
        System.out.println(alien);
        session2.getTransaction().commit();
        session2.close();
        
//        session.save(alien);
        
    }
}
