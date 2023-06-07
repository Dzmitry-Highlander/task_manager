package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IExecutorDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IExecutorService;

import java.util.List;

public class ExecutorService implements IExecutorService {
    private final IExecutorDao executorDao;

    public ExecutorService(IExecutorDao executorDao) {
        this.executorDao = executorDao;
    }

    @Override
    public List<ExecutorDTO> get() {
        return executorDao.get();
    }

    @Override
    public ExecutorDTO get(Long id) {
        return executorDao.get(id);
    }

    @Override
    public ExecutorDTO save(ExecutorCreateDTO item) {
        ExecutorDTO dto = new ExecutorDTO();

        dto.setName(item.getName());

        return executorDao.save(dto);
    }
}
