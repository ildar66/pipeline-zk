package ru.masterdm.spo.pipeline.services;

import java.util.List;

import ru.masterdm.spo.pipeline.domain.DealCount;
import ru.masterdm.spo.pipeline.domain.DealVolume;

/**
 * Industry PipelineService.
 * Created by Ildar Shafigullin on 19.09.2017.
 */
public interface IndustryPipelineService {

    /**
     * Объем сделок по отраслям.
     * @return Объем сделок.
     */
    List<DealVolume> fetchDealVolumes();

    /**
     * Сумма значений «Объем в млн. руб» по всем отраслям.
     * @return
     */
    long getSumDealVolumes();

    /**
     * Количества и суммы сделок сгруппированным по отраслям и организациям.
     * @param searchString
     * @return лист.
     */
    List<DealCount> fetchDealCounts(String searchString);

    /**
     * Количество и суммы сделок сгруппированным по отраслям.
     * @return лист.
     */
    List<DealCount> fetchDealCountsSummary();

    /**
     * есть ли записи "Количество и суммы сделок".
     * @param searchString
     * @return boolean.
     */
    boolean isPresentDealCounts(String searchString);

    /**
     * @param searchString
     * @return лист кол-во сделок и сумм сгрупированным только по компаниям.
     */
    List<DealCount> fetchCompaniesDealCounts(String searchString);

    /**
     * @param searchString
     * @return лист кол-во сделок и сумм сгрупированным только по отраслям.
     */
    List<DealCount> fetchIndustriesDealCounts(String searchString);
}
