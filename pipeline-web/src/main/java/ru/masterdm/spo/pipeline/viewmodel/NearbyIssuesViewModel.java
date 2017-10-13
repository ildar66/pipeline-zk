package ru.masterdm.spo.pipeline.viewmodel;

import java.util.ArrayList;

import org.zkoss.bind.annotation.Init;

import ru.masterdm.spo.pipeline.domain.DealIssue;
import ru.masterdm.spo.pipeline.util.ColumnInfo;

/**
 * Ближайшие выдачи по сделке View Model.
 * Created by Ildar Shafigullin on 13.10.2017.
 */
public class NearbyIssuesViewModel {

    ArrayList<DealIssue> _data;

    ArrayList<ColumnInfo> _columns;

   /* @Wire
    Columnchooser columnchooser;*/

    @Init
    public void init() {
        _columns = new ArrayList<ColumnInfo>();
        _columns.add(new ColumnInfo("name", "Name", true, "label"));
        _columns.add(new ColumnInfo("date", "Birth", true, "date"));
        _columns.add(new ColumnInfo("sum", "Marital status", false, "sum"));

        _data = provideData();
    }

    private ArrayList<DealIssue> provideData() {
        ArrayList<DealIssue> data = new ArrayList<DealIssue>();

        data.add(new DealIssue("ГК ПИК", 1980, 1, 20, 12000));
        data.add(new DealIssue("ГК 'Химнефть'", 1982, 2, 11, 15000));
        data.add(new DealIssue("ГК Строитель", 1979, 3, 21, 7000));

        return data;
    }

    /**
     * Returns .
     * @return
     */
    public ArrayList<DealIssue> getIssues() {
        return _data;
    }
}
