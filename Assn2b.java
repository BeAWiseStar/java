import java.util.Scanner;

// class Queue
class Queue{
	private Email [] eArray;
	private int front = -1;
	private int rear = -1;
	private int size;
	public Queue(int size) {
		this.size = size;
		eArray = new Email[size];
	}
	public void enqueue(Email m) {
		if(isfull()) {
			System.out.println("Queue is full");
		}
		else {
			if(rear == size - 1) {
				rear = -1;
			}
			eArray[++rear] = m;
		}
	}
	public Email dequeue() {
		if(isempty()) {
			System.out.println("Queue is empty");
		}
		else {	
			Email temp = eArray[++front];
			eArray[front].addAttempt();
			eArray[front] = null;
			if(front == size - 1)
				front = -1;	
			return temp;
		}	
		return null;
	}
	public boolean isfull() {
		return ((rear+1) % size == front) ? true : false;
	}
	public boolean isempty() {
		return front == rear ? true : false;
	}
	public int size() {
		if(isfull()) {
			return size;
		}
		else {
			return (rear - front) > 0 ? (rear - front) : (size - front + rear + 1);
		}
	}
}

//class Email
class Email{
	private int id;
	private int attempt;
	public Email(int a) {
		id = a;
		attempt = 0;
	}
	public void addAttempt() {
		attempt++;
	}
	public int getAttempt() {
		return attempt;
	}
}

public class Assn2b {
	public static void main(String[]args){	
		int totalMsg = 0;
		int totalMsgInQ = 0;
		int totalSent = 0;
		int [] attemptArray = new int[10];
		int current = 0;
		double totalTime = 0;
		Queue Q1 = new Queue(2000);

		System.out.print("Please enter the total minutes to run: ");
		Scanner input = new Scanner(System.in);
		totalTime = input.nextInt();
		for(int i = 0; i < totalTime; i++) {
			// enqueue average 30 times
			int random = (int)(Math.random() * 61);
			totalMsg = totalMsg + random;
			current += random;
			totalMsgInQ = totalMsgInQ + current;
			for(int j = 0; j < random; j++) {
				Email m = new Email(j);
				Q1.enqueue(m);
			}
			
			// dequeue up to 30 times
			int random1 = (int)(Math.random()*31);
			for(int k = 0; k < random1 && !Q1.isempty(); k++) {
				int random2 = (int)(Math.random()*101);
				if(random2 <= 24) {
					Q1.enqueue(Q1.dequeue());
				}
				else {
					attemptArray[Q1.dequeue().getAttempt()-1]++;
					totalSent++;
				}
			}
		}
		// compute average number of times messages had to be required
		int sum = 0;
		int number = 0;
		for(int j = 0; j < attemptArray.length; j++) {
			sum = sum + attemptArray[j]*(j+1);
			number = number + attemptArray[j];
		}
		System.out.println();
		System.out.println("======================== Summary Statistics ========================");
		System.out.printf("%n1. Total number of messages processed %18s %d","  :", totalMsg);
		System.out.printf("%n2. Average arrival rate %32s %.2f", "  :", totalMsg/totalTime);
		System.out.printf("%n3. Average number of messages sent per minute %10s %.2f", "  :", (totalMsg-totalSent)/totalTime);
		System.out.printf("%n4. Average number of messages in the queue per minute %2s %.2f%n", ":", totalMsgInQ/totalTime);
		System.out.println();
		for(int i = 0; i < 4; i++) {
			System.out.println("5." + (i+1) + ".  Number of messages sent on " + (i+1) + "st attempt  : " + attemptArray[i]);
		}
		System.out.println();
		System.out.printf("6. Average number of times messages had to be requeued %s %.02f", ":", (double)sum/number);
	}
}
