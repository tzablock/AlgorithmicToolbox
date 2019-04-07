public class Percolation {  // check if better array of arrays or one array with calculation what have better performance
    private int gridSize;
    private List<Integer> sites;
    private List<Integer> weights;

    public Percolation(int n){
        if (n <= 0){
            throw new IllegalArgumentException();
        }
        initializeClosedSitesWithTreesWeights(n);
    }                // create n-by-n grid, with all sites blocked

    public void open(int row, int col){  //TODO from 1,2 weight grow by twice...
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
        if (weights.get(sIndx) == 0){
            this.weights.set(sIndx,1);
        }
    }

    public boolean isOpen(int row, int col){
        return this.weights.get(findRoot(getSite(row,col))) >= 1;
    }  // is site (row, col) open?

    public boolean isFull(int row, int col){
        return isConnected(getSite(row,col),0);
    }  // is site (row, col) full?

    public boolean percolates(){
        int topIndx = 0;
        int lastIndxExcl = sites.size();  // 0 1 2 3 4    2
        return IntStream.range(lastIndxExcl-this.gridSize, lastIndxExcl).anyMatch(i -> isConnected(topIndx, i));
    }              // does the system percolate?

    public int numberOfOpenSites(){
        final int EXTRA_FIRST = 1;
        return (int) weights.stream().filter(w -> w != 0).count() - EXTRA_FIRST;
    }       // number of open sites

    private void initializeClosedSitesWithTreesWeights(int n) {
        this.gridSize = n;
        final int EXTRA_FIRST = 1;
        this.sites = IntStream.range(0,n*n + EXTRA_FIRST).boxed().collect(Collectors.toList());
        this.weights = IntStream.range(0,n*n + EXTRA_FIRST).boxed().map(i -> 0).collect(Collectors.toList());
        this.weights.set(0,1);
        //this.weights.set(weights.size()-1,1); //TODO obliczyc ile
    }

    private int getSite(int r, int c){
        if(r > gridSize || c > gridSize){
            throw new IllegalArgumentException();
        }
        return sites.get(c + (r-1) * gridSize);
    }

    private int getUpSiteIndx(int sIndx) {
        if (sIndx <= this.gridSize){
            return 0;
        } else {
            return sIndx - this.gridSize;
        }
    }

    private int getDownSiteIndx(int sIndx) {
        int bottom = this.sites.size() - 1;
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
        int wi = weights.get(ri);
        int wj = weights.get(rj);

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
        while (sites.get(i) != i){
            i = sites.get(i);
        }
        return i;
    }

    private boolean isConnected(int i, int j){
        return findRoot(i) == findRoot(j);
    }

    private void mergeTrees(int rBigTree, int rSmallTree, int weight) {
        weights.set(rBigTree, weight);
        sites.set(rSmallTree, rBigTree);
    }

    private void flattenTree(int i, int j, int root) {
        sites.set(i, root);
        sites.set(j, root);
    }
}
