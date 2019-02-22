//Quick find method for Union find algorithm. Eager approach
//Implementation - array-access worst case for N elements is quadratic (N^2). Very bad implementation.
//Union operation is very expensive



import java.util.Scanner;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N)
    {
        id= new int[N];
        for(int i=0; i<id.length;++i)
        {
            id[i]=i;
        }
    }
    public boolean isConnected(int p, int q)
    {
        return (id[p]==id[q]);
    }

    public void union(int p, int q)
    {
        int pval=id[p];
        int qval=id[q];

        for(int i=0; i<id.length;++i)
        {
            if(id[i]==pval) id[i]=qval;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the number of array elements\n");
        Scanner in = new Scanner(System.in);

        int N= in.nextInt();

        QuickFindUF uf = new QuickFindUF(N);

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
