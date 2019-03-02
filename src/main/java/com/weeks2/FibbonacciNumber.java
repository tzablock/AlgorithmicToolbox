package com.weeks2;

import java.io.IOException;
import java.math.BigInteger;

public class FibbonacciNumber {
    public BigInteger run(int num) {
        FibbonacciNumber fn = new FibbonacciNumber();
        BigInteger firstNum = BigInteger.ZERO;
        if (num == 0){
            return firstNum;
        }
        BigInteger secNum = BigInteger.ONE;
        if (num == 1){
            return secNum;
        }

        for (int i = num-2; i >= 0; i--) {
            BigInteger tempNum = secNum;
            secNum = fn.nextNum(firstNum, secNum);
            firstNum = tempNum;
        }
        return secNum;
    }

    private BigInteger nextNum(BigInteger prevOne, BigInteger prevTwo) {
        return prevOne.add(prevTwo);
    }
}