import Model.Kurssi;
import Model.Opettaja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpettajaTest {

    private Opettaja opettaja;

    @BeforeEach
    void setUp() {
        opettaja = new Opettaja("John Doe");
    }

    @Test
    void shouldReturnCorrectTeacherName() {
        assertEquals("John Doe", opettaja.getNimi());
    }



}