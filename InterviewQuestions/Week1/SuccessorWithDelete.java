import java.util.Scanner;

public class SuccessorWithDelete {
    private int[] id;
    private int[] sz;
    private int[] actualList;

    public SuccessorWithDelete(int N)
    {
        id = new int[N];
        sz = new int[N];
        actualList= new int[N];


        for (int i = 0; i < id.length; ++i)
        {
            id[i] = i;
            sz[i]=1;
            actualList[i]=i;
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
    public int successor(int p)
    {
        return actualList[root(p+1)];
    }
    public boolean isConnected(int p, int q)
    {
        return (root(p)==root(q));    //Find
    }

    public void union(int p, int q)
    {
        int rootp= root(p);
        int rootq= root(q);

        if(sz[rootp]<=sz[rootq])
        {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        }
        else
        {
            id[rootq]= rootp;
            sz[rootp]+=sz[rootq];
            actualList[rootp]=rootq; //So that it points to the actual successor
        }
    }


    //Implement try-catch block to catch outofbounds exception
    public static void main(String ... args)
    {
        System.out.println("Enter the number of array elements\n");
        Scanner in = new Scanner(System.in);

        int N= in.nextInt();

        SuccessorWithDelete uf = new SuccessorWithDelete(N);

        for(;;)
        {
            System.out.println("1: delete, 2:exit");
            int choice = in.nextInt();

            switch (choice)
            {
                case 1: System.out.println("\n Enter number to delete");
                        int p = in.nextInt();
                        int q = p+1;
                        if(!uf.isConnected(p,q)) uf.union(p,q);
                        else System.out.println("Already connected!");
                        System.out.println("Successor is:"+uf.successor(p));

                        break;




                case 2: System.exit(0);

            }
        }
    }

}
