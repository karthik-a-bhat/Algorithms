import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class binarySearchFiles {

    public static int rank(int key, int[] a)
    {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }
    public static void main(String []args)
    {
        int []whitelist= new int[0];  //Make an empty array. Also, int []whitelist = null;(Possible)

        if (args.length>0)
        {
            whitelist = In.readInts(args[0]);   //readInts will return an new array, The variable whitelist will now reference this
        }
        Arrays.sort(whitelist);


        long startTime = System.currentTimeMillis();
        while(!StdIn.isEmpty())
        {
            int key= StdIn.readInt();
            if ((binarySearchRecursive.rank(key,whitelist))<0)
            {
                System.out.println("The given number :"+key+" is not found!");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed: "+(endTime-startTime));
    }
}
