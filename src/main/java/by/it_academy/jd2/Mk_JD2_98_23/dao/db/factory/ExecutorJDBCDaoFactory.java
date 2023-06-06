package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorTaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ExecutorTaskJDBCTaskDao;

public class ExecutorJDBCDaoFactory {
    private static volatile IExecutorTaskDao instance;

    private ExecutorJDBCDaoFactory() {
    }

    public static IExecutorTaskDao getInstance() {
        if (instance == null)  {
            synchronized (ExecutorJDBCDaoFactory.class) {
                if (instance == null) {
                    instance = new ExecutorTaskJDBCTaskDao();
                }
            }
        }

        return instance;
    }
}
