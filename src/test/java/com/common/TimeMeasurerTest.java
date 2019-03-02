package com.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeMeasurerTest {//TODO make test generator project
    @Test
    public void measureTimeShouldCreateCorrectTimeMessureInStringFormat() {
        TimeMeasurer tm = new TimeMeasurer();
        tm.measurePerformence((Integer i)->i*i, 10);
        String r = tm.executionTimeAsString();
        System.out.println(r);
        assertThat(r.matches("[0-9]* s [0-9]* ms [0-9]* ns")).isTrue();
    }

    @Test
    public void measureTimeShouldReturnCorrectFuctionResultWithTheSameType() {
        TimeMeasurer tm = new TimeMeasurer();
        int r = tm.measurePerformence((Integer i)->i*i, 10);
        assertThat(r).isEqualTo(100);
    }

    @Test
    public void measureTimeShouldCreateCorrectMemoryUsageMessureInStringFormat() {
        TimeMeasurer tm = new TimeMeasurer();
        tm.measurePerformence((Integer i)->i*i, 10);
        String r = tm.executionMemoryConsumtionAsString();
        System.out.println(r);
        assertThat(r.matches("[0-9]* mb [0-9]* kb [0-9]* bytes")).isTrue();
    }
}
