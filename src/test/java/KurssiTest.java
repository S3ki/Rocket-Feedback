import Model.Kurssi;
import Model.FeedBack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KurssiTest {
    private Kurssi kurssi;

    @BeforeEach
    void setUp() {
        kurssi = new Kurssi("Test Course");
    }

    @Test
    void addFeedbackAddsFeedbackToList() {
        kurssi.addFeedback("Great course!", "Musi Efaf");
        List<FeedBack> feedbackList = kurssi.getFeedbackList();
        assertEquals(1, feedbackList.size());
        assertEquals("Great course!", feedbackList.get(0).getFeedbackText());
    }

    @Test
    void removeFeedbackRemovesFeedbackFromList() {
        kurssi.addFeedback("Great course!", "Kahli Mussi");
        kurssi.removeFeedback(0);
        assertTrue(kurssi.getFeedbackList().isEmpty());
    }

    @Test
    void removeFeedbackDoesNotRemoveWhenIndexIsInvalid() {
        kurssi.addFeedback("Great course!", "Peppi Pitkatossu");
        kurssi.removeFeedback(1);
        assertEquals(1, kurssi.getFeedbackList().size());
    }

    @Test
    void answerFeedbackAddsAnswerToFeedback() {
        kurssi.addFeedback("Great course!", "Saameri Uhanalainen");
        kurssi.answerFeedback(0, "Thank you!");
        assertEquals("Thank you!", kurssi.getFeedbackList().get(0).getOpettajanVastaus());
    }



    @Test
    void getStudentFeedbackReturnsCorrectFeedbacks() {
        kurssi.addFeedback("Great course!", "John Doe");
        kurssi.addFeedback("I enjoyed this course.", "Jane Doe");
        List<FeedBack> studentFeedbacks = kurssi.getStudentFeedback("John Doe");
        assertEquals(2, studentFeedbacks.size());
    }
}