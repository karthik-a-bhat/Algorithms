//Random number generator using the StdRandom library found at edu.cs.princeton.algs4
//Command line arguments supplied

import edu.princeton.cs.algs4.*;

public class randomSeq {
    public static void main(String []args)
    {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for(int i=0; i<N; ++i)
        {
            double value = StdRandom.uniform(lo,hi);
            System.out.println("Random number generated in step "+(i+1)+" is:"+value);
            System.out.printf("Random number (using printf) is : %.2f \n",value);
        }

    }
}
