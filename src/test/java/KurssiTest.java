import Model.FeedBack;
import Model.FeedBack;
import Model.Kurssi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KurssiTest {

    private Kurssi kurssi;

    @BeforeEach
    void setUp() {
        kurssi = new Kurssi("Mathematics");
    }

    @Test
    void shouldAddFeedback() {
        kurssi.addFeedback("Great course!");
        List<FeedBack> feedbackList = kurssi.getFeedbackList();
        assertFalse(feedbackList.isEmpty());
        assertEquals("Great course!", feedbackList.get(0).getPalaute());
    }

    @Test
    void shouldReturnEmptyFeedbackListWhenNoFeedbackAdded() {
        List<FeedBack> feedbackList = kurssi.getFeedbackList();
        assertTrue(feedbackList.isEmpty());
    }

    @Test
    void shouldReturnCorrectCourseName() {
        assertEquals("Mathematics", kurssi.getNimi());
    }
}