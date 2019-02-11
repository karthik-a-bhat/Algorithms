//Percolation class for Assignment 1 of Algorithms-Part 1 by Princeton University (Coursera)
//Created By: Karthik A Bhat
//Created: Jan 30th 2019
//Modified: Jan 31st 2019
//Modified: Feb 1st 2019 - Passed - 82/100
//Important condition- Check for gridSize of 1


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[] open;
    private WeightedQuickUnionUF uf = null;
    private final int sizeOfOneRow,gridTotal;
    private final int virtualTopSite,virtualBottomSite;

    //i/p - Size of one row - n
    public Percolation(int n){
        if (n <= 0) throw new java.lang.IllegalArgumentException("Grid size should be above 0!!");

        sizeOfOneRow=n;
        gridTotal=n*n;
        open = new int[(gridTotal)+2];
        virtualTopSite=0;
        virtualBottomSite=((gridTotal)+1);
        initialize();

        for(int i=1;i<=sizeOfOneRow;++i)
        {
            uf.union(0,xyTo1D(1,i));
            uf.union(gridTotal+1,xyTo1D(sizeOfOneRow,i));
        }

    }

    private void initialize() {
        uf = new WeightedQuickUnionUF((gridTotal+2));


        //Both virtual sites are open!
        open[virtualBottomSite]=1;
        open[virtualTopSite]=1;
    }

    private void checkIndex(int row, int col)
    {
        if(row<1 || row>sizeOfOneRow) throw new IllegalArgumentException("Row index out of bounds!");
        if(col<1 || col>sizeOfOneRow) throw new IllegalArgumentException("Column index out of bounds!");
    }
    //Modified
    private int xyTo1D(int row, int col) {

        checkIndex(row,col);
        int val1D = (sizeOfOneRow * (row - 1)) + col;
        return val1D;

    }

    public int numberOfOpenSites() {
        int val = 0;
        for (int i = 1; i <=gridTotal; ++i) {
            if (open[i] == 1) val += 1;
        }
        return val;

    }

    //Check is connection between virtual bottom and top site. If gridSize is 1, check if (1,1) is open
    public boolean percolates() {
        if(sizeOfOneRow>1) return uf.connected(virtualTopSite, virtualBottomSite);

        //If grid size is 1, and if the only node is open, then it obviously percolates!
        else
        {
            if(open[xyTo1D(1,1)]==1) return true;
            else return false;

        }
    }

    //Modified- correct
    public boolean isOpen(int row, int col) {
        int site = xyTo1D(row, col);
        return (open[site] == 1);
    }


    public void open(int row, int col) {
        int site = xyTo1D(row, col);

        //If site isn't open, open it, and union with neighbours if they are open
        if (open[site] != 1)
        {
            open[site] = 1;

            if (sizeOfOneRow == 1) return;
            //Site to left
            if (col > 1 && open[xyTo1D(row, col - 1)] == 1) {
                uf.union(site, xyTo1D(row, col - 1));
            }

            //Site to right
            if (col < sizeOfOneRow && open[xyTo1D(row, col + 1)] == 1) {
                uf.union(site, xyTo1D(row, col + 1));
            }

            //Site to top
            if (row > 1 && open[xyTo1D(row - 1, col)] == 1) {
                uf.union(site, xyTo1D(row - 1, col));
            }

            //Site to bottom
            if (row < sizeOfOneRow && open[xyTo1D(row + 1, col)]==1) {
                uf.union(site, xyTo1D(row + 1, col));
            }
        }
    }


    //Check if site is open and it is connected to the top.
    public boolean isFull(int row, int col) {
        int site = xyTo1D(row, col);
        return (uf.connected(virtualTopSite, site)&& open[site]==1); //So that (1,1) will not show full
    }

//    public static void main(String[] args) {
//        System.out.println("Enter the number of grid elements N (N*N)\n");
//        Scanner in = new Scanner(System.in);
//
//        int N = in.nextInt();
//
//        Percolation p = new Percolation(N);
////
////        for(;;) {
////
////            int openrandom = StdRandom.uniform(1, N * N);
////
////            int row = (openrandom / N) + 1;
////            int col = openrandom % N;
////
////            if (!(p.isOpen(row, col))) p.open(row, col);
////            else continue;
////
////            if (p.percolates()) {
////                double prob = (double) (p.numberOfOpenSites()) / (N * N);
////
////                System.out.println("Probability is :" + prob);
////                System.out.println("\n Number of open sites are: " + p.numberOfOpenSites());
////                System.exit(0);
////            }
//        }
//
//        for (; ; ) {
//            System.out.println("1: open, 2:full,3: percolates 4: Exit");
//            int choice = in.nextInt();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("\n Enter row and column numbers for opening");
//                    int a = in.nextInt();
//                    int b = in.nextInt();
//                    if (!(p.isOpen(a, b))) p.open(a, b);
//                    else System.out.println("Already opened!");
//                    break;
//
//                case 2:
//                    System.out.println("\n Enter row and column numbers for checking if full");
//                    int x = in.nextInt();
//                    int y = in.nextInt();
//                    System.out.println(p.isFull(x, y));
//                    break;
//
//                case 3:
//                    System.out.println(p.percolates()); break;
//
//                case 4:
//                    System.exit(0);
//
//            }
////
//////
//        }
//    }

}

