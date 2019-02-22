//Implementation of 3Sum algorithm in O((n^2)(lgn)) time

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumFast {

    //Total function takes about O((n^2)lg n)
    public static int threeSumCount(int[] a) {

        int n = a.length, k, count = 0;
        Arrays.sort(a);   // O(n lgn) time

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {                       //These two loops take O(n^2)
                k = binarySearchRecursive.rank(-(a[i] + a[j]), a);  //Takes O(lgn)
                if (k > j) count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[]a= In.readInts(args[0]);
        Stopwatch timer = new Stopwatch();
        int count=ThreeSumFast.threeSumCount(a);
        double endTime=timer.elapsedTime();
        System.out.println("Count is: "+count+" and elapsed time is: "+endTime);
    }
}
