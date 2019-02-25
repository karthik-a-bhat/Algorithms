//Algorithm to calculate 3-SUM problem in quadratic time ->O(n^2).
// Also Omega(n^2). This is the lower bound for the problem.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumVeryFast {

    public static boolean checkDuplicateValues(int[] a){
        for(int i=1;i<a.length;++i){
            if(a[i]==a[i-1]) return true;
        }
        return false;
    }

    public static int threeSumVeryFastCounter(int[] a){

        Arrays.sort(a);
        int count=0,s,e;

        for(int i=0;i<a.length;i++){
            s=i+1;
            e=a.length-1;

            while (s<e){
                if(a[i]+a[s]+a[e]==0) {
                    count++;
                    s+=1;
                    e-=1;
                }
                else if(a[i]+a[s]+a[e] >0) e-=1;
                else s+=1;
            }
        }
        return count;
    }

    public static void main(String[] args){

        int[]a= In.readInts(args[0]);


        int count=0; double endTime=0;

        if(!ThreeSumVeryFast.checkDuplicateValues(a)) {
            Stopwatch timer = new Stopwatch();
            count = ThreeSumVeryFast.threeSumVeryFastCounter(a);
            endTime = timer.elapsedTime();
        }
        System.out.println("Count is: "+count+" and elapsed time is: "+endTime);
    }
}
