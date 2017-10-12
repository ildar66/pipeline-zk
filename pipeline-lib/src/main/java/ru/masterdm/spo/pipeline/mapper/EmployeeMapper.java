package ru.masterdm.spo.pipeline.mapper;

import java.util.List;

import ru.masterdm.spo.pipeline.domain.Employee;

/**
 * Employee Mapper.
 * Created by Ildar Shafigullin on 11.09.2017.
 */
public interface EmployeeMapper {

    List<Employee> fetchAll();

    void update(Employee emp);

    void delete(Integer id);

    Employee fetch(Integer id);

    void insert(Employee emp);
}
