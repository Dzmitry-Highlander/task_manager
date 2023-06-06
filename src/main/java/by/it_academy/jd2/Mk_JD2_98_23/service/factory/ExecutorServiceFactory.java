package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.ExecutorJDBCDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.ExecutorTaskTaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorTaskService;

public class ExecutorServiceFactory {
    private static volatile IExecutorTaskService instance;

    private ExecutorServiceFactory() {
    }

    public static IExecutorTaskService getInstance() {
        if (instance == null) {
            synchronized (ExecutorServiceFactory.class) {
                instance = new ExecutorTaskTaskService(ExecutorJDBCDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
