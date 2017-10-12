package ru.masterdm.spo.pipeline.services;

import java.util.List;

import ru.masterdm.spo.pipeline.domain.Department;

/**
 * Department Service.
 * Created by Ildar Shafigullin on 11.09.2017.
 */
public interface DepartmentService {

    List<Department> fetchAll();
}
