package com.common;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TimeMeasurer {
    private long timeNanoSec;
    private long memUseBytes;

    private long startTime;
    private long stopTime;

    /**
     *
     * @param func  function to be measured with one input
     * @param input input for measured function
     * @return result of measured function
     */
    public <I,O> O measurePerformence(Function<I,O> func, I input){
        startMeasure();
        O result = func.apply(input);
        stopMeasure();
        return result;
    }

    /**
     *
     * @param func supplier function to be measured with one input
     * @return result of measured function
     */
    public <O> O measurePerformence(Supplier<O> func){
        startMeasure();
        O result = func.get();
        stopMeasure();
        return result;
    }

    /**
     *
     * @param func  consumer function to be measured with two inputs
     * @param in1 input for measured function
     * @param in2 input for measured function
     */
    public <I1,I2> void measurePerformence(BiConsumer<I1, I2> func, I1 in1, I2 in2){
        startMeasure();
        func.accept(in1,in2);
        stopMeasure();
    }

    /**
     *
     * @param func function to be measured with two inputs
     * @param in1 input for measured function
     * @param in2 input for measured function
     * @return result of measured function
     */
    public <I1,I2,O> O measurePerformence(BiFunction<I1, I2, O> func, I1 in1, I2 in2){
        startMeasure();
        O result = func.apply(in1,in2);
        stopMeasure();
        return result;
    }
    private void startMeasure(){
        this.startTime = System.nanoTime();
    }
    private void stopMeasure(){
        Runtime runtime = Runtime.getRuntime();
        this.stopTime = System.nanoTime();
        runtime.gc();
        this.memUseBytes = runtime.totalMemory()-runtime.freeMemory();
        this.timeNanoSec = stopTime - startTime;
    }

    public String executionTimeAsString(){
        final int NANO_IN_SEC = 1000000000;
        final int NANO_IN_MILLISEC = 1000000;
        long sec = timeNanoSec/ NANO_IN_SEC;
        long millSec = timeNanoSec/ NANO_IN_MILLISEC;
        long nanoSec = timeNanoSec - sec*NANO_IN_SEC - millSec*NANO_IN_MILLISEC;
        return String.format("%d s %d ms %d ns",sec,millSec,nanoSec);
    }
    public String executionMemoryConsumtionAsString(){
        final long MB_TO_BYTES = 1048576;
        final long KB_TO_BYTES = 1024;
        long mb = memUseBytes/MB_TO_BYTES;
        long kb = memUseBytes/KB_TO_BYTES;
        long b = memUseBytes - mb*MB_TO_BYTES - kb*KB_TO_BYTES;
        return String.format("%d mb %d kb %d bytes",mb,kb,b);
    }
}
