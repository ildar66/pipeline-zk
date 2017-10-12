package ru.masterdm.spo.pipeline.services;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.masterdm.spo.pipeline.domain.DealCount;
import ru.masterdm.spo.pipeline.domain.DealVolume;

/**
 * Testing IndustryPipeline Service.
 * Created by Ildar Shafigullin on 19.09.2017.
 */
public class IndustryPipelineServiceIT extends BasePipelineIT {

    private final static Logger logger = LoggerFactory.getLogger(IndustryPipelineServiceIT.class);

    @Resource
    private IndustryPipelineService industryPipelineService;

    @Test
    public void should_fetch_all_dealVolumes() {
        List<DealVolume> list = industryPipelineService.fetchDealVolumes();
        for (DealVolume dv : list) {
            logger.debug("DealVolume: {}", dv);
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void should_fetch_sum_dealVolumes() {
        long sumDealVolumes = industryPipelineService.getSumDealVolumes();
        logger.debug("sum DealVolumes in Industries = {}", sumDealVolumes);
        Assert.assertTrue(sumDealVolumes > 0);
    }

    @Test
    public void should_fetch_dealCounts_by_like_orgName() {
        String searchString = null; // "Строительство"
        List<DealCount> list = industryPipelineService.fetchDealCounts(searchString);
        for (DealCount dc : list) {
            logger.debug("DealCount: {}", dc);
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void should_fetch_all_dealCountsSummary() {
        List<DealCount> list = industryPipelineService.fetchDealCountsSummary();
        for (DealCount dc : list) {
            logger.debug("DealCount: {}", dc);
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void should_present_deal_counts_summary() {
        String searchString = ""; // null; // "Строительство"
        boolean isPresentResult = industryPipelineService.isPresentDealCounts(searchString);
        logger.debug("for searchString = '{}'", searchString);
        logger.debug("isPresentResult = {}", isPresentResult);
        Assert.assertTrue(isPresentResult);
    }

    @Test
    public void should_fetch_searched_companies_dealCounts() {
        String searchString = ""; // null; // "Единый"
        List<DealCount> list = industryPipelineService.fetchCompaniesDealCounts(searchString);
        for (DealCount dc : list) {
            logger.debug("DealCount: {}", dc);
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void should_fetch_searched_industries_dealCounts() {
        String searchString = ""; // null; // "Строительство"
        List<DealCount> list = industryPipelineService.fetchIndustriesDealCounts(searchString);
        for (DealCount dc : list) {
            logger.debug("DealCount: {}", dc);
        }
        Assert.assertTrue(list.size() > 0);
    }

}
