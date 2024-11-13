import static org.junit.jupiter.api.Assertions.*;

import Model.FeedBack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class FeedBackTest {

    private FeedBack feedback;

    @BeforeEach
    public void setUp() {
        feedback = new FeedBack("Great course!"); // Setup with an example feedback
        assertEquals("Great course!", feedback.getPalaute());
    }

    @Test
    public void testConstructor() {
        // Check that the constructor correctly sets the feedback message
        assertEquals("Great course!", feedback.getPalaute());
    }

    @Test
    public void testGetPalaute() {
        // Ensure the getter method returns the correct feedback
        assertEquals("Great course!", feedback.getPalaute());
    }
}

