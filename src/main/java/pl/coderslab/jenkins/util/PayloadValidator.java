package pl.coderslab.jenkins.util;

import pl.coderslab.jenkins.model.ToDo;

public class PayloadValidator {

    public static boolean validateCreatePayload(ToDo toDo) {
        return toDo.getId() <= 0;
    }

}
