package com.week1.excercise1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {
    //o X X
    //o X X
    //X X X
    @Test
    void ifBoard3on3WontPercolateIfWeOpenAllSidesWithoutLastOne() {
        Percolation out = new Percolation(3);
        out.open(1,1);
        out.open(2,1);

        assertThat(out.percolates()).isFalse();
        assertThat(out.isOpen(1,1)).isTrue();
        assertThat(out.isOpen(2,1)).isTrue();
        assertThat(out.isFull(1,1)).isTrue();
        assertThat(out.isFull(2,1)).isTrue();
        assertThat(out.isOpen(3,1)).isFalse();
        assertThat(out.isFull(3,1)).isFalse();
        assertThat(out.numberOfOpenSites()).isEqualTo(2);
    }

    //o X X
    //o X X
    //o X X
    @Test
    void ifBoard3on3PercolateIfWeOpenAllSidesInOneLine() {
        Percolation out = new Percolation(3);
        out.open(1,1);
        out.open(2,1);
        out.open(3,1);

        assertThat(out.percolates()).isTrue();
        assertThat(out.isOpen(1,1)).isTrue();
        assertThat(out.isOpen(2,1)).isTrue();
        assertThat(out.isFull(1,1)).isTrue();
        assertThat(out.isFull(2,1)).isTrue();
        assertThat(out.isOpen(3,1)).isTrue();
        assertThat(out.isFull(3,1)).isTrue();
        assertThat(out.isOpen(3,3)).isFalse();
        assertThat(out.isFull(3,3)).isFalse();
        assertThat(out.numberOfOpenSites()).isEqualTo(3);
    }

    //o X X X
    //o X X X
    //o X X X
    //o X X X
    @Test
    void ifBoard4on4PercolateIfWeOpenAllSidesInOneLine() {
        Percolation out = new Percolation(4);
        out.open(1,1);
        out.open(2,1);
        out.open(3,1);
        out.open(4,1);

        assertThat(out.percolates()).isTrue();
        assertThat(out.isOpen(1,1)).isTrue();
        assertThat(out.isOpen(2,1)).isTrue();
        assertThat(out.isFull(1,1)).isTrue();
        assertThat(out.isFull(2,1)).isTrue();
        assertThat(out.isOpen(3,1)).isTrue();
        assertThat(out.isFull(3,1)).isTrue();
        assertThat(out.isOpen(4,1)).isTrue();
        assertThat(out.isFull(4,1)).isTrue();
        assertThat(out.isOpen(3,3)).isFalse();
        assertThat(out.isFull(3,3)).isFalse();
        assertThat(out.numberOfOpenSites()).isEqualTo(4);
    }

    //o X o
    //X o o
    //o o X
    @Test
    void ifBoard3on3PercolateIfWeOpenSidesNotInOneLine() {
        Percolation out = new Percolation(3);
        out.open(1,1);
        out.open(1,3);
        out.open(2,2);
        out.open(2,3);
        out.open(3,1);
        out.open(3,2);

        assertThat(out.percolates()).isTrue();
        assertThat(out.isOpen(1,1)).isTrue();
        assertThat(out.isFull(1,1)).isTrue();
        assertThat(out.isOpen(1,3)).isTrue();
        assertThat(out.isFull(1,3)).isTrue();
        assertThat(out.isOpen(2,2)).isTrue();
        assertThat(out.isFull(2,2)).isTrue();
        assertThat(out.isOpen(2,3)).isTrue();
        assertThat(out.isFull(2,3)).isTrue();
        assertThat(out.isOpen(3,1)).isTrue();
        assertThat(out.isFull(3,1)).isTrue();
        assertThat(out.isOpen(3,2)).isTrue();
        assertThat(out.isFull(3,2)).isTrue();
        assertThat(out.isOpen(2,1)).isFalse();
        assertThat(out.isFull(2,1)).isFalse();
        assertThat(out.isOpen(3,3)).isFalse();
        assertThat(out.isFull(3,3)).isFalse();
        assertThat(out.numberOfOpenSites()).isEqualTo(6);
    }

    //X X X
    //o o o
    //X X X
    @Test
    void ifForBoard3on3WeCheckProperlyVerticalCornerCase() {
        Percolation out = new Percolation(3);
        out.open(2, 1);
        out.open(2, 2);
        out.open(2, 3);

        assertThat(out.numberOfOpenSites()).isEqualTo(3);
        assertThat(out.percolates()).isFalse();
        assertThat(out.isOpen(2,1)).isTrue();
        assertThat(out.isFull(2,1)).isFalse();
        assertThat(out.isOpen(2,2)).isTrue();
        assertThat(out.isFull(2,2)).isFalse();
        assertThat(out.isOpen(2,3)).isTrue();
        assertThat(out.isFull(2,3)).isFalse();
    }

    //X o X
    //X o X
    //X o X
    @Test
    void ifForBoard3on3WeCheckProperlyHorizontalCornerCase() {
        Percolation out = new Percolation(3);
        out.open(1, 2);
        out.open(2, 2);
        out.open(3, 2);

        assertThat(out.numberOfOpenSites()).isEqualTo(3);
        assertThat(out.percolates()).isTrue();
        assertThat(out.isOpen(1,2)).isTrue();
        assertThat(out.isFull(1,2)).isTrue();
        assertThat(out.isOpen(2,2)).isTrue();
        assertThat(out.isFull(2,2)).isTrue();
        assertThat(out.isOpen(3,2)).isTrue();
        assertThat(out.isFull(3,2)).isTrue();
    }
    //X X o
    //X X o
    //X X o
    @Test
    void ifForBoard3on3WeCheckProperlyRightHorizontalCornerCase() {
        Percolation out = new Percolation(3);
        out.open(1, 3);
        out.open(2, 3);
        out.open(3, 3);

        assertThat(out.numberOfOpenSites()).isEqualTo(3);
        assertThat(out.percolates()).isTrue();
        assertThat(out.isOpen(1,3)).isTrue();
        assertThat(out.isFull(1,3)).isTrue();
        assertThat(out.isOpen(2,3)).isTrue();
        assertThat(out.isFull(2,3)).isTrue();
        assertThat(out.isOpen(3,3)).isTrue();
        assertThat(out.isFull(3,3)).isTrue();
    }

    //o X X
    //o X X
    //o X X
    @Test
    void ifForBoard3on3WeCheckProperlyLeftHorizontalCornerCase() {
        Percolation out = new Percolation(3);
        out.open(1, 1);
        out.open(2, 1);
        out.open(3, 1);

        assertThat(out.numberOfOpenSites()).isEqualTo(3);
        assertThat(out.percolates()).isTrue();
        assertThat(out.isOpen(1,1)).isTrue();
        assertThat(out.isFull(1,1)).isTrue();
        assertThat(out.isOpen(2,1)).isTrue();
        assertThat(out.isFull(2,1)).isTrue();
        assertThat(out.isOpen(3,1)).isTrue();
        assertThat(out.isFull(3,1)).isTrue();
    }

    @Test
    void ifForBoard20on20WeCheckProperlyLeftCornerNotPercolateCase(){
        try {
            Scanner sc = new Scanner(Paths.get("/Users/tomaszzablocki/Projects/AlgorithmicToolbox/src/main/java/com/week1/excercise1/input20.txt"));
            int n = sc.nextInt();
            Percolation out = new Percolation(n);
            while (sc.hasNextInt()){
                int x = sc.nextInt();
                int y = sc.nextInt();
                out.open(x,y);
            }
            assertThat(out.isOpen(1,18)).isTrue();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void ifForBoard57on57WeCheckProperlyLeftCornerNotPercolateCase(){
        try {
            Scanner sc = new Scanner(Paths.get("/Users/tomaszzablocki/Projects/AlgorithmicToolbox/src/main/java/com/week1/excercise1/greeting57.txt"));
            int n = sc.nextInt();
            Percolation out = new Percolation(n);
            while (sc.hasNextInt()){
                int x = sc.nextInt();
                int y = sc.nextInt();
                out.open(x,y);
            }
            assertThat(out.isOpen(28,28)).isTrue();
            assertThat(out.isFull(28,28)).isTrue();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void test(){
        System.out.println(1%5);
    }
}