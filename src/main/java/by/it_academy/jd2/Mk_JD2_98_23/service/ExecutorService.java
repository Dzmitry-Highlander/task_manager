package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorService;

import java.util.List;

public class ExecutorService implements IExecutorService {
    private final IExecutorDao executorDao;

    public ExecutorService(IExecutorDao executorDao) {
        this.executorDao = executorDao;
    }

    @Override
    public List<ExecutorCreateDTO> get() {
        return null;
    }

    @Override
    public ExecutorCreateDTO get(int id) {
        return null;
    }

    @Override
    public ExecutorCreateDTO save(ExecutorCreateDTO executorCreateDTO) {
        return null;
    }

    @Override
    public void signExecutor(long executorID, long taskID) {
        executorDao.signExecutor(executorID, taskID);
    }
}
