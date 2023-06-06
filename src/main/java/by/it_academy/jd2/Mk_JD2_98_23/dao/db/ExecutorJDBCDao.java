package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ExecutorJDBCDao implements IExecutorDao {
    @Override
    public List<ExecutorCreateDTO> get() {
        return null;
    }

    @Override
    public ExecutorCreateDTO get(int id) {
        return null;
    }

    @Override
    public ExecutorCreateDTO save(ExecutorCreateDTO item) {
        return null;
    }

    @Override
    public void signExecutor(long executorID, long taskID) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO app.executor_task(executor_id, task_id) " +
                     "VALUES (?, ?);")) {
            ps.setLong(1, executorID);
            ps.setLong(2, taskID);
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted == 0) {
                throw new DataErrorException("Ошибка вставки данных: ни одна строка не была добавлена в таблицу.");
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }
    }
}
