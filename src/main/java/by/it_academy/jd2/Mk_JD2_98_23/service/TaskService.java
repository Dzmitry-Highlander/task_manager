package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IStatusDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.ITaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.ITaskService;
import by.it_academy.jd2.Mk_JD2_98_23.enums.Sort;

import java.util.LinkedHashMap;
import java.util.List;

public class TaskService implements ITaskService {
    private final ITaskDao taskDao;
    private final IStatusDao statusDao;

    public TaskService(ITaskDao taskDao, IStatusDao statusDao) {
        this.taskDao = taskDao;
        this.statusDao = statusDao;
    }

    @Override
    public List<TaskDTO> get() {
        return taskDao.get();
    }

    @Override
    public TaskDTO get(Long id) {
        return taskDao.get(id);
    }

    @Override
    public TaskDTO save(TaskCreateDTO item) {
        TaskDTO dto = new TaskDTO();

        dto.setHeader(item.getHeader());
        dto.setDescription(item.getDescription());
        dto.setDeadline(item.getDeadline());
        dto.setStatus(statusDao.get(item.getStatus()));

        return taskDao.save(dto);
    }

    @Override
    public LinkedHashMap<Long, TaskDTO> getSorted(int sort) {
        Sort sortParam = switch (sort) {
            case -1 -> Sort.ID_DESC;
            case 2 -> Sort.HEADER_ASC;
            case -2 -> Sort.HEADER_DESC;
            case 3 -> Sort.DEADLINE_ASC;
            case -3 -> Sort.DEADLINE_DESC;
            case 4 -> Sort.STATUS_ASC;
            case -4 -> Sort.STATUS_DESC;
            default -> Sort.ID_ASC;
        };

        return taskDao.get(sortParam);
    }

    @Override
    public boolean update(int statusCode) {
        return taskDao.update(statusCode);
    }
}
