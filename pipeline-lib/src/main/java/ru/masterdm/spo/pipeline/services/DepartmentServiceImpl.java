package ru.masterdm.spo.pipeline.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ru.masterdm.spo.pipeline.domain.Department;
import ru.masterdm.spo.pipeline.mapper.DepartmentMapper;

/**
 * Department Service Implementation.
 * Created by Ildar Shafigullin on 11.09.2017.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> fetchAll() {
        return departmentMapper.fetchAll();
    }
}
