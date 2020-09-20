package PilasyColas;

import java.util.EmptyStackException;
import java.util.Scanner;

class ChainNode <T>{
    T element;
    ChainNode<T> next;

    ChainNode()
    {
        this(null, null);
    }

    ChainNode(T element)
    {
        this(element, null);
    }

    ChainNode(T element, ChainNode<T> next)
    {
        this.element = element;
        this.next = next;
    }
}


class LinkedStack<T> implements Stack<T> {
    protected ChainNode<T> topNode;
    public LinkedStack(){
        topNode = null;
    }
    public boolean isEmpty(){
        return topNode == null;
    }
    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return topNode.element;
    }
    public void push( T theElement){
        topNode = new ChainNode<T>(theElement, topNode);
    }
    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        T topElement = topNode.element;
        topNode = topNode.next;
        return topElement;
    }
    public static void main(String[] args){
        LinkedStack<Integer> s = new LinkedStack<>();
        s.push(new Integer(1));
        s.push(new Integer(2));
        s.push(new Integer(3));
        s.push(new Integer(4));
        while (!s.isEmpty()){
            System.out.println("Top element is " + s.peek());
            System.out.println("Removed element is " + s.pop());
        }
    }
}


public class ParenthesisMatching {
    public static void printMatchedPairs(String expr){
        LinkedStack<Integer> s = new LinkedStack<>();
        for(int i = 0; i<expr.length(); i++)
            if(expr.charAt(i) == '(')
                s.push(i);
        else if (expr.charAt(i) == ')')
            try{
                System.out.print(s.pop() + "  " + i + " ");
            }
            catch (Exception e){
                System.out.println("No match for right parenthesis at " + i);
            }
        while(!s.isEmpty())
            System.out.println("No match for left parenthesis at " + s.pop());
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Type an expression with no spaces");
            String expression = s.nextLine();

            System.out.println("the pairs of matching parentheses in");
            System.out.println(expression);
            System.out.println("are ( indexing begins at 0 )");
            printMatchedPairs(expression);
        }
    }
}
