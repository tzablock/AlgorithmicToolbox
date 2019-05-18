package com.week1.algoritms;

import static com.week1.algoritms.SelectionSortJava.SortType.*;

public class Test {
    public static void main(String[] args){
        int[] arr = {4,2,7,23,1,5,1,9,3};
        InsertSortJava is = new InsertSortJava(arr);
        int[] sArr = is.sort();
        printArray(sArr);

        int [] arr1 = {3,6,3,2,7,8,92};
        SelectionSortJava ssj = new SelectionSortJava(arr1, ASC);
        int[] sArr1 = ssj.sort();
        printArray(sArr1);

        int[] arr2 = {4,2,7,23,1,5,1,9,3};
        BubbleSort bs = new BubbleSort(arr2);
        int[] sArr2 = bs.sort();
        printArray(sArr2);
    }

    private static void printArray(int[] sArr) {
        System.out.println();
        for (int e: sArr) {
            System.out.print(e);
            System.out.print(" ");
        }
    }
}
