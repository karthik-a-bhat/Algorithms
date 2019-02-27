//Client method to test the Linked List Stack of String implementation
//Take input from file
//If file contains '-', it is an indication of pop. Else the given word is pushed

import edu.princeton.cs.algs4.StdIn;

public class LinkedStackOfStringsClient {
    public static void main(String[] agrs){
        LinkedStackOfStrings stack1= new LinkedStackOfStrings();
        while (!StdIn.isEmpty()){
            String s= StdIn.readString();
            if(s.equals("-")) System.out.println(stack1.pop());
            else stack1.push(s);
        }
    }
}
