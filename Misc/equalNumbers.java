public class equalNumbers {
    public static void main(String []args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if(a==b && a==c) System.out.println("Equal");
        else System.out.println("Not equal");

        if (a < b) c = 0; else b = 0;
        System.out.println(c+""+b);


    }
}
