//PercolationStats class for Assignment 1 of Algorithms-Part 1 by Princeton University
//Created By: Karthik A Bhat
//Created: Jan 30th 2019
//Modified: Jan 31st 2019
//Modified: Feb 1st 2019 - Passed - 82/100


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_VAL =1.96;
    private Percolation p;
    private int sizeofonerow;
    private int total_trials;
    private int gridsize;
    private double[] arr_mean;

    public PercolationStats(int n, int trials)
    {
        if(n<=0 || trials<=0) throw new java.lang.IllegalArgumentException("Value should be greater than 0!");
        total_trials=trials;
        sizeofonerow=n;
        gridsize=n*n;
        arr_mean= new double[trials];

        p= new Percolation(n);

        conduct_trials();
    }

    public static void main(String[] args)
    {
        int n=Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats per_stats = new PercolationStats(n,trials);

        System.out.println("mean         ="+ per_stats.mean());
        System.out.println("stddev       ="+ per_stats.stddev());
        System.out.println("95% confidence interval = ["+per_stats.confidenceLo()+" , "+per_stats.confidenceHi()+"]");

    }

    private void conduct_trials()
    {
        for(int i=0;i<total_trials;++i)
        {
            while(!p.percolates())
            {
                int openRandomRow= StdRandom.uniform(1,(sizeofonerow+1));
                int openRandomCol=StdRandom.uniform(1,(sizeofonerow+1));

                if (!(p.isOpen(openRandomRow, openRandomCol))) p.open(openRandomRow, openRandomCol);
                else continue;

            }
            arr_mean[i] = (double) (p.numberOfOpenSites()) / (gridsize);
        }

    }

    public double mean()
    {
        return (StdStats.mean(arr_mean));
    }

    public double stddev()
    {
        return (StdStats.stddev(arr_mean));
    }

    public double confidenceLo()
    {
        return (mean()-(((CONFIDENCE_VAL)*stddev())/Math.sqrt(total_trials)));
    }

    public double confidenceHi()
    {
        return (mean()+(((CONFIDENCE_VAL)*stddev())/Math.sqrt(total_trials)));
    }
}
