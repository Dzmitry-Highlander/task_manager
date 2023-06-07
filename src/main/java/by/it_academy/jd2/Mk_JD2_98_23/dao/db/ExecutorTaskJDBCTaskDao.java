package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorTaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ExecutorTaskJDBCTaskDao implements IExecutorTaskDao {
    //TODO List<ExecutorDTO> get()
    @Override
    public List<ExecutorDTO> get() {
        return null;
    }

    //TODO ExecutorCreateDTO get(int id)
    @Override
    public ExecutorDTO get(Long id) {
        return null;
    }

    //TODO save(ExecutorCreateDTO item);
    @Override
    public ExecutorDTO save(ExecutorDTO item) {
        return null;
    }

    @Override
    public void save(ExecutorTaskCreateDTO item) {
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
    }
}
