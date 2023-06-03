package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskCreateService;

import java.util.List;

public class TaskCreateService implements ITaskCreateService {
    private final ITaskDao taskDao;

    public TaskCreateService(ITaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<TaskCreateDTO> get() {
        return taskDao.get();
    }

    @Override
    public TaskCreateDTO get(int id) {
        return null;
    }

    @Override
    public TaskCreateDTO save(TaskCreateDTO item) {
        return null;
    }

    @Override
    public boolean changeStatus(int statusCode) {
        return false;
    }

    @Override
    public boolean signExecutor() {
        return false;
    }
}