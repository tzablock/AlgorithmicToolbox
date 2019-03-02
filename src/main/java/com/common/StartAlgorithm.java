package com.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartAlgorithm {
    public static void main(String[] ards){
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory()-runtime.freeMemory()); //bytes
        List<String> ssA = Arrays.asList("sdssd","sddssd","sffds");
        System.out.println(runtime.totalMemory()-runtime.freeMemory()); //bytes
    }
}
