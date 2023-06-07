package by.it_academy.jd2.Mk_JD2_98_23.dao.api;


import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.enums.Sort;

import java.util.List;

public interface ITaskDao extends ICRUDDao<TaskDTO> {
    List<TaskDTO> get(Sort sort);

    boolean update(int statusCode);
}
