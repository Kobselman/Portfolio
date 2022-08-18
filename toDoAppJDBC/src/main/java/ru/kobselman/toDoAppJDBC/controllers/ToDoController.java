package ru.kobselman.toDoAppJDBC.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kobselman.toDoAppJDBC.models.ToDo;
import ru.kobselman.toDoAppJDBC.services.ToDoService;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Контроллер запланированной задачи
 */
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoController {

    /** Сервис запланированной задачи */
    private final ToDoService toDoService;

    /**
     * Запрос создания
     * @param toDo запланированная задача
     * @return {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity create(@RequestBody ToDo toDo) {
        toDoService.create(toDo);
        return ok().build();
    }

    /**
     * Запрос получения списка всех запланированных задач
     * @return {@link ResponseEntity} cо списком всех запланированных задач
     */
    @GetMapping
    public ResponseEntity<List<ToDo>> read() {
       return ok(toDoService.read());
    }

    /**
     * Запрос обновления запланированных задач
     * @param toDo обновленная запланированная задача
     * @return {@link ResponseEntity}
     */
    @PutMapping
    public ResponseEntity update(@RequestBody ToDo toDo) {
        toDoService.update(toDo);
        return ok().build();
    }

    /**
     * Запрос удаления запланированной задачи
     * @param id идентификатор запланированной задачи
     * @return {@link ResponseEntity}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        toDoService.delete(id);
        return ok().build();
    }

    /**
     * Запрос получения запланированной задачи по идентификатору
     * @param id идентификатор запланированной задачи
     * @return {@link ResponseEntity} с запланированной задачей
     */
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable("id") Long id) {
        return ok(toDoService.findById(id));
    }
}
