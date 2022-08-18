package ru.kobselman.toDoAppJDBC.services;

import ru.kobselman.toDoAppJDBC.models.ToDo;

import java.util.List;

/**
 * Сервис запланированной задачи
 */
public interface ToDoService {

    /**
     * Создание
     * @param toDo запланированная задача
     */
    void create(ToDo toDo);

    /**
     * Получение списка всех запланированных задач
     * @return список всех запланированных задач
     */
    List<ToDo> read();

    /**
     * Обновление запланированных задач
     * @param toDo обновленная запланированная задача
     */
    void update(ToDo toDo);

    /**
     * Удаление запланированной задачи
     * @param id идентификатор запланированной задачи
     */
    void delete(Long id);

    /**
     * Получение запланированной задачи по идентификатору
     * @param id идентификатор запланированной задачи
     * @return запланированная задача
     */
    ToDo findById(Long id);
}
