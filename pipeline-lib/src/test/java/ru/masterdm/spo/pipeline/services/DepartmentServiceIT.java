package ru.masterdm.spo.pipeline.services;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.masterdm.spo.pipeline.domain.Department;

/**
 * Testing Department Service.
 * Created by Ildar Shafigullin on 12.09.2017.
 */
public class DepartmentServiceIT extends BaseIT {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentServiceIT.class);

    @Resource
    private DepartmentService departmentService;

    @Test
    public void should_fetch_all_departments() {
        List<Department> departments = departmentService.fetchAll();
        for (Department d : departments) {
            logger.debug("Dept: {}", d);
        }
        Assert.assertTrue(departments.size() > 1);
    }
}
