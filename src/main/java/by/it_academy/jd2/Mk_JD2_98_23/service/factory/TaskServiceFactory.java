package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.TaskJDBCDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.TaskCreateService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskCreateService;

public class TaskServiceFactory {
    private static volatile ITaskCreateService instance;

    private TaskServiceFactory() {
    }

    public static ITaskCreateService getInstance() {
        if (instance == null) {
            synchronized (TaskServiceFactory.class) {
                instance = new TaskCreateService(TaskJDBCDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
