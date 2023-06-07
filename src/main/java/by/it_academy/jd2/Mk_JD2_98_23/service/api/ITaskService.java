package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.enums.Sort;

import java.util.List;

public interface ITaskService extends ICRUDService<TaskCreateDTO, TaskDTO> {
    List<TaskDTO> get(Sort sort);

    boolean update(int statusCode);
}
