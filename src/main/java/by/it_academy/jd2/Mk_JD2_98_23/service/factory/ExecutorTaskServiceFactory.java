package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.ExecutorTaskJDBCDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.ExecutorTaskTaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorTaskService;

public class ExecutorTaskServiceFactory {
    private static volatile IExecutorTaskService instance;

    private ExecutorTaskServiceFactory() {
    }

    public static IExecutorTaskService getInstance() {
        if (instance == null) {
            synchronized (ExecutorTaskServiceFactory.class) {
                instance = new ExecutorTaskTaskService(ExecutorTaskJDBCDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
