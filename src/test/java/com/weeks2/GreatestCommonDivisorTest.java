package com.weeks2;

import com.common.TimeMeasurer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestCommonDivisorTest {
    GreatestCommonDivisor gcd = new GreatestCommonDivisor();
    @Test
    void for10and4ShouldGive2() {
        int d = gcd.calculateGCD(10,4);
        Assertions.assertThat(d).isEqualTo(2);
    }

    @Test
    void for3918848and1653264ShouldGive61232() {
        TimeMeasurer tm = new TimeMeasurer();
        int d = tm.measurePerformence(gcd::calculateGCD,3918848,1653264);
        System.out.println(tm.executionTimeAsString());
        System.out.println(tm.executionMemoryConsumtionAsString());
        Assertions.assertThat(d).isEqualTo(61232);
    }
    @Test
    void alternativeFor3918848and1653264ShouldGive61232() {
        TimeMeasurer tm = new TimeMeasurer();
        int d = tm.measurePerformence(gcd::calculateGCDalternative,3918848,1653264);
        System.out.println(tm.executionTimeAsString());
        System.out.println(tm.executionMemoryConsumtionAsString());
        Assertions.assertThat(d).isEqualTo(61232);
    }
}