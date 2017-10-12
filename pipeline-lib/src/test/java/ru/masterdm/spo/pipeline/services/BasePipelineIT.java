package ru.masterdm.spo.pipeline.services;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BaseIT for Testing Service.
 * Created by Ildar Shafigullin on 12.09.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/test-pipeline-application-config.xml"})
abstract public class BasePipelineIT {

}
