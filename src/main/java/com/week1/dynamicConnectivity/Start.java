package com.week1.dynamicConnectivity;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        UF uf = new QuickUnionWeighted(n);
        while (console.hasNextInt()) {
            int i = console.nextInt();
            int j = console.nextInt();
            if (!uf.connected(i,j)){
                uf.union(i,j);
                System.out.println(String.format("%s %s",i,j));
            }
        }

    }
}
