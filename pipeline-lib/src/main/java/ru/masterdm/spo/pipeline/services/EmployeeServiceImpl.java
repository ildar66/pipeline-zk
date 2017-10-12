package ru.masterdm.spo.pipeline.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ru.masterdm.spo.pipeline.domain.Employee;
import ru.masterdm.spo.pipeline.mapper.EmployeeMapper;

/**
 * Employee Service Implementation.
 * Created by Ildar Shafigullin on 11.09.2017.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> fetchAll() {
        return employeeMapper.fetchAll();
    }

    public void update(Employee emp) {
        employeeMapper.update(emp);
    }

    public void delete(Integer id) {
        employeeMapper.delete(id);
    }

    public Employee fetch(Integer id) {
        return employeeMapper.fetch(id);
    }

    public void insert(Employee emp) {
        employeeMapper.insert(emp);
    }
}
