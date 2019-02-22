import java.util.Scanner;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;


public class binarySearchRecursive {
    public static int rank(int key, int []a)
    {
        return rank(key,a,0,a.length-1);

    }
    public static int rank(int key, int []a, int lo, int hi)
    {
        if(lo>hi) return -1;
        int mid= lo+(hi-lo)/2;
        if(key<a[mid]) return binarySearchRecursive.rank(key,a,lo,mid-1);
        if(key>a[mid]) return binarySearchRecursive.rank(key,a,mid+1,hi);
        return mid;
    }
    public static void main(String []args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of array elements");
        int num=input.nextInt();
        System.out.println("\nEnter the elements of the array!");
        int []a=new int[num];
        for(int i=0; i<num;++i)
        {
            a[i]=input.nextInt();
        }

        System.out.println("Array is sorted and displayed:");
        Arrays.sort(a);

        for (int item : a) //For each loop used
        {
            System.out.println(item);

        }

        //From edu.princeton.cs.algs4
        double largest_ele = StdStats.max(a);
        System.out.println("Largest element is :"+ largest_ele);

        System.out.println("Enter the key to be searched!");
        int key = input.nextInt();

        int result= rank(key,a);

       boolean pr = basicPrimality.isPrime(2);   // Can be called by giving only class name and not obj name as it's a static function
        System.out.println("Prime number" + pr);

        if(result==-1) System.out.println("\n The given key "+key+" is not found in the array!");
        else System.out.println("The key is found at position : "+ (result+1));
    }
}
