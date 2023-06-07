package by.it_academy.jd2.Mk_JD2_98_23.service.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.StatusJDBCDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.dao.db.factory.TaskJDBCDaoFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.TaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;

public class TaskServiceFactory {
    private static volatile ITaskService instance;

    private TaskServiceFactory() {
    }

    public static ITaskService getInstance() {
        if (instance == null) {
            synchronized (TaskServiceFactory.class) {
                instance = new TaskService(TaskJDBCDaoFactory.getInstance(), StatusJDBCDaoFactory.getInstance());
            }
        }

        return instance;
    }
}
