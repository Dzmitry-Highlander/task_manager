package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskJDBCDao implements ITaskDao {
    @Override
    public List<TaskCreateDTO> get() {
        List<TaskCreateDTO> data = new ArrayList<>();

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT task_id, header, description, deadline, status " +
                     "FROM app.task ORDER BY task_id ASC;")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaskCreateDTO dto = new TaskCreateDTO();
                dto.setHeader(rs.getString("header"));
                dto.setDescription(rs.getString("description"));
                dto.setDeadline(rs.getDate("deadline").toLocalDate());
                dto.setStatus(rs.getInt("status"));

                data.add(dto);
            }
        } catch (SQLException e) {
            throw new DataErrorException("Ошибка подключения к базе данных", e);
        }

        return data;
    }

    @Override
    public TaskCreateDTO get(int id) {
        return null;
    }

    @Override
    public TaskCreateDTO save(TaskCreateDTO item) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO app.task( header, description, deadline, " +
                     "status) VALUES (?, ?, ?, ?);")) {
            ps.setObject(1, item.getHeader());
            ps.setObject(2, item.getDescription());
            ps.setObject(3, item.getDeadline());
            ps.setObject(4, item.getStatus());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted == 0) {
                throw new DataErrorException("Ошибка вставки данных: ни одна строка не была добавлена " +
                        "в таблицу.");
            }
        } catch (SQLException e) {
            throw new DataErrorException("Ошибка подключения к базе данных", e);
        }

        return item;
    }

    @Override
    public boolean signExecutor(int executorID, int taskID) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE app.task SET executor_id = ? " +
                     "WHERE task_id = ?;")) {
            ps.setInt(1, executorID);
            ps.setInt(2, taskID);
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted == 0) {
                throw new DataErrorException("Ошибка вставки данных: ни одна строка не была добавлена " +
                        "в таблицу.");
            }
        } catch (SQLException e) {
            throw new DataErrorException("Ошибка подключения к базе данных", e);
        }

        return true;
    }
}
