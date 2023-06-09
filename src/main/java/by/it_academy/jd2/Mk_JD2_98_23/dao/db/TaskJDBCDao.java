package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.StatusDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;
import by.it_academy.jd2.Mk_JD2_98_23.enums.Sort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class TaskJDBCDao implements ITaskDao {
    @Override
    public List<TaskDTO> get() {
        List<TaskDTO> data = new ArrayList<>();

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT task_id, header, description, deadline, " +
                     "status_id FROM app.task ORDER BY task_id ASC;")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaskDTO dto = new TaskDTO();
                dto.setId(rs.getLong("task_id"));
                dto.setHeader(rs.getString("header"));
                dto.setDescription(rs.getString("description"));
                dto.setDeadline(rs.getDate("deadline").toLocalDate());
                //TODO check setStatus() work
                dto.setStatus(rs.getObject(2, StatusDTO.class));

                data.add(dto);
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return data;
    }

    @Override
    public TaskDTO get(Long id) {
        TaskDTO dto = null;
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn
                     .prepareStatement("SELECT task_id, header, description, deadline, status_id FROM app.task" +
                             " WHERE task_id = ? ORDER BY task_id ASC")) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new TaskDTO();
                dto.setHeader(rs.getString("header"));
                dto.setDescription(rs.getString("description"));
                dto.setDeadline(rs.getDate("deadline").toLocalDate());
                //TODO check setStatus() work
                dto.setStatus(rs.getObject(2, StatusDTO.class));
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return dto;
    }

    @Override
    public TaskDTO save(TaskDTO item) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO app.task(header, description, deadline, " +
                     "status_id) VALUES (?, ?, ?, ?);")) {
            ps.setString(1, item.getHeader());
            ps.setString(2, item.getDescription());
            ps.setObject(3, item.getDeadline());
            ps.setLong(4, item.getStatus().getId());

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
    public TaskDTO update(TaskDTO item) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE app.task " +
                     "SET deadline = ?, status_id = ? WHERE task_id = ?;")) {
            ps.setObject(1, item.getDeadline());
            ps.setLong(2, item.getStatus().getId());
            ps.setLong(3, item.getId());

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
    public LinkedHashMap<Long, TaskDTO> get(Sort sort) {
        LinkedHashMap<Long, TaskDTO> data = new LinkedHashMap<>();
        String statement = "SELECT task_id, header, description, deadline, " +
                "(SELECT status FROM app.status WHERE task.status_id = status.status_id) AS status, " +
                "(SELECT status_id FROM app.status WHERE task.status_id = status.status_id) AS status_id " +
                "FROM app.task ORDER BY " + sort.getSort() + ";";

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            Long key = 0L;

            while (rs.next()) {
                TaskDTO dto = new TaskDTO();
                dto.setId(rs.getLong("task_id"));
                dto.setHeader(rs.getString("header"));
                dto.setDescription(rs.getString("description"));
                dto.setDeadline(rs.getDate("deadline").toLocalDate());
                //TODO check setStatus() work
                dto.setStatus(new StatusDTO(rs.getLong("status_id"), rs.getString("status")));

                data.put(key, dto);
                key++;
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return data;
    }

    //TODO getShort()
    @Override
    public TaskDTO getShort() {
        return null;
    }
}
