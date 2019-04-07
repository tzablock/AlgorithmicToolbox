import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int trials;

    public PercolationStats(int n, int trials){
        this.trials = trials;
        this.thresholds = new double[trials];
        if (n <= 0 || trials <= 0){
            throw new IllegalArgumentException();
        }
        int i = 0;
        while (trials > 0){
            this.thresholds[i] = percolationThresholdEstimate(n);
            i++;
        }
    }    // perform trials independent experiments on an n-by-n grid
    private double percolationThresholdEstimate(int boardSize){
        Percolation p = new Percolation(boardSize);
        while (! p.percolates()){
            p.open(StdRandom.uniform(1, boardSize+1), StdRandom.uniform(1, boardSize+1));
        }
        return ((double)p.numberOfOpenSites())/((double)boardSize*boardSize);
    }
    public double mean(){
        return StdStats.mean(this.thresholds);
// sample mean of percolation threshold
    }
    public double stddev(){
        return StdStats.stddev(this.thresholds);
    }                        // sample standard deviation of percolation threshold
    public double confidenceLo(){
        return StdStats.mean(this.thresholds) - 1.96*StdStats.stddev(this.thresholds)/Math.sqrt(this.trials);
        // low  endpoint of 95% confidence interval
    }
    public double confidenceHi(){
        return StdStats.mean(this.thresholds) + 1.96*StdStats.stddev(this.thresholds)/Math.sqrt(this.trials);
        // high endpoint of 95% confidence interval
    }

    public static void main(String[] args){
        if (args.length != 2){
            throw new RuntimeException("Arguments: sizeOfBoard numberOfTries");
        }
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(String.format("mean                    = %s", ps.mean()));
        System.out.println(String.format("stddev                  = %s", ps.stddev()));
        System.out.println("95% " + String.format("confidence interval = [%s,  %s]", ps.confidenceLo(), ps.confidenceHi()));
        // test client (described below)
    }
}
