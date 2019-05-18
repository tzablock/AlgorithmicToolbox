package com.week1.excercise1;

public class Percolation {  // check if better array of arrays or one array with calculation what have better performance
    private int gridSize;
    private int[] sites;
    private int[] weights;

    public Percolation(int n){
        if (n <= 0){
            throw new IllegalArgumentException();
        }
        initializeClosedSitesWithTreesWeights(n);
    }                // create n-by-n grid, with all sites blocked

    public void open(int row, int col){
        int sIndx = getSite(row,col);
        int upSiteIndx = getUpSiteIndx(sIndx);
        int downSiteIndx = getDownSiteIndx(sIndx);
        int leftSiteIndx = getLeftSiteIndx(sIndx);
        int rightSiteIndx = getRightSiteIndx(sIndx);
        openSide(sIndx);

        union(sIndx,upSiteIndx);
        unionIfNeighbourSite(sIndx, downSiteIndx);
        unionIfNeighbourSite(sIndx, rightSiteIndx);
        unionIfNeighbourSite(sIndx, leftSiteIndx);
    }    // open site (row, col) if it is not open already

    private void openSide(int sIndx) {
        if (weights[sIndx] == 0){
            this.weights[sIndx] = 1;
        }
    }

    public boolean isOpen(int row, int col){
        return this.weights[findRoot(getSite(row,col))] >= 1;
    }  // is site (row, col) open?

    public boolean isFull(int row, int col){
        return isConnected(getSite(row,col),0);
    }  // is site (row, col) full?

    public boolean percolates(){
        int topIndx = 0;
        int lastIndxExcl = sites.length;
        int begin = lastIndxExcl-this.gridSize;
        while (begin < lastIndxExcl){
            if (isConnected(topIndx, begin)){
                return true;
            }
            begin++;
        }
        return false;
    }              // does the system percolate?

    public int numberOfOpenSites(){
        final int EXTRA_FIRST = 1;
        int openSites = 0;
        for (int w: this.weights){
            if (w != 0){
                openSites++;
            }
        }
        return openSites - EXTRA_FIRST;
    }       // number of open sites

    private void initializeClosedSitesWithTreesWeights(int n) {
        this.gridSize = n;
        final int EXTRA_FIRST = 1;
        this.sites = rangeArray(0, n*n + EXTRA_FIRST, false);
    //.range(0,n*n + EXTRA_FIRST).boxed().collect(Collectors.toList());

        this.weights = rangeArray(0, n*n + EXTRA_FIRST, true);
        this.weights[0] = 1;
        //this.weights.set(weights.size()-1,1); //TODO obliczyc ile
    }

    private int[] rangeArray(int start, int end, boolean isZeroInit){
        int[] na = new int[end];
        while (start < end){
            if (isZeroInit){
                na[start] = 0;
            } else {
                na[start] = start;
            }
            start++;
        }
        return na;
    }

    private int getSite(int r, int c){
        if(r > gridSize || c > gridSize){
            throw new IllegalArgumentException();
        }
        return sites[c + (r-1) * gridSize];
    }

    private int getUpSiteIndx(int sIndx) {
        if (sIndx <= this.gridSize){
            return 0;
        } else {
            return sIndx - this.gridSize;
        }
    }

    private int getDownSiteIndx(int sIndx) {
        int bottom = this.sites.length - 1;
        if (sIndx > bottom - this.gridSize){
            return -1;
        } else {
            return sIndx + this.gridSize;
        }
    }

    private int getLeftSiteIndx(int sIndx) {
        if (sIndx%this.gridSize == 1){
            return  -1;
        } else {
            return sIndx - 1;
        }
    }

    private int getRightSiteIndx(int sIndx) {
        if (sIndx%this.gridSize == 0){
            return -1;
        } else {
            return sIndx + 1;
        }
    }

    private void unionIfNeighbourSite(int sIndx, int nsIndx) {
        if (nsIndx != -1){
            union(sIndx,nsIndx);
        }
    }

    private void union(int i, int j){
        int ri = findRoot(i);
        int rj = findRoot(j);
        int wi = weights[ri];
        int wj = weights[rj];

        if (wi == 0 || wj == 0 || ri == rj){
            return;
        }

        if (wi < wj){
            mergeTrees(rj, ri, wi + wj);
            flattenTree(i, j, rj);
        } else {
            mergeTrees(ri, rj, wi + wj);
            flattenTree(i, j, ri);
        }
    }

    private int findRoot(int i){
        while (sites[i] != i){
            i = sites[i];
        }
        return i;
    }

    private boolean isConnected(int i, int j){
        return findRoot(i) == findRoot(j);
    }

    private void mergeTrees(int rBigTree, int rSmallTree, int weight) {
        weights[rBigTree] = weight;
        sites[rSmallTree] = rBigTree;
    }

    private void flattenTree(int i, int j, int root) {
        sites[i] = root;
        sites[j] = root;
    }
}
