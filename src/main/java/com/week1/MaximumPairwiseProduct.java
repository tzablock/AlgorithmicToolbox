package com.week1;

import com.common.TimeMeasurer;
import org.w3c.dom.ranges.Range;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class MaximumPairwiseProduct {
    public static void main(String[] args) {  //do 100 000
        try {
            TimeMeasurer tm = new TimeMeasurer();

            Scanner s = new Scanner(Paths.get("/home/tzablock/IdeaProjects/coursera/AlgorithmicToolboxCourse/src/main/resources/week1/MaximumPairwiseProduct"));
            long numCount = s.nextLong();
            List<Long> in = new ArrayList<>();
            while (s.hasNext()) {
                in.add(s.nextLong());
            }
            //List<Long> in = LongStream.range(0,100000).boxed().collect(toList());

            long res = tm.measurePerformence(MaximumPairwiseProduct::maxProd,in);
            System.out.println(String.format("Result %d", res));
            System.out.println(tm.executionTimeAsString());
            System.out.println(tm.executionMemoryConsumtionAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long maxProd(List<Long> in) {
        long fBig = 0;
        long sBig = 0;
        for (Long nextNum : in) {
            if (nextNum > fBig) {
                sBig = fBig > sBig ? fBig : sBig;
                fBig = nextNum;
            } else if (nextNum > sBig) {
                sBig = nextNum;
            }
        }
        return fBig * sBig;
    }
}
