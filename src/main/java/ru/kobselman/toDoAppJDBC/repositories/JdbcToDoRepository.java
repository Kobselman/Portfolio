package ru.kobselman.toDoAppJDBC.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kobselman.toDoAppJDBC.models.ToDo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Реализация {@link ToDoRepository}
 */
@Repository
@AllArgsConstructor
public class JdbcToDoRepository implements ToDoRepository {

    /** JDBC шаблон для операций в базе данных */
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(ToDo toDo) {
        jdbcTemplate.update(
                "INSERT INTO todo (header, description) VALUES ( ?, ?)",
                ps -> {
                    int idx = 0;
                    ps.setString(++idx, toDo.getHeader());
                    ps.setString(++idx, toDo.getDescription());
                }
        );
    }

    @Override
    public List<ToDo> read() {
        return jdbcTemplate.query(
                "SELECT * FROM todo ORDER BY created DESC",
                (rs, rowNum) -> extractValue(rs)
        );
    }

    @Override
    public void update(ToDo toDo) {
        jdbcTemplate.update(
                "UPDATE todo SET header = ?, description = ?, changed = ? WHERE id = ?",
                ps -> {
                    int idx = 0;
                    ps.setString(++idx, toDo.getHeader());
                    ps.setString(++idx, toDo.getDescription());
                    ps.setObject(++idx, LocalDateTime.now());
                    ps.setLong(++idx, toDo.getId());
                }
        );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
                "DELETE FROM todo WHERE id = ?",
                ps -> ps.setLong(1, id)
        );
    }

    @Override
    public ToDo findById(Long id) {
        return jdbcTemplate.query(
                "SELECT * FROM todo WHERE id = ?",
                ps -> {
                    int idx = 0;
                    ps.setLong(++idx, id);
                },
                rs -> rs.next() ? extractValue(rs) : null
        );
    }

    /**
     * Конвертация записи из базы данных в сущность запланированной задачи
     * @param rs множество значений колонок из базы данных
     * @return запланированная задача
     * @throws SQLException ошибка в базе данных
     */
    private ToDo extractValue(ResultSet rs) throws SQLException {
        return new ToDo(
                rs.getLong("id"),
                rs.getString("header"),
                rs.getString("description"),
                rs.getTimestamp("created").toLocalDateTime(),
                rs.getTimestamp("changed").toLocalDateTime()
        );
    }
}
