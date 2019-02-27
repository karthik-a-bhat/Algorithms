//Stack of Strings implemented using Linked Lists
//Takes constant time
//Takes space of ~40N bytes. Where N is the
//Push and pop at the beginning of the linked list
public class LinkedStackOfStrings {

    private Node first=null;
    private Node last=null;
    private int size;

    private class Node{
        String item;
        Node next;
    }

    public void push(String item){
        Node oldFirst=first;
        first=new Node();
        if(oldFirst==null) last=first;
        //if(size==0) last=first;
        first.item=item;
        first.next=oldFirst;
        size++;
    }

    public String pop(){
        String item=first.item;
        first=first.next;
        size--;
        return item;
    }

    public boolean isEmpty(){
        return (first==null);
    }
    public int stackSize(){
        return size;
    }
}
