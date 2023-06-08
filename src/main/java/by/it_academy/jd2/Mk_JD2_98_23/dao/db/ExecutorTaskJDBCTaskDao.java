package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorTaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExecutorTaskJDBCTaskDao implements IExecutorTaskDao {
    @Override
    public List<ExecutorTaskDTO> get() {
        List<ExecutorTaskDTO> data = new ArrayList<>();

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT executor_id, name FROM app.executor " +
                     "ORDER BY executor_id ASC")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ExecutorTaskDTO dto = new ExecutorTaskDTO();

                data.add(dto);
            }
        } catch (SQLException e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return data;
    }

    @Override
    public ExecutorTaskDTO get(Long id) {
        ExecutorTaskDTO dto = null;
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn
                     .prepareStatement("SELECT executor_task_id, executor_id, task_id FROM app.executor_task" +
                             " WHERE executor_task_id = ? ORDER BY status_id ASC")) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ExecutorTaskDTO();
                dto.setExecutorID(rs.getLong("executor_id"));
                dto.setTaskID(rs.getLong("task_id"));
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return dto;
    }

    @Override
    public ExecutorTaskDTO save(ExecutorTaskDTO item) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO app.executor_task(executor_id, task_id) " +
                     "VALUES (?, ?);")) {
            ps.setLong(1, item.getExecutorID());
            ps.setLong(2, item.getTaskID());
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted == 0) {
                throw new DataErrorException("Ошибка вставки данных: ни одна строка не была добавлена в таблицу.");
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return item;
    }
}
