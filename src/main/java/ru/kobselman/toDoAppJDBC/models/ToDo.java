package ru.kobselman.toDoAppJDBC.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность запланированной задачи
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    /** Идентификатор */
    private Long id;

    /** Заголовок */
    private String header;

    /** Описание */
    private String description;

    /** Дата создания записи */
    private LocalDateTime created;

    /** Дата изменения записи */
    private LocalDateTime changed;
}
