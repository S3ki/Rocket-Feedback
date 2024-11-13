import static org.junit.jupiter.api.Assertions.*;
import Dao.OpettajaDao;
import Entity.Opettaja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;


public class OperettaDaoTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private OpettajaDao dao;

    @BeforeAll
    public static void setupClass() {
        emf = Persistence.createEntityManagerFactory("RocketFeedPU");
    }

    @BeforeEach
    public void setup() {
        em = emf.createEntityManager();
        dao = new OpettajaDao();
    }

    @AfterEach
    public void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @AfterAll
    public static void tearDownClass() {
        emf.close();
    }

    @Test
    public void testPersist() {
        Opettaja op = new Opettaja();
        op.setFirstName("John");
        op.setLastName("Doe");

        em.getTransaction().begin();
        dao.persist(op);
        em.getTransaction().commit();

        Opettaja found = em.find(Opettaja.class, op.getId());
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
        assertEquals("Doe", found.getLastName());
    }
    @Test
    public void testFind() {
        Opettaja op = new Opettaja();
        op.setFirstName("Jane");
        op.setLastName("Doe");
        op.setEmail("jane.doe@example.com");

        em.getTransaction().begin();
        em.persist(op);
        em.getTransaction().commit();

        Opettaja found = dao.find(op.getId());
        assertNotNull(found);
        assertEquals("Jane", found.getFirstName());
        assertEquals("Doe", found.getLastName());
        assertEquals("jane.doe@example.com", found.getEmail());
    }
    @Test
    public void testUpdate() {
        Opettaja op = new Opettaja();
        op.setFirstName("Alice");
        op.setLastName("Smith");
        op.setEmail("alice.smith@example.com");

        em.getTransaction().begin();
        em.persist(op);
        em.getTransaction().commit();

        op.setFirstName("Alicia");
        op.setEmail("alicia.smith@example.com");
        dao.update(op);

        Opettaja found = em.find(Opettaja.class, op.getId());
        assertEquals("Alicia", found.getFirstName());
        assertEquals("Smith", found.getLastName());
        assertEquals("alicia.smith@example.com", found.getEmail());
    }
    @Test
    public void testDelete() {
        Opettaja op = new Opettaja();
        op.setFirstName("Bob");
        op.setLastName("Brown");
        op.setEmail("bob.brown@example.com");

        em.getTransaction().begin();
        em.persist(op);
        em.getTransaction().commit();

        dao.delete(op.getId());

        Opettaja found = em.find(Opettaja.class, op.getId());
        assertNull(found);
    }

}
