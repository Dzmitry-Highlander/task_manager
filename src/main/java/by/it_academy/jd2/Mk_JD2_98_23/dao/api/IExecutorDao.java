package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ExecutorCreateDTO;

public interface IExecutorDao extends ICRUDDao<ExecutorCreateDTO> {
    void signExecutor(long executorID, long taskID);
}
