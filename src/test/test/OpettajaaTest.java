import Entity.Opettaja;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OpettajaaTest {

    @Test
    public void testConstructorWithParameters() {
        // Create an Opettaja object with constructor
        Opettaja opettaja = new Opettaja("Matti", "Meikäläinen", "matti.meikalainen@example.com");

        // Validate the constructor works as expected
        assertEquals("Matti", opettaja.getFirstName());
        assertEquals("Meikäläinen", opettaja.getLastName());
        assertEquals("matti.meikalainen@example.com", opettaja.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        // Create an Opettaja object using no-args constructor
        Opettaja opettaja = new Opettaja();

        // Use setters to assign values
        opettaja.setFirstName("Anna");
        opettaja.setLastName("Virtanen");
        opettaja.setEmail("anna.virtanen@example.com");

        // Validate that the getters return the correct values
        assertEquals("Anna", opettaja.getFirstName());
        assertEquals("Virtanen", opettaja.getLastName());
        assertEquals("anna.virtanen@example.com", opettaja.getEmail());
    }

    @Test
    public void testEmailSetterAndGetter() {
        // Create an Opettaja object
        Opettaja opettaja = new Opettaja("John", "Doe", "john.doe@example.com");

        // Change the email
        opettaja.setEmail("new.email@example.com");

        // Validate the email is updated
        assertEquals("new.email@example.com", opettaja.getEmail());
    }

    @Test
    public void testDefaultConstructor() {
        // Create an Opettaja object using the no-args constructor
        Opettaja opettaja = new Opettaja();

        // Validate that all fields are null
        assertNull(opettaja.getFirstName());
        assertNull(opettaja.getLastName());
        assertNull(opettaja.getEmail());
    }
}

