package ru.masterdm.spo.pipeline.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Column;

import ru.masterdm.spo.pipeline.domain.DealVolume;
import ru.masterdm.spo.pipeline.services.IndustryPipelineService;
import ru.masterdm.spo.pipeline.util.BaseTableViewModel;
import ru.masterdm.spo.pipeline.util.ColumnInfo;

/**
 * Объем сделок по отраслям View Model.
 * Created by Ildar Shafigullin on 19.09.2017.
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class VolumeDealOnBranchVM extends BaseTableViewModel {

    // private final static Logger logger = LoggerFactory.getLogger(VolumeDealOnBranchVM.class);
    private List<DealVolume> _data;
    @WireVariable
    private IndustryPipelineService industryPipelineService;

    @Init
    public void init() {
        _columns = new ArrayList<ColumnInfo>();
        _columns.add(new ColumnInfo("industryName", "", true, "icon"));
        _columns.add(new ColumnInfo("industryName", "Отрасль", true, "industry"));
        _columns.add(new ColumnInfo("volume", "Объем млн.руб.", true, "volume"));

        _data = provideData();
    }

    private List<DealVolume> provideData() {
        return industryPipelineService.fetchDealVolumes();
    }

    /**
     * drag and drop columns.
     * @param dragColumn
     * @param dropColumn
     */
    @Command
    @NotifyChange({"dealVolumes"})
    public void moveCol(@BindingParam("drag") Column dragColumn, @BindingParam("drop") Column dropColumn) {
        swapColumns(dragColumn, dropColumn);
    }

    /**
     * @return лист объемов сделок по отраслям
     */
    public List<DealVolume> getDealVolumes() {
        // return industryPipelineService.fetchDealVolumes();
        return _data;
    }

    /**
     * @return общий объем всех сделок по отраслям
     */
    public long getSumDealVolumes() {
        return industryPipelineService.getSumDealVolumes();
    }

}