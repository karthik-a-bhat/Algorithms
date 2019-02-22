//Interview Question 2
//Program to find maximum value of number in connected set!
//Separate array used

import java.util.Scanner;

public class MaxValToFind {
    private int[] id;
    private int[] sz;
    private int[] maxval;

    public MaxValToFind(int N)
    {
        id = new int[N];
        sz = new int[N];
        maxval= new int[N];


        for (int i = 0; i < id.length; ++i)
        {
            maxval[i]=i;
            id[i] = i;
            sz[i]=1;
        }

    }

    private int root(int p)
    {
//        if(id[p]==p) return p;
//        else return(root(id[p]));


        while(p!=id[p])
        {
            id[p]=id[id[p]];   //Code for path compression single pass. Path length is halved! Node points to its grandparents
            p=id[p];

        }
        return p;
    }

    public boolean isConnected(int p, int q)
    {
        return (root(p)==root(q));    //Find
    }

    public void union(int p, int q)
    {
        int rootp= root(p);
        int rootq= root(q);

        //To find max value
        int maxvalue;

        maxvalue=(maxval[rootp]>maxval[rootq])? maxval[rootp]:maxval[rootq];

        if(sz[rootp]<sz[rootq])
        {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
            maxval[rootq]=maxvalue;
        }
        else
        {
            id[rootq]= rootp;
            sz[rootp]+=sz[rootq];
            maxval[rootp]=maxvalue;
        }
    }
    public  int findMaxVal(int p)
    {
        return maxval[root(p)];
    }


    //Implement try-catch block to catch outofbounds exception
    public static void main(String ... args) throws IllegalArgumentException
    {
        System.out.println("Enter the number of array elements\n");
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        if (N <= 1) throw new IllegalArgumentException("Please enter array size greater than 1!");


        MaxValToFind uf = new MaxValToFind(N);

        for(;;)
        {
            System.out.println("1: union, 2:find,3: exit 4: Maxval");
            int choice = in.nextInt();

            switch (choice)
            {
                case 1: System.out.println("\n Enter numbers for union");
                         int p = in.nextInt();
                         int q = in.nextInt();
                         if(!uf.isConnected(p,q)) uf.union(p,q);
                         else System.out.println("Already connected!");
                         break;

                case 2: System.out.println("\n Enter numbers to find");
                        int a = in.nextInt();
                        int b = in.nextInt();
                        System.out.println(uf.isConnected(a,b));
                        break;

                case 4: System.out.println("\n Enter element to find maxval of the connected set");
                        int maxvalToFind=in.nextInt();
                        System.out.println("\n Max value in connected set is:"+ uf.findMaxVal(maxvalToFind));
                        break;

                case 3: System.exit(0);

            }
        }
    }
}
