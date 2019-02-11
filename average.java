//Average of numbers entered in the command line till a Ctrl-D is pressed.

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class average {
    public static void main(String []args)
    {
        int count=0;
        double sum=0;
        System.out.println("Enter the numbers on the command line, press Ctrl-D when done to process further!");
        while(!StdIn.isEmpty())
        {
            sum+=StdIn.readDouble();
            count+=1;
        }

        System.out.printf("The average is %.5f and count is %d",sum,count);

        StdDraw.line(0.0,0.0,3.3,3.3);
    }
}

