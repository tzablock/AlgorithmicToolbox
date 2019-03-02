package com.weeks2;

import com.common.TimeMeasurer;

import java.io.IOException;
import java.util.Scanner;

public class FibbonacciNumberRun {
    public static void main(String[] args) {
        TimeMeasurer tm = new TimeMeasurer();
        int num = new Scanner(System.in).nextInt();
        System.out.println(tm.measurePerformence(new FibbonacciNumber()::run,num));
        System.out.println(tm.executionTimeAsString());
        System.out.println(tm.executionMemoryConsumtionAsString());
    }
}
