package ru.masterdm.spo.pipeline.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ru.masterdm.spo.pipeline.domain.DealCount;
import ru.masterdm.spo.pipeline.domain.DealVolume;

/**
 * Industry PipelineMapper.
 * Created by Ildar Shafigullin on 19.09.2017.
 */
public interface IndustryPipelineMapper {

    // String FETCH_DEAL_VOLUMES = "select distinct industry from crm_ek where industry is not null";

    /**
     * Объемы сделок по отраслям.
     * @return лист объемов сделок по отраслям.
     */
    /*@Select(FETCH_DEAL_VOLUMES)
    @Results(value = {
            @Result(property = "industryName", column = "industry")
    })*/
    List<DealVolume> fetchDealVolumes();

    /**
     * Общая сумма объема сделок.
     * @return
     */
    long getSumDealVolumes();

    /**
     * Количество и суммы сделок сгруппированным по отраслям и организациям.
     * @param searchString search by like.
     * @return лист.
     */
    List<DealCount> fetchDealCounts(@Param("searchString") String searchString);

    /**
     * Количество и суммы сделок сгруппированным по отраслям.
     * @return лист.
     */
    List<DealCount> fetchDealCountsSummary();

    /**
     * количество записей "Количество и суммы сделок".
     * @param searchString
     * @return кол-во записей.
     */
    long getCountDealCountsSummary(@Param("searchString") String searchString);

    /**
     * @param searchString
     * @return лист кол-во сделок и сумм сгрупированным только по компаниям.
     */
    List<DealCount> fetchCompaniesDealCounts(@Param("searchString") String searchString);

    /**
     * @param searchString
     * @return лист кол-во сделок и сумм сгрупированным только по отраслям.
     */
    List<DealCount> fetchIndustriesDealCounts(@Param("searchString") String searchString);
}
