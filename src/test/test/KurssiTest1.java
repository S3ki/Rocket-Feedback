import static org.junit.jupiter.api.Assertions.*;

import Model.FeedBack;
import Model.Kurssi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class KurssiTest1 {

    private Kurssi kurssi;

    @BeforeEach
    public void setUp() {
        kurssi = new Kurssi("Ohjelmointi 101");
    }

    @Test
    public void testAddFeedback() {
        // Add feedback
        kurssi.addFeedback("Hyvä kurssi");

        // Get the feedback list
        List<FeedBack> feedbackList = kurssi.getFeedbackList();

        // Check the size of the feedback list
        assertEquals(1, feedbackList.size());

        // Get the first feedback object
        FeedBack feedback = feedbackList.get(0);

        // Validate feedback content
        assertEquals("Hyvä kurssi", feedback.getPalaute()); // Check the feedback message
    }


    @Test
    public void testGetFeedbackList_Empty() {
        List<FeedBack> feedbackList = kurssi.getFeedbackList();
        assertTrue(feedbackList.isEmpty());
    }

    @Test
    public void testPrintFeedback_NoFeedback() {
        // This test checks the printFeedback() method, although it prints directly to the console.
        // You may need to redirect the output stream in more advanced cases.
        kurssi.printFeedback(); // Expect "Ei palautteita." to be printed to the console
    }

    @Test
    public void testPrintFeedback_WithFeedback() {
        kurssi.addFeedback("Erinomainen oppitunti");

        kurssi.printFeedback();
        // This should print something like:
        // 1. Opiskelija: Sanna Virtanen
        // Palaute: Erinomainen oppitunti
    }


}
