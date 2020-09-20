package PilasyColas;
import javax.management.RuntimeErrorException;

/**
 * 
 */

/**
 * @author judcastanoro
 *
 */
public class StackArray {

	private int N = 5;
	private int top , sarray[];
	
	
	public StackArray(int[] sarray) {
		super();
		this.sarray = sarray;
		this.top = sarray.length;
	}
	
	public StackArray(int n) {

		this.top = 0;
		this.sarray = new int[n];
	}
	
	public boolean empty() {
		return top<=0;
	}
	
	public boolean full() {
		return top >= sarray.length;
	}
	
	public int pop() {
		if(empty()) 
			throw new RuntimeErrorException(null, "Stack is empty");
		top--;
		return sarray[top];
	}
	
	public void push(int item) {
		if (full())
			throw new RuntimeErrorException(null, "Stack is empty");
		sarray[top] = item;
		top++;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int[] getSarray() {
		return sarray;
	}

	public void setSarray(int[] sarray) {
		this.sarray = sarray;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i<=top;i++) {
			s += String.valueOf(sarray[i]);
			s += " "; 
		}
		return s;
	}
	
}
