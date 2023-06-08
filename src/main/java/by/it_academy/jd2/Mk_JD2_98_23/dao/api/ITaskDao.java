package by.it_academy.jd2.Mk_JD2_98_23.dao.api;


import by.it_academy.jd2.Mk_JD2_98_23.core.dto.TaskDTO;
import by.it_academy.jd2.Mk_JD2_98_23.enums.Sort;

import java.util.LinkedHashMap;

public interface ITaskDao extends ICRUDDao<TaskDTO> {
    LinkedHashMap<Long, TaskDTO> get(Sort sort);

    TaskDTO getShort();
}
