package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskJDBCDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;

import java.util.List;

public class TaskService implements ITaskService {
    private final ITaskJDBCDao taskDao;

    public TaskService(ITaskJDBCDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<TaskCreateDTO> get() {
        return taskDao.get();
    }

    @Override
    public TaskCreateDTO get(int id) {
        return taskDao.get(id);
    }

    @Override
    public TaskCreateDTO save(TaskCreateDTO item) {
        return taskDao.save(item);
    }

    @Override
    public boolean update(int statusCode) {
        return taskDao.update(statusCode);
    }
}
