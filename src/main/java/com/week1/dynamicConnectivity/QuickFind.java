package com.week1.dynamicConnectivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//n2
public class QuickFind implements UF {
    private List<Integer> objects;

    public QuickFind(Integer n) {
        this.objects = IntStream.range(0,n).boxed().collect(Collectors.toList());
    }

    @Override
    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    @Override
    public void union(int i, int j) {
        Integer iVal = objects.get(i);
        Integer jVal = objects.get(j);
        objects.replaceAll(o -> o==iVal?jVal:o);
    }

    private int count() {
        return objects.size();
    }

    private int find(int i) {
        return objects.get(i);
    }
}
