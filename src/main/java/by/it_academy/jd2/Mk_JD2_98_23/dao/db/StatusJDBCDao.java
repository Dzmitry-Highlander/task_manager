package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.StatusDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IStatusDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StatusJDBCDao implements IStatusDao {
    @Override
    public List<StatusDTO> get() {
        List<StatusDTO> data = new ArrayList<>();

        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT status_id, status FROM app.status " +
                     "ORDER BY status_id ASC;")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StatusDTO dto = new StatusDTO();
                dto.setId(rs.getLong("status_id"));
                dto.setStatus("status");

                data.add(dto);
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return data;
    }

    @Override
    public StatusDTO get(Long id) {
        StatusDTO dto = null;
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn
                     .prepareStatement("SELECT status_id, status FROM app.status" +
                             " WHERE status_id = ? ORDER BY status_id ASC")) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new StatusDTO();
                dto.setId(rs.getLong("status_id"));
                dto.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return dto;
    }

    @Override
    public StatusDTO save(StatusDTO item) {
        //TODO RETURNING ID
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO app.status(status) VALUES (?);")) {
            ps.setString(1, item.getStatus());

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
    public StatusDTO update(StatusDTO item) {
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE app.status " +
                     "SET status = ? WHERE status_id = ?;")) {
            ps.setString(1, item.getStatus());
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
}
