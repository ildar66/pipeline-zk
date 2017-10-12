package ru.masterdm.spo.pipeline.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import ru.masterdm.spo.pipeline.domain.Department;

/**
 * Department Mapper.
 * Created by Ildar Shafigullin on 11.09.2017.
 */
@CacheNamespace(readWrite = false)
public interface DepartmentMapper {

    @Select("SELECT id, name FROM DEPARTMENT")
    List<Department> fetchAll();
}
