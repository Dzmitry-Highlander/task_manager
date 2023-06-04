package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;

public interface ITaskDao extends ICRUDDao<TaskCreateDTO> {
    void signExecutor(int executorID, int taskID);
}
