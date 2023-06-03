package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatabaseConnectionFactory {
    private static volatile ComboPooledDataSource instance;

    private DatabaseConnectionFactory() {
    }

    public static ComboPooledDataSource getInstance() {
        if (instance == null)  {
            synchronized (DatabaseConnectionFactory.class) {
                if (instance == null) {
                    instance = new ComboPooledDataSource();
                }
            }
        }

        return instance;
    }
}
