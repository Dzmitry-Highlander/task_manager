package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.TaskJDBCDao;

public class TaskJDBCDaoFactory {
    private static volatile ITaskDao instance;

    private TaskJDBCDaoFactory() {
    }

    public static ITaskDao getInstance() {
        if (instance == null)  {
            synchronized (TaskJDBCDaoFactory.class) {
                if (instance == null) {
                    instance = new TaskJDBCDao();
                }
            }

        }

        return instance;
    }
}
