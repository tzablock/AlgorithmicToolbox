package com.week1.algoritms;

public class BubbleSort {
    private int[] arr;
    private boolean swap = true;


    public BubbleSort(int[] arr) {
        this.arr = arr;
    }


    public int[] sort(){ //O(n2)
        // sort only remaining elements
        // stop when no swaps
        for (int i = 0; i < arr.length; i++){
            if (this.swap){
                this.swap = false;
                sortNextElement(i);
            }
        }

        return arr;
    }

    private void sortNextElement(int i) {
        final int COMPARE_WITH_NEXT = 1;
        for (int j = 0; j < arr.length - COMPARE_WITH_NEXT - i; j ++){
            if (arr[j] > arr[j + COMPARE_WITH_NEXT]){
                swap(j, j + COMPARE_WITH_NEXT);
            }
        }
    }

    private void swap(int f, int s){
        this.swap = true;
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
