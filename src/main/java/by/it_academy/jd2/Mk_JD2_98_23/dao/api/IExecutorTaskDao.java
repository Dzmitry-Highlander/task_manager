package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorTaskCreateDTO;

public interface IExecutorTaskDao extends ICRUDDao<ExecutorCreateDTO> {
    void save(ExecutorTaskCreateDTO item);
}
