//Implementation of Stack Of Strings using fixed size arrays!

public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N; //Stack pointer points to 0
    //private int capacity;

    public FixedCapacityStackOfStrings(int capacity){
        s=new String[capacity];
        //this.capacity=capacity;
    }
    public void push(String item){
        if(N==s.length) throw new StackOverflowError("Overflow!");
        s[N++]=item;
    }
    public String pop(){
        if(N==0) throw new ArrayIndexOutOfBoundsException("Stack Underflow!");
        String item=s[--N];
        s[N]=null;       // To prevent loitering. The item s[N] is now eligible for Garbage Collection!
        return item;
    }
    public boolean isEmpty(){
        return N==0;
    }

}
