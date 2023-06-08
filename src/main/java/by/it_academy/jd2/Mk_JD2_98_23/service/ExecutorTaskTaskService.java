package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorTaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorTaskService;

import java.util.List;

public class ExecutorTaskTaskService implements IExecutorTaskService {
    private final IExecutorTaskDao executorTaskDao;

    public ExecutorTaskTaskService(IExecutorTaskDao executorTaskDao) {
        this.executorTaskDao = executorTaskDao;
    }

    @Override
    public List<ExecutorTaskDTO> get() {
        return executorTaskDao.get();
    }

    @Override
    public ExecutorTaskDTO get(Long id) {
        return executorTaskDao.get(id);
    }

    @Override
    public ExecutorTaskDTO save(ExecutorTaskCreateDTO item) {
        ExecutorTaskDTO dto = new ExecutorTaskDTO();

        dto.setExecutorID(item.getExecutorID());
        dto.setTaskID(item.getTaskID());

        return executorTaskDao.save(dto);
    }
}
