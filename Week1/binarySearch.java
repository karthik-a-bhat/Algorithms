import java.util.Scanner;

public class binarySearch {
    public static int rank(int key, int []a)
    {
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(key>a[mid]) lo=mid+1;
            else if (key<a[mid]) hi=mid-1;
            else return mid;
        }
        return -1;
    }
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the key to be searched");
        int key = in.nextInt();
        System.out.println("\nEnter the number of elements in the array");
        int num = in.nextInt();
        int []array = new int[num];

        for(int i=0; i<num; ++i)
        {
            System.out.println("\n Enter the element of the array!");
            array[i]= in.nextInt();
        }
//        for(int counter : array )
//        {
//            System.out.println("Enter the element of the array!");
//            array[counter] = in.nextInt();
//        }
        int result=binarySearch.rank(key,array);
        if (result==-1)
        {
            System.out.println("\n The given key is not found!\n");
        }
        else
        {
            System.out.println("\n The given key is found at position : " + (result+1));
        }
    }
}
