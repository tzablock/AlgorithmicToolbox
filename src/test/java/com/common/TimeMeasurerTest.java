package com.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeMeasurerTest {//TODO add test generator
    @Test
    public void measureTimeShouldCreateCorrectTimeMessureInStringFormat() {
        TimeMeasurer tm = new TimeMeasurer();
        tm.measureTime((Integer i)->i*i, 10);
        assertThat(tm.executionTimeAsString().matches())
    }

    @Test
    public void measureTimeShouldReturnCorrectFuctionResultWithTheSameType() {
    }
}
