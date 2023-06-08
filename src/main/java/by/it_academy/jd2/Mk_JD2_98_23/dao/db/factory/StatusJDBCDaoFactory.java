package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IStatusDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.StatusJDBCDao;

public class StatusJDBCDaoFactory {
    private static volatile IStatusDao instance;

    public StatusJDBCDaoFactory() {
    }

    public static IStatusDao getInstance() {
        if (instance == null)  {
            synchronized (TaskJDBCDaoFactory.class) {
                if (instance == null) {
                    instance = new StatusJDBCDao();
                }
            }
        }

        return instance;
    }
}
