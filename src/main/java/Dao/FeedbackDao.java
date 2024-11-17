package Dao;

import Entity.Feedback;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FeedbackDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FeedbackMariaDbUnit");
    public void persist(Feedback opEmp){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(opEmp);
        em.getTransaction().commit();
    }
    public Feedback find (int id){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        Feedback opEmp = em.find(Feedback.class, id);
        System.out.println(opEmp.getComment() + " " + opEmp.getLangCode());
        return opEmp;
    }

    public void update(Feedback opEmp){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(opEmp);
        em.getTransaction().commit();
    }

    public void delete(int id){
        EntityManager em = Datasource.MariaDbJpaConnection.getInstance();
        Feedback opEmp = em.find(Feedback.class, id);
        em.getTransaction().begin();
        em.remove(opEmp);
        em.getTransaction().commit();
    }
}
