public class gcd_euclid {
    public static long gcd(long p, long q)
    {
        if(q==0) return p;
        long r = p%q;
        return(gcd(q,r));

    }
    public static  void main(String []args)
    {
        long result;
        result= gcd(987875568888888888L,11L);
        System.out.println("The value of GCD is:"+result);

    }
}
