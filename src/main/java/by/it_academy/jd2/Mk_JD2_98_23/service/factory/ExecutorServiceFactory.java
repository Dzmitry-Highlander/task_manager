package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.ExecutorJDBCDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.ExecutorService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorService;

public class ExecutorServiceFactory {
    private static volatile IExecutorService instance;

    private ExecutorServiceFactory() {
    }

    public static IExecutorService getInstance() {
        if (instance == null) {
            synchronized (ExecutorServiceFactory.class) {
                instance = new ExecutorService(ExecutorJDBCDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
