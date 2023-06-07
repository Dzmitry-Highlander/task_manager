package by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.ExecutorJDBCDao;

public class ExecutorJDBSDaoFactory {
    private static volatile IExecutorDao instance;

    public ExecutorJDBSDaoFactory() {
    }

    public static  IExecutorDao getInstance() {
        if (instance == null) {
            synchronized (ExecutorJDBSDaoFactory.class) {
                if (instance == null) {
                    instance = new ExecutorJDBCDao();
                }
            }
        }

        return instance;
    }
}
