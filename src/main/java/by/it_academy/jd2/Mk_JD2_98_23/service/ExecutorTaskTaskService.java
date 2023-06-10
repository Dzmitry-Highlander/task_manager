package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateUpdateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorTaskDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorTaskService;

import java.util.List;

public class ExecutorTaskTaskService implements IExecutorTaskService {
    private final IExecutorTaskDao executorTaskDao;

    public ExecutorTaskTaskService(IExecutorTaskDao executorTaskDao) {
        this.executorTaskDao = executorTaskDao;
    }

    @Override
    public List<ExecutorCreateUpdateDTO> get() {
        return executorTaskDao.get();
    }

    @Override
    public ExecutorCreateUpdateDTO get(Long id) {
        return executorTaskDao.get(id);
    }

    @Override
    public ExecutorCreateUpdateDTO save(ExecutorTaskCreateDTO item) {
        ExecutorCreateUpdateDTO dto = new ExecutorCreateUpdateDTO();

        dto.setExecutorID(item.getExecutorID());
        dto.setTaskID(item.getTaskID());

        return executorTaskDao.save(dto);
    }
}
