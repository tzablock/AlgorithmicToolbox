package com.week1.dynamicConnectivity;

public interface UF {
    boolean connected(int i, int j);
    void union(int i, int j);
}
