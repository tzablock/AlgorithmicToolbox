package com.common;

import java.util.function.Function;

public class TimeMeasurer {
    private long timeMillis;
    public <I,O> O measureTime(Function<I,O> func, I input){
        long start = System.currentTimeMillis();
        O result = func.apply(input);
        long stop = System.currentTimeMillis();
        this.timeMillis = start - stop;
        return result;
    }
    public String executionTimeAsString(){
        long sec = timeMillis/1000;
        long millSec = timeMillis-sec*1000;
        return String.format("%d s %d ms",sec,millSec);
    }
}
