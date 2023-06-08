package by.it_academy.jd2.Mk_JD2_98_23.dao.db.ds;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IDatabaseConnection;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.DatabaseConnectionFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection implements IDatabaseConnection {
    private final ComboPooledDataSource cpds;

    public DatabaseConnection() {
        this.cpds = DatabaseConnectionFactory.getInstance();
    }

    public Connection getConnection() throws SQLException {
        try {
            cpds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        cpds.setJdbcUrl("jdbc:postgresql://localhost/task-manager");
        cpds.setUser("task-manager");
        cpds.setPassword("task-manager2023");

        return cpds.getConnection();
    }
}
