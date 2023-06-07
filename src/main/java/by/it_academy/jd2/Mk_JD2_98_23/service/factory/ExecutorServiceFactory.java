package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.ExecutorJDBSDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.ExecutorService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorService;

public class ExecutorServiceFactory {
    private static volatile IExecutorService instance;

    public ExecutorServiceFactory() {
    }

    public static IExecutorService getInstance() {
        if (instance == null) {
            synchronized (ExecutorServiceFactory.class) {
                instance = new ExecutorService(ExecutorJDBSDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
