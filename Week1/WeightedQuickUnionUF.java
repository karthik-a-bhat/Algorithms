//Weighted  quick union. Max depth of node of tree is log2(N). Total elements is N
//Weighted  quick union with path compression. Amortized complexity is -->  [N(initialize array) + M*log*N] for N obj and M UF operations.
import java.util.Scanner;

public class WeightedQuickUnionUF {
    private int id[];
    private int sz[];

    public WeightedQuickUnionUF(int N)
    {
        id = new int[N];
        sz = new int[N];


        for (int i = 0; i < id.length; ++i)
        {
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

        if(sz[rootp]<sz[rootq])
        {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        }
        else
        {
            id[rootq]= rootp;
            sz[rootp]+=sz[rootq];
        }
    }


    //Implement try-catch block to catch outofbounds exception
    public static void main(String ... args)
    {
        System.out.println("Enter the number of array elements\n");
        Scanner in = new Scanner(System.in);

        int N= in.nextInt();

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

        for(;;)
        {
            System.out.println("1: union, 2:find,3: exit");
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

                case 3: System.exit(0);

            }
        }
    }

}

