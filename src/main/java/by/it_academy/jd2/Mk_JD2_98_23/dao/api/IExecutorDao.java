package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;

public interface IExecutorDao extends ICRUDDao<ExecutorCreateDTO> {
    void signExecutor(ExecutorDTO executorDTO, TaskDTO taskDTO);
}
