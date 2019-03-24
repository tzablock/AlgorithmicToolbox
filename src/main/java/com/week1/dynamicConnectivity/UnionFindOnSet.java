package com.week1.dynamicConnectivity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
// n3
public class UnionFindOnSet implements UF{
    private List<Component> components;

    UnionFindOnSet(int objectsNum) {
        this.components = IntStream.range(0, objectsNum)
                .boxed()
                .map(
                        Component::new
                ).collect(toList());
    }

    public boolean connected(int i, int j) {
        Component iComp = findWrappComponent(i);
        return iComp == null ? false : iComp.contains(j);
    }

    public void union(int i, int j) {
        Component fc = findWrappComponent(i);
        fc.union(findWrappComponent(j));
    }

    public int count() {
        return components.size();
    }

    public int find(int i) {
        return components.indexOf(findWrappComponent(i));
    }

    private Component findWrappComponent(int i) {
        return components.stream()
                .filter(
                        c -> c.contains(i)
                ).collect(Collectors.toList()).get(0);
    }

}
