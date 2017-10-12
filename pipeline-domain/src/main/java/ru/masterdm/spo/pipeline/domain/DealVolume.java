package ru.masterdm.spo.pipeline.domain;

/**
 * Deal volume(Объемы сделок) VO.
 * Created by Ildar Shafigullin on 19.09.2017.
 */
public class DealVolume extends BaseVO {

    private String industryName;
    private long volume;

    /**
     * Returns .
     * @return
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * Sets industry Name.
     * @param industryName industry Name.
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * Returns .
     * @return
     */
    public long getVolume() {
        return volume;
    }

    /**
     * Sets deal Count.
     * @param volume deal Count.
     */
    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DealVolume that = (DealVolume) o;

        return industryName.equals(that.industryName);

    }

    @Override
    public int hashCode() {
        return industryName.hashCode();
    }
}
