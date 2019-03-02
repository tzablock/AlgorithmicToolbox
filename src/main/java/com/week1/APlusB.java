package com.week1;
import com.common.TimeMeasurer;

import java.util.Scanner;

class APlusB {
    private static int sumOfTwoDigits(int first_digit, int second_digit) {
        return first_digit + second_digit;
    }

    public static void main(String[] args) {
        TimeMeasurer tm = new TimeMeasurer();
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int result = tm.measurePerformence(APlusB::sumOfTwoDigits,a,b);
        System.out.println("Execution time: " + tm.executionTimeAsString());
        System.out.println("Execution memory usage: " + tm.executionMemoryConsumtionAsString());
        System.out.println(result);
    }
}