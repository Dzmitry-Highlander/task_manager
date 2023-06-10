package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExecutorJDBCDao implements IExecutorDao {
    @Override
    public List<ExecutorDTO> get() {
        List<ExecutorDTO> data = new ArrayList<>();

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT executor_id, name FROM app.executor " +
                     "ORDER BY executor_id ASC")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ExecutorDTO dto = new ExecutorDTO();
                rs.getString("executor_id");
                rs.getString("name");

                data.add(dto);
            }
        } catch (SQLException e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return data;
    }

    @Override
    public ExecutorDTO get(Long id) {
        ExecutorDTO dto = null;
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn
                     .prepareStatement("SELECT executor_id, name FROM app.executor WHERE executor_id = ? " +
                             "ORDER BY executor_id ASC")) {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ExecutorDTO();
                dto.setId(rs.getLong("executor_id"));
                dto.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return dto;
    }

    @Override
    public ExecutorDTO save(ExecutorDTO item) {
        //TODO RETURNING ID
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO app.executor(name) VALUES (?);")) {
            ps.setString(1, item.getName());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted == 0) {
                throw new DataErrorException("Ошибка вставки данных: ни одна строка не была добавлена таблицу.");
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return item;
    }

    @Override
    public ExecutorDTO update(ExecutorDTO item) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE app.executor " +
                     "SET name = ? WHERE executor_id = ?;")) {
            ps.setString(1, item.getName());
            ps.setLong(2, item.getId());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted == 0) {
                throw new DataErrorException("Ошибка вставки данных: ни одна строка не была добавлена таблицу.");
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return item;
    }

    @Override
    public boolean delete(Long id) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE executor_id, name FROM app.executor " +
                     "WHERE executor_id = ?;")) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted == 0) {
                throw new DataErrorException("Ошибка удаления данных.");
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return true;
    }
}
