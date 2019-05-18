package com.week1.algoritms;

public class InsertSortJava { //insert sort because we can every time add element to collection and it will be sorted
    int[] arr;

    public InsertSortJava(int[] arr) {
        this.arr = arr.clone();
    }

    public int[] sort(){ // O(n2)
        for (int i = 1; i < arr.length; i++){
            int j = i;
            int value = arr[i];
            while (j>0 && arr[j-1]>value){
                arr[j] = arr[--j];
            }
            arr[j] = value;
        }
        return arr;
    }
}
