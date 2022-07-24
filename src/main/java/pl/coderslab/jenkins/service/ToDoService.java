package pl.coderslab.jenkins.service;

import pl.coderslab.jenkins.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    List<ToDo> getAllToDo();

    Optional<ToDo> getToDoById(long id);

    ToDo saveToDo(ToDo todo);

    void removeToDo(ToDo todo);
}
