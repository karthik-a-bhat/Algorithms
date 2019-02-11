import java.util.Scanner;

public class basicPrimality {
    public static boolean isPrime(long number)
    {
        if(number<2) return false;

        if(number==2 ) return true;

        for (int i=2;i<(number/2);++i)
        {
            if(number%i==0) return false;
        }
        return true;
    }
    public static void main(String []args)
    {
        System.out.println("\n Enter the number to be tested!");
        Scanner in = new Scanner(System.in);

        long number = in.nextLong();

        boolean result=basicPrimality.isPrime(number);


        if (result==false) System.out.println("The given number is not prime");
        else System.out.println("The given number is prime!");
    }
}
