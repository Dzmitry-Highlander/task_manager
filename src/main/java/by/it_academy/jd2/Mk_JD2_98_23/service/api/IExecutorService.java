package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;

public interface IExecutorService extends ICRUDService<ExecutorCreateDTO, ExecutorDTO> {
    void signExecutor(long executorID, long taskID);
}
