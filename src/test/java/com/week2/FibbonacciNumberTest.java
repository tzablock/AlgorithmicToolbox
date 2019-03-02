package com.week2;

import com.weeks2.FibbonacciNumber;
import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class FibbonacciNumberTest {
    FibbonacciNumber fn = new FibbonacciNumber();

    @Test
    public void fibNum20ShouldHaveValue6765() {
        BigInteger r = fn.run(20);
        assertThat(r).isEqualTo(BigInteger.valueOf(6765));
    }
    @Test
    public void fibNum50ShouldHaveValue12586269025() {
        BigInteger r = fn.run(50);
        assertThat(r).isEqualTo(BigInteger.valueOf(12586269025l));
    }
    @Test
    public void fibNum100ShouldHaveValue354224848179261915075() {
        BigInteger r = fn.run(100);
        assertThat(r).isEqualTo(new BigInteger("354224848179261915075"));
    }
    @Test
    public void fibNum500ShouldHaveValu139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125() {
        BigInteger r = fn.run(500);
        assertThat(r).isEqualTo(new BigInteger("139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125"));
    }
}
