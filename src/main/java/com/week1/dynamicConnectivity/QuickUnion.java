package com.week1.dynamicConnectivity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//n
public class QuickUnion implements UF
{
    private List<Integer> objects;

    public QuickUnion(int n) {
        this.objects = IntStream.range(0,n).boxed().collect(Collectors.toList());
    }

    @Override
    public boolean connected(int i, int j) {
        return find(i)==find(j);
    }

    @Override
    public void union(int i, int j) {
        objects.set(find(i),find(j));
    }

    private int find(int i){
        while (i != objects.get(i)){
            i = objects.get(i);
        }
        return i;
    }
}
