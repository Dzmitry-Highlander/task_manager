package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorTaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ExecutorTaskJDBCTaskDao;

public class ExecutorTaskJDBCDaoFactory {
    private static volatile IExecutorTaskDao instance;

    private ExecutorTaskJDBCDaoFactory() {
    }

    public static IExecutorTaskDao getInstance() {
        if (instance == null)  {
            synchronized (ExecutorTaskJDBCDaoFactory.class) {
                if (instance == null) {
                    instance = new ExecutorTaskJDBCTaskDao();
                }
            }
        }

        return instance;
    }
}
