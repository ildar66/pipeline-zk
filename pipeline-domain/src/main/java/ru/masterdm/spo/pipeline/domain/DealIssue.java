package ru.masterdm.spo.pipeline.domain;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Issue for deal(Выдачи по сделке) VO.
 * Created by Ildar Shafigullin on 13.10.2017.
 */
public class DealIssue extends BaseVO {

    private String name;
    private Date date;
    private long sum;

    public DealIssue(String name, int dateYear, int dateMonth, int dateDayOfMonth, long sum) {
        this.name = name;
        this.date = new GregorianCalendar(dateYear, dateMonth, dateDayOfMonth).getTime();
        this.sum = sum;
    }

    /**
     * Returns .
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets .
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns .
     * @return
     */
    public long getSum() {
        return sum;
    }

    /**
     * Sets .
     * @param sum
     */
    public void setSum(long sum) {
        this.sum = sum;
    }

    /**
     * Returns .
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets .
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
