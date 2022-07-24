package pl.coderslab.jenkins.util;

import org.junit.jupiter.api.Test;
import pl.coderslab.jenkins.model.ToDo;

import static org.junit.jupiter.api.Assertions.*;

public class PayloadValidatorTest {

    @Test
    public void validatePayLoad() {
        ToDo toDo = new ToDo(1, "Sample ToDo 1", true);
        assertFalse(PayloadValidator.validateCreatePayload(toDo));
    }

    @Test
    public void validateInvalidPayLoad() {
        ToDo toDo = new ToDo(0, "Sample ToDo 1", true);
        assertTrue(PayloadValidator.validateCreatePayload(toDo));
    }


}
