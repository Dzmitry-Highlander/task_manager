package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;
import by.it_academy.jd2.Mk_JD2_98_23.service.enums.Sort;

import java.util.List;

public class TaskService implements ITaskService {
    private final ITaskDao taskDao;

    public TaskService(ITaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<TaskDTO> get() {
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
    public List<TaskDTO> getSorted(int sort) {
        Sort sortParam = switch (sort) {
            case 1 -> Sort.ID_ASC;
            case -1 -> Sort.ID_DESC;
            case 2 -> Sort.HEADER_ASC;
            case -2 -> Sort.HEADER_DESC;
            case 3 -> Sort.DEADLINE_ASC;
            case -3 -> Sort.DEADLINE_DESC;
            case 4 -> Sort.STATUS_ASC;
            case -4 -> Sort.STATUS_DESC;
            default -> throw new RuntimeException();
        };

        return taskDao.get(sortParam);
    }

    @Override
    public boolean update(int statusCode) {
        return taskDao.update(statusCode);
    }
}
