package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;

public interface ITaskCreateService extends ICRUDService<TaskCreateDTO, TaskDTO> {
    boolean changeStatus(int statusCode);

    boolean signExecutor();
}
