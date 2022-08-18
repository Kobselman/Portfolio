package ru.kobselman.toDoAppJDBC.repositories;


import ru.kobselman.toDoAppJDBC.models.ToDo;

import java.util.List;

/**
 * Репозиторий запланированной задачи
 */
public interface ToDoRepository {

    /**
     * Запрос создания
     * @param toDo запланированная задача
     */
    void create(ToDo toDo);

    /**
     * Запрос получения списка всех запланированных задач
     * @return список всех запланированных задач
     */
    List<ToDo> read();

    /**
     * Запрос обновления запланированных задач
     * @param toDo обновленная запланированная задача
     */
    void update(ToDo toDo);

    /**
     * Запрос удаления запланированной задачи
     * @param id идентификатор запланированной задачи
     */
    void delete(Long id);

    /**
     * Запрос получения запланированной задачи по идентификатору
     * @param id идентификатор запланированной задачи
     * @return запланированная задача
     */
    ToDo findById(Long id);
}
