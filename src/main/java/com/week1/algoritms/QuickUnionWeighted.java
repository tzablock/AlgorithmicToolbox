package com.week1.algoritms;

import com.week1.dynamicConnectivity.UF;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickUnionWeighted implements UF {
    private List<Integer> objects;
    private List<Integer> weights; // first improvement for quick union

    public QuickUnionWeighted(int n) {
        this.objects = IntStream.range(0,n).boxed().collect(Collectors.toList());
        this.weights = IntStream.range(0,n).boxed().map(i -> 1).collect(Collectors.toList());
    }

    @Override
    public boolean connected(int i, int j) {
        return findRoot(i) == findRoot(j);
    }

    @Override
    public void union(int i, int j) {

        int rj = findRoot(j);
        int ri = findRoot(i);
        int wi = weight(ri);
        int wj = weight(rj);
        if (rj == ri){  // if the same tree no need to merge
            return;
        }
        if (wi < wj){
            joinTrees(rj, ri, wi + wj);
            flattenTree(rj, i, j);  // second improvement
        } else {
            joinTrees(ri, rj, wi + wj);
            flattenTree(ri, i, j);  // second improvement
        }
    }

    private void flattenTree(int nRoot, int i, int j) {
        this.objects.set(i, nRoot);
        this.objects.set(j, nRoot);
    }

    private void joinTrees(int btRootIndx, int stRootIndx, int nWeight) {
        objects.set(stRootIndx, btRootIndx);
        weights.set(btRootIndx, nWeight);
    }

    private int findRoot(int i){
        while (i != objects.get(i)){
            i = objects.get(i);
        }
        return i;
    }

    private int weight(int i){
        return this.weights.get(i);
    }
}
