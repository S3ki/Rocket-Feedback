package Dao;

import Entity.Kurssi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class KurssiDao {


    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FeedbackMariaDbUnit");
    public void persist(Kurssi opEmp){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(opEmp);
        em.getTransaction().commit();
    }
    public Kurssi find (int id){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        Kurssi opEmp = em.find(Kurssi.class, id);
        System.out.println(opEmp.getName() + " " + opEmp.getLangCode());
        return opEmp;
    }

    public void update(Kurssi opEmp){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(opEmp);
        em.getTransaction().commit();
    }

    public void delete(int id){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        Kurssi opEmp = em.find(Kurssi.class, id);
        em.getTransaction().begin();
        em.remove(opEmp);
        em.getTransaction().commit();
    }

}
