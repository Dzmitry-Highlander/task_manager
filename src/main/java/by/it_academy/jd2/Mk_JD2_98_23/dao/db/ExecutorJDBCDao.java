package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
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
    public ExecutorCreateDTO get(int id) {
        return null;
    }

    @Override
    public ExecutorCreateDTO save(ExecutorCreateDTO item) {
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
}
