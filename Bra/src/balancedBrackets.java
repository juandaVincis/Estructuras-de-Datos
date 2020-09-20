
import java.util.Scanner;

import javax.management.RuntimeErrorException;

class StackArrayGeneric <T>{

	private int N = 5;
	private int top ;
	private T[] sarray;
	
	
	public StackArrayGeneric(T[] sarray) {
		super();
		this.sarray = sarray;
		this.top = sarray.length;
	}
	
	public StackArrayGeneric(int n) {

		this.top = 0;
		this.sarray = (T[]) new Object[n];
	}
	
	public StackArrayGeneric(String str) {
		this.sarray = (T[])new Object[str.length()];
		top = sarray.length;
	}

	public boolean empty() {
		return top<=0;
	}
	
	public boolean full() {
		return top >= sarray.length;
	}
	
	public T pop() {
		if(empty()) 
			throw new RuntimeErrorException(null, "Stack is empty");
		top--;
		return sarray[top];
	}
	
	public void push(T item) {
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

	public T[] getSarray() {
		return sarray;
	}

	public void setSarray(T[] sarray) {
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

class QueueArray<T> {
	private int tail=0, head = 0, count = 0, size=0;
	private T[] qarray;
	
	public QueueArray(int n) {

		this.head = 0;
		this.tail = 0;
		this.count = 0;
		this.size=n;
		this.qarray = (T[]) new Object[size];
	}
	
	public QueueArray() {
		head = tail = count = 0;
		qarray = (T[]) new Object[5];
	}
	
	public T[] array() {
		return qarray;
	}
	
	
	public boolean exist(T item) {
		for(int i=head;i!=tail;i=(i+1)%size) {
			if(qarray[(head+i)%size] == item) {
				return true;
			}
		}
		return false;
	}
	
	public T dequeue() {
		T item = null;
		if(empty())
			System.out.println("Queue is empty: item not dequeued");
		else {
			item = qarray[head];
			head = (head + 1) % size;
			count--; 
		} 
		return item;
	}
	
	public T pop() {
		T item = null;
		if(empty())
			System.out.println("Queue is empty: item not dequeued");
		else {
			item = qarray[(((tail-1) % size) + size) % size];
			tail = ((((tail-1) % size) + size) % size);
			count--; 
		} 
		return item;
	}
	
	public T peekPop() {
		T item = null;
		if(empty())
			System.out.println("Queue is empty: item not dequeued");
		else {
			item = qarray[(((tail-1) % size) + size) % size];
		}
		return item;
	}
	
	public T peek() {
		T item = null;
		if(empty())
			System.out.println("Queue is empty: item not dequeued");
		else {
			item = qarray[head];
		}
		return item;
	}
	
	public void enqueue(T item) {
		if(full())
			System.out.println("Queue is full: item not enqueued");
		else {
			qarray[tail] = item;
			tail = (tail + 1) % size;
			count++;
		} 
	} 
	public boolean empty() {
		return count <= 0;
	} 
	public boolean full() {
		return count >= size;
	} 
	public int getCount() {
		return count;
	} 
	
	public void clone(QueueArray<T> E) {
		this.head = E.head;
		this.tail = E.tail;
		this.size = E.size;
		this.count = E.count;
		for(int i = 0;i<E.qarray.length;i++) {
			this.qarray[i] = E.qarray[i];
		}
	}
	
	public void clear(int n) {
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		this.size=n;
		this.qarray = (T[]) new Object[size];
	}
	
	public void eliminate(T item) {
		int siz = this.count;
		for(int i = 0;i<siz;i++) {
			if((char)this.peek() == (char)item)
				this.dequeue();
			else
				this.enqueue(this.dequeue());
		}
	}
	
	/**public String toString() {
		String s = "";
		int siz = this.count;
		for(int i =0;i<siz;i++) {
			T t = this.dequeue();
			s+=t;
			this.enqueue(t);
		}
		
		/**for(int i=head;i!=tail;i=(i+1)%size) {
			s+=this.qarray[(head+i)%size];
		}
		//System.out.println(s);
		return s;
	}**/
	
	
}

public class balancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int nCasos = Integer.parseInt(sc.nextLine());
		String brackets = "";
		QueueArray<Boolean> qAnswer = new QueueArray<>(100);
		
		
		for(int i=0;i<nCasos;i++) {
			brackets= sc.nextLine();
			char cas = ' ';
			boolean caso = true;
			StackArrayGeneric<Character> stack = new StackArrayGeneric<>(brackets.length());
			
			for(int j=0;j<brackets.length();j++) {
				
				cas = brackets.charAt(j);
				switch(cas){
					case '{':
						stack.push(new Character(cas));
						break;
					case '[':
						stack.push(new Character(cas));
						break;
					case '(':
						stack.push(new Character(cas));
						break;
					case '}':
						try {
							Character c = new Character(stack.pop());
							if('{'!=c) {
								caso=false;
							}
						}
						catch (Exception e) {
							caso=false;
						}
						break;
						
					case ']':
						try {
							Character c = new Character(stack.pop());
							if('['!=c) {
								caso=false;
							}
						}
						catch (Exception e) {
							caso=false;
						}
						break;
						
					case ')':
						try {
							Character c = new Character(stack.pop());
							if('('!=c) {
								caso=false;
							}
						}
						catch (Exception e) {
							caso=false;
						}
						break;
						
					
				}
				
			}
			
			if(stack.empty() && caso==true) {
				qAnswer.enqueue(true);
			}else
				qAnswer.enqueue(false);
			
		}
		
		while(!qAnswer.empty()) {
			if(qAnswer.dequeue()) {
				System.out.println("YES");
			}else
				System.out.println("NO");
		}

	}

}