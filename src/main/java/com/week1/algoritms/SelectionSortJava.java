package com.week1.algoritms;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SelectionSortJava {
    private int[] arr;
    private SortType st;
    enum SortType {
        ASC,
        DESC
    }

    public SelectionSortJava(int[] arr, SortType st) {
        this.arr = arr;
        this.st = st;
    }

    public int[] sort(){ // O(n2)
        BiFunction<Integer, Integer, Boolean> sort = this.st == SortType.ASC ? (Integer f, Integer s) -> f < s: (Integer f, Integer s) -> f > s;
        for (int i = 0; i < arr.length; i++){
            int nextSortIndx = getMaxElemFromNotSorted(i, arr[i], i, sort);
            if (nextSortIndx != i){
                replaceElements(i,nextSortIndx);
            }
        }
        return arr;
    }

    private int getMaxElemFromNotSorted(int notSortBegIndx, int sortElemEl, int maxIndx, BiFunction<Integer,Integer, Boolean> sortCond) {
        for (int j = notSortBegIndx; j < arr.length; j ++){
            if (sortCond.apply(arr[j],sortElemEl)){
                sortElemEl = arr[j];
                maxIndx = j;
            }
        }
        return maxIndx;
    }

    private void replaceElements(int f, int s){
        int t = arr[f];
        arr[f] = arr[s];
        arr[s] = t;
    }
}
