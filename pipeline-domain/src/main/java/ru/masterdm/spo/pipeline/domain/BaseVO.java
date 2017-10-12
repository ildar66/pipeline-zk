package ru.masterdm.spo.pipeline.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Base VO.
 * Created by Ildar Shafigullin on 11.09.2017.
 */
public abstract class BaseVO implements Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
