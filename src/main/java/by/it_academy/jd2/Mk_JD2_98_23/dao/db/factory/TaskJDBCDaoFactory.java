package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskJDBCDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.TaskJDBCDao;

public class TaskJDBCDaoFactory {
    private static volatile ITaskJDBCDao instance;

    private TaskJDBCDaoFactory() {
    }

    public static ITaskJDBCDao getInstance() {
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
