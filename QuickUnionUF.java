//Quick union method for Union find algorithm. Lazy approach


import java.util.Scanner;

public class QuickUnionUF {

    private int [] id;
    public QuickUnionUF(int N)
    {
        id= new int[N];
        for(int i=0; i<id.length;++i)
        {
            id[i]=i;
        }
    }

    private int root(int p)
    {
        if(id[p]==p) return p;
        else return(root(id[p]));
    }

    public boolean isConnected(int p, int q)
    {
        return (root(p)==root(q));
    }

    public void union(int p, int q){
        int proot= root(p);
        int qroot= root(q);

        id[proot]= qroot; //We will link root of 'p' to root of 'q'
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the number of array elements\n");
        Scanner in = new Scanner(System.in);

        int N= in.nextInt();

        QuickUnionUF uf = new QuickUnionUF(N);

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
