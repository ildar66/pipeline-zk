package ru.masterdm.spo.pipeline.viewmodel;

import java.util.ArrayList;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Column;

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
        System.out.println("INIT"); // TODO temp
        _columns = new ArrayList<ColumnInfo>();
        _columns.add(new ColumnInfo("name", "", true, "icon"));
        _columns.add(new ColumnInfo("name", " ", true, "label"));
        _columns.add(new ColumnInfo("date", "Дата выдачи.", true, "date"));
        _columns.add(new ColumnInfo("sum", "Сумма в вал. сделки.", true, "sum"));

        _data = provideData();
    }

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        System.out.println("afterCompose"); // TODO temp
        Selectors.wireComponents(view, this, false);
    }

    private ArrayList<DealIssue> provideData() {
        ArrayList<DealIssue> data = new ArrayList<DealIssue>();

        data.add(new DealIssue("ГК ПИК", 1980, 1, 20, 12000));
        data.add(new DealIssue("ГК 'Химнефть'", 1982, 2, 11, 15000));
        data.add(new DealIssue("ГК Строитель", 2017, 3, 21, 7000));
        data.add(new DealIssue("ГК Test", 2014, 6, 7, 17000));
        data.add(new DealIssue("Кo Мацарелла", 2015, 2, 2, 90000));

        return data;
    }

    /**
     * change columne and row.
     * @param event
     */
    @NotifyChange({"visibleColumns", "issues"})
    public void move(org.zkoss.zk.ui.event.DropEvent event) {
        Column dragged = (Column) event.getDragged();
        Column self = (Column) event.getTarget();
        if (dragged.getClass().getName().endsWith("Column")) {
            int maxRows = dragged.getGrid().getRows().getChildren().size();
            int i = dragged.getParent().getChildren().indexOf(dragged);
            int j = self.getParent().getChildren().indexOf(self);

            //move celles for each row
            for (int k = 0; k < maxRows; k++)
                self.getGrid().getCell(k, j).getParent().insertBefore(self.getGrid()
                                                                          .getCell(k, i), self.getGrid().getCell(k, j));
        }

        self.getParent().insertBefore(dragged, self);
    }

    /**
     * Returns .
     * @return
     */
    public ArrayList<DealIssue> getIssues() {
        System.out.println("getIssues");
        return _data;
    }

    public ArrayList<ColumnInfo> getVisibleColumns() {
        return getColumns(Filter.VISIBLE);
    }

    private ArrayList<ColumnInfo> getColumns(Filter filter) {
        ArrayList<ColumnInfo> list = new ArrayList<ColumnInfo>();
        for (ColumnInfo info : _columns) {
            if (filter.accept(info))
                list.add(info);
        }
        return list;
    }

    interface Filter {

        public boolean accept(ColumnInfo info);

        Filter VISIBLE = new Filter() {

            public boolean accept(ColumnInfo info) {
                return info.isVisible();
            }
        };

        Filter HIDDEN = new Filter() {

            public boolean accept(ColumnInfo info) {
                return !info.isVisible();
            }
        };
    }
}
