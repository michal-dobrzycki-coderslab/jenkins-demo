package pl.coderslab.jenkins.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.coderslab.jenkins.model.ToDo;
import pl.coderslab.jenkins.repository.ToDoRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ToDoServiceTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoServiceImpl toDoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllToDo() {
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1, "Todo Sample 1", true));
        toDoList.add(new ToDo(2, "Todo Sample 2", true));
        toDoList.add(new ToDo(3, "Todo Sample 3", false));
        when(toDoRepository.findAll()).thenReturn(toDoList);

        List<ToDo> result = toDoService.getAllToDo();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetToDoById() {
        ToDo toDo = new ToDo(1, "Todo Sample 1", true);
        when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDo));
        Optional<ToDo> resultOpt = toDoService.getToDoById(1);
        ToDo result = resultOpt.get();
        assertEquals(1, result.getId());
        assertEquals("Todo Sample 1", result.getText());
        assertTrue(result.isCompleted());
    }

    @Test
    public void saveToDo() {
        ToDo toDo = new ToDo(8, "Todo Sample 8", true);
        when(toDoRepository.save(toDo)).thenReturn(toDo);
        ToDo result = toDoService.saveToDo(toDo);
        assertEquals(8, result.getId());
        assertEquals("Todo Sample 8", result.getText());
        assertTrue(result.isCompleted());
    }

    @Test
    public void removeToDo() {
        ToDo toDo = new ToDo(8, "Todo Sample 8", true);
        toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
    }


}

