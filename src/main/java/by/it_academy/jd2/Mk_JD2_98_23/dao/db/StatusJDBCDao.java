package by.it_academy.jd2.Mk_JD2_98_23.dao.db;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.StatusDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IStatusDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds.DatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions.DataErrorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StatusJDBCDao implements IStatusDao {
    @Override
    public List<StatusDTO> get() {
        //TODO List<StatusDTO> get()
        return null;
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
                dto.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            throw new DataErrorException(e.getMessage(), e);
        }

        return dto;
    }

    @Override
    public StatusDTO save(StatusDTO item) {
        //TODO StatusDTO save(StatusDTO item)
        return null;
    }
}
