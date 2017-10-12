package ru.masterdm.spo.pipeline.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ru.masterdm.spo.pipeline.domain.DealCount;
import ru.masterdm.spo.pipeline.domain.DealVolume;
import ru.masterdm.spo.pipeline.mapper.IndustryPipelineMapper;

/**
 * Industry PipelineService Implementation.
 * Created by Ildar Shafigullin on 19.09.2017.
 */
@Service("industryPipelineService")
public class IndustryPipelineServiceImpl implements IndustryPipelineService {

    @Resource
    private IndustryPipelineMapper industryMapper;

    @Override
    public List<DealVolume> fetchDealVolumes() {
        return industryMapper.fetchDealVolumes();
    }

    @Override
    public long getSumDealVolumes() {
        return industryMapper.getSumDealVolumes();
    }

    @Override
    public List<DealCount> fetchDealCounts(String searchString) {
        return industryMapper.fetchDealCounts(searchString);
    }

    @Override
    public List<DealCount> fetchDealCountsSummary() {
        return industryMapper.fetchDealCountsSummary();
    }

    @Override
    public boolean isPresentDealCounts(String searchString) {
        return industryMapper.getCountDealCountsSummary(searchString) > 0;
    }

    @Override
    public List<DealCount> fetchCompaniesDealCounts(String searchString) {
        return industryMapper.fetchCompaniesDealCounts(searchString);
    }

    @Override
    public List<DealCount> fetchIndustriesDealCounts(String searchString) {
        return industryMapper.fetchIndustriesDealCounts(searchString);
    }

}
