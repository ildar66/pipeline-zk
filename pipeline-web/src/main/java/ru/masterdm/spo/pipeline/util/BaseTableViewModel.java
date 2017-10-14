package ru.masterdm.spo.pipeline.util;

import java.util.ArrayList;

import org.zkoss.zul.Column;

/**
 * Base table view model.
 * Created by Ildar Shafigullin on 14.10.2017.
 */
public class BaseTableViewModel {

    protected ArrayList<ColumnInfo> _columns;

    public ArrayList<ColumnInfo> getVisibleColumns() {
        return getColumns(Filter.VISIBLE);
    }

    public ArrayList<ColumnInfo> getHiddenColumns() {
        return getColumns(Filter.HIDDEN);
    }

    private ArrayList<ColumnInfo> getColumns(Filter filter) {
        ArrayList<ColumnInfo> list = new ArrayList<>();
        for (ColumnInfo info : _columns) {
            if (filter.accept(info))
                list.add(info);
        }
        return list;
    }

    protected void swapColumns(Column dragColumn, Column dropColumn) {
        int dragColumnIndex = getIndexColumn(dragColumn.getLabel());
        ColumnInfo dragged = _columns.remove(dragColumnIndex);
        int dropColumnIndex = getIndexColumn(dropColumn.getLabel());
        _columns.add(dropColumnIndex, dragged);
        dropColumn.getParent().insertBefore(dragColumn, dropColumn);
    }

    private int getIndexColumn(String label) {
        int index = -1;
        for (int i = 0; i < _columns.size(); i++) {
            if (_columns.get(i).getLabel().equals(label)) {
                index = i;
                break;
            }
        }
        return index;
    }

    interface Filter {

        boolean accept(ColumnInfo info);

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
