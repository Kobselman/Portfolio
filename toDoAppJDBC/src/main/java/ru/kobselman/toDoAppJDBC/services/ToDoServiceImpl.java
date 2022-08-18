package ru.kobselman.toDoAppJDBC.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kobselman.toDoAppJDBC.models.ToDo;
import ru.kobselman.toDoAppJDBC.repositories.JdbcToDoRepository;
import ru.kobselman.toDoAppJDBC.repositories.ToDoRepository;

import java.util.List;

/**
 * Реализация {@link ToDoService}
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    /** Репозиторий запланированной задачи */
    private final ToDoRepository toDoRepository;

    @Override
    public void create(ToDo toDo) {
        toDoRepository.create(toDo);
    }

    @Override
    public List<ToDo> read() {
        return toDoRepository.read();
    }

    @Override
    public void update(ToDo toDo) {
        toDoRepository.update(toDo);
    }

    @Override
    public void delete(Long id) {
        toDoRepository.delete(id);
    }

    @Override
    public ToDo findById(Long id) {
        return toDoRepository.findById(id);
    }
}
