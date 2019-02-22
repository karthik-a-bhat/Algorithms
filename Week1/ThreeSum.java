//In an given array, the number of triple values that will sum to 0

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {

    public static int calculate(int []a)
    {
        int count=0;
        for (int i=0;i<a.length;++i)
        {
            for (int j=i+1;j<a.length;++j)
            {
                for (int k=j+1;k<a.length;++k)
                {
                    if(a[i]+a[j]+a[k]==0) count+=1;
                }
            }
        }
        return count;
    }

    public static void main(String...args)
    {
        int[]a= In.readInts(args[0]);
        Stopwatch sw= new Stopwatch();
        System.out.println("Started");
        int count=ThreeSum.calculate(a);
        System.out.println("Count is "+count);

        System.out.println(sw.elapsedTime());
    }
}
