package com.weeks2;

import java.util.Collections;
import java.util.stream.IntStream;

public class GreatestCommonDivisor {
    int calculateGCD(final int a, final int b){
        if (a == 0){
            return b;
        }
        if (b == 0){
            return a;
        }
        final int smallerNum = Math.min(a,b);
        return IntStream.range(1,smallerNum+1).boxed()
                        .sorted(Collections.reverseOrder())
                        .filter(d -> b%d == 0)
                        .filter(d -> a%d == 0)
                        .findFirst().orElse(1);
    }
    int calculateGCDalternative(final int a, final int b){
        if (b==0){
            return a;
        }
        return calculateGCDalternative(b,a%b);
    }
}
