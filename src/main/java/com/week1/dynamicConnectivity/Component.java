package com.week1.dynamicConnectivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Component {
    private Set<Integer> objects;

    public Component(Integer partOfComponent) {
        this.objects = new HashSet<>(Arrays.asList(partOfComponent));
    }

    public Component union(Component secComp){
        this.objects.addAll(secComp.objects);
        return this;
    }

    public boolean contains(Integer object){
        return objects.contains(object);
    }
}
