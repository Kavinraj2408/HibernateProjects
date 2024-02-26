package com.kavin.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
    	an.setfName("Harsi");
    	an.setlName("Prathap");
        Alien alien = new Alien();
//        alien.setAid();
        alien.setAname(an);
        alien.setColor("Green");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
//        alien = (Alien)session.get(Alien.class, 4);
//        System.out.println(alien.toString());
        session.save(alien);
        tx.commit();
    }
}
