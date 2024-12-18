package Dao;

import Entity.Opettaja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OpettajaDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FeedbackMariaDbUnit");
    public void persist(Opettaja opEmp){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(opEmp);
        em.getTransaction().commit();
    }
    public Opettaja find (int id){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        Opettaja opEmp = em.find(Opettaja.class, id);
        System.out.println(opEmp.getFirstName() + " " + opEmp.getLastName());
        return opEmp;
    }

    public void update(Opettaja opEmp){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(opEmp);
        em.getTransaction().commit();
    }

    public void delete(int id){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        Opettaja opEmp = em.find(Opettaja.class, id);
        em.getTransaction().begin();
        em.remove(opEmp);
        em.getTransaction().commit();
    }
}
