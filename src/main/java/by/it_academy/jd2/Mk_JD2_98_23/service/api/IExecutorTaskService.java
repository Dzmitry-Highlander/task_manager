package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskCreateDTO;

public interface IExecutorTaskService extends ICRUDService<ExecutorCreateDTO, ExecutorDTO> {
    void save(ExecutorTaskCreateDTO item);
}
