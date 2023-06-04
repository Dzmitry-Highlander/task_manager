package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnection{
    Connection getConnection() throws SQLException;
}
