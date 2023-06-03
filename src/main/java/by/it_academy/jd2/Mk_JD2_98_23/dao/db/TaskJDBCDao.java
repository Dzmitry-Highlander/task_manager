package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.AccessDataException;

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
             PreparedStatement ps = conn.prepareStatement("SELECT cur_id, cur_date, cur_official_rate FROM " +
                     "app.rate ORDER BY cur_id ASC")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaskCreateDTO dto = new TaskCreateDTO();


                data.add(dto);
            }
        } catch (SQLException e) {
            throw new AccessDataException("Ошибка подключения к базе данных", e);
        }

        return data;
    }

    @Override
    public TaskCreateDTO get(int id) {
        return null;
    }

    @Override
    public TaskCreateDTO save(TaskCreateDTO item) {
        return null;
    }
}
