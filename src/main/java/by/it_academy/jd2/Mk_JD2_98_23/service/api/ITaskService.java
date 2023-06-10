package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateUpdateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;

import java.util.LinkedHashMap;

public interface ITaskService extends ICRUDService<TaskCreateUpdateDTO, TaskDTO> {
    LinkedHashMap<Long, TaskDTO> getSorted(int sort);

    boolean update(int statusCode);
}
