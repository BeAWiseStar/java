
// !!!! Runtime complexity explanation is at line 223 to 246 !!!!

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Assn3 {
	private static class Edge implements Comparable <Edge>{
		int vertex, weight;

		public Edge(int n, int w){
			vertex = n;
			weight = w;
		}
		@Override
		public int compareTo(Edge e){
			return Integer.compare(this.weight, e.weight);
		}
		@Override
		public String toString(){
			return String.format("%d: %d", vertex, weight);
		}
	}

	private static String [] name = {"Ang Mo Kio", "Bedok", "Bukit Batok", "Bukit Panjang", "Bukit Timah", "Clementi", "Changi", 
									"Choa Chu Kang", "Jurong", "Mandai", "Marina Bay", "Nee Soon", "Outram", "Pasir Panjang", 
									"Punggol", "Queenstwon", "Sembawang", "Sentosa", "Serangoon", "Tampines", "Toa Payoh",
									"Tuas", "Upper Thomson", "Woodlands"};
	private static Scanner input = new Scanner(System.in);
	private static List <String> listName = Arrays.asList(name);
	private static ArrayList <Edge> [] Graph = new ArrayList[24];
	private static String start, end;
	private static int number = name.length;
	
	private static void constructAList() {
		for (int i = 0; i < number; i++) {
			Graph[i] = new ArrayList<Edge>();
        }
		Graph[0].add(new Edge(2,18));
		Graph[0].add(new Edge(3,16));
		Graph[0].add(new Edge(11,6));
		Graph[0].add(new Edge(18,6));
		Graph[0].add(new Edge(22,5));
		Graph[1].add(new Edge(4,22));
		Graph[1].add(new Edge(10,16));
		Graph[1].add(new Edge(12,16));
		Graph[1].add(new Edge(19,5));
		Graph[1].add(new Edge(20,13));
		Graph[1].add(new Edge(22,16));
		Graph[2].add(new Edge(0,18));
		Graph[2].add(new Edge(3,7));
		Graph[2].add(new Edge(4,5));
		Graph[2].add(new Edge(5,7));
		Graph[2].add(new Edge(7,6));
		Graph[2].add(new Edge(8,19));
		Graph[2].add(new Edge(21,16));
		Graph[3].add(new Edge(0,16));
		Graph[3].add(new Edge(2,7));
		Graph[3].add(new Edge(4,6));
		Graph[3].add(new Edge(7,4));
		Graph[3].add(new Edge(9,15));
		Graph[3].add(new Edge(11,16));
		Graph[3].add(new Edge(22,14));
		Graph[3].add(new Edge(23,11));
		Graph[4].add(new Edge(1,22));
		Graph[4].add(new Edge(2,5));
		Graph[4].add(new Edge(3,6));
		Graph[4].add(new Edge(5,5));
		Graph[4].add(new Edge(8,25));
		Graph[4].add(new Edge(15,9));
		Graph[4].add(new Edge(20,10));
		Graph[4].add(new Edge(22,11));
		Graph[5].add(new Edge(2,7));
		Graph[5].add(new Edge(4,5));
		Graph[5].add(new Edge(13,7));
		Graph[5].add(new Edge(15,5));
		Graph[6].add(new Edge(18,16));
		Graph[6].add(new Edge(19,5));
		Graph[6].add(new Edge(20,18));
		Graph[7].add(new Edge(2,6));
		Graph[7].add(new Edge(3,4));
		Graph[7].add(new Edge(8,22));
		Graph[7].add(new Edge(21,15));
		Graph[7].add(new Edge(23,11));
		Graph[8].add(new Edge(2,19));
		Graph[8].add(new Edge(4,25));
		Graph[8].add(new Edge(7,22));
		Graph[8].add(new Edge(2,6));
		Graph[8].add(new Edge(3,4));
		Graph[8].add(new Edge(21,19));
		Graph[9].add(new Edge(3,15));
		Graph[9].add(new Edge(11,3));
		Graph[9].add(new Edge(16,6));
		Graph[9].add(new Edge(21,19));
		Graph[10].add(new Edge(1,16));
		Graph[10].add(new Edge(12,2));
		Graph[10].add(new Edge(20,10));
		Graph[11].add(new Edge(0,6));
		Graph[11].add(new Edge(3,16));
		Graph[11].add(new Edge(9,3));
		Graph[11].add(new Edge(16,5));
		Graph[11].add(new Edge(23,9));
		Graph[12].add(new Edge(1,16));
		Graph[12].add(new Edge(10,2));
		Graph[12].add(new Edge(15,5));
		Graph[12].add(new Edge(17,6));
		Graph[12].add(new Edge(20,8));
		Graph[13].add(new Edge(5,7));
		Graph[13].add(new Edge(15,6));
		Graph[13].add(new Edge(17,8));
		Graph[14].add(new Edge(18,8));
		Graph[15].add(new Edge(4,9));
		Graph[15].add(new Edge(5,5));
		Graph[15].add(new Edge(12,5));
		Graph[15].add(new Edge(13,6));
		Graph[15].add(new Edge(17,10));
		Graph[15].add(new Edge(20,9));
		Graph[15].add(new Edge(22,10));
		Graph[16].add(new Edge(9,6));
		Graph[16].add(new Edge(11,5));
		Graph[16].add(new Edge(23,5));
		Graph[17].add(new Edge(12,6));
		Graph[17].add(new Edge(13,8));
		Graph[17].add(new Edge(15,10));
		Graph[18].add(new Edge(0,6));
		Graph[18].add(new Edge(6,16));
		Graph[18].add(new Edge(14,8));
		Graph[18].add(new Edge(19,12));
		Graph[18].add(new Edge(20,6));
		Graph[18].add(new Edge(22,8));
		Graph[19].add(new Edge(1,5));
		Graph[19].add(new Edge(6,5));
		Graph[19].add(new Edge(18,12));
		Graph[19].add(new Edge(20,15));
		Graph[20].add(new Edge(1,13));
		Graph[20].add(new Edge(4,10));
		Graph[20].add(new Edge(6,18));
		Graph[20].add(new Edge(10,10));
		Graph[20].add(new Edge(12,8));
		Graph[20].add(new Edge(15,9));
		Graph[20].add(new Edge(18,6));
		Graph[20].add(new Edge(19,15));
		Graph[20].add(new Edge(22,6));
		Graph[21].add(new Edge(2,16));
		Graph[21].add(new Edge(7,15));
		Graph[21].add(new Edge(8,19));
		Graph[22].add(new Edge(0,5));
		Graph[22].add(new Edge(1,16));
		Graph[22].add(new Edge(3,14));
		Graph[22].add(new Edge(4,11));
		Graph[22].add(new Edge(15,10));
		Graph[22].add(new Edge(18,8));
		Graph[22].add(new Edge(20,6));
		Graph[23].add(new Edge(3,11));
		Graph[23].add(new Edge(7,11));
		Graph[23].add(new Edge(9,8));
		Graph[23].add(new Edge(11,9));
		Graph[23].add(new Edge(16,5));
	}
	private static String validation() throws IOException{
		String userInput = input.nextLine();
		if(!listName.contains(userInput)) {
			throw new IOException();
		}
		return userInput;
	}
	private static int[] reverse(int[] path, int a){
		int [] arrayR = new int[number];
		while(a != listName.indexOf(start)){
			arrayR[path[a]] = a;
			a = path[a];
		}
		return arrayR;
	}
	private static void print(int[] path, int b){		
		if(b == listName.indexOf(start))
			System.out.print("Path : " + start);
		if(path[b] == listName.indexOf(end)) {
			System.out.print(" => " + end);
			return;
		}
		System.out.print(" => " + name[path[b]]);
		print(path, path[b]);
	}
	private static void implement(){
		boolean ok = false;
		  while(!ok){ 
			 try { 
				  System.out.print("Start from : "); 
				  start = validation();
				  System.out.print("To : "); 
				  end = validation();
				  ok = true;
			  } 
			  catch(IOException e) { 
				  System.out.println("Please Enter Again!");
				  System.out.println();
			  }
			  catch(ArrayIndexOutOfBoundsException e) {
			  } 
		  }
		constructAList();

		PriorityQueue <Edge> priorityQ = new PriorityQueue<>();
		boolean [] visited = new boolean[number];
		Edge[] distance = new Edge[number];
		int intBegin = listName.indexOf(start);
		int intEnd = listName.indexOf(end);
		int[] path = new int[number];
		
		for(int i = 0; i < number; i++) {
			if (i == intBegin) {
				distance[i] = new Edge(i, 0);
			} else {
				distance[i] = new Edge(i, Integer.MAX_VALUE);
			}
			priorityQ.add(distance[i]);
			// the iteration time is same as 'number'
			// 'number' is length of Vertax which is V.
			// adding to priority queue is O(n)
		}
		
		while(!priorityQ.isEmpty()) {
			Edge edge = priorityQ.poll();
			for (Edge e : Graph[edge.vertex]) {
				if (!visited[e.vertex] && distance[e.vertex].weight > distance[edge.vertex].weight + e.weight) {
					distance[e.vertex].weight = distance[edge.vertex].weight + e.weight;
					path[e.vertex] = edge.vertex;
					priorityQ.remove(distance[e.vertex]);
					priorityQ.add(distance[e.vertex]);
				}
				// this iteration is same as number of edges
				// let this iteration is E
			}
			visited[edge.vertex] = true;
		}
		// this while loop cannot be bigger than the number of vertexes
		// so runtime complexity is O(ElgE)
		// if we do not count duplication then
		// runtime complexity of this algorithm is
		// => O(ElgV)
		
		print(reverse(path, intEnd), intBegin);
		System.out.printf("%nTotal distance : %dKM", distance[intEnd].weight);
	}
	
	public static void main(String [] args) {
		implement();
		input.close();
	}
}