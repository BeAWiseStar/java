package ghLim;

class Dijkstra {
	private int n; 
	private int[][] weight; 
	private String[] saveRoute;
	private String[] vertex = {"Ang Mo Kio", "Bedok", "Bukit Batok", "Bukit Panjang", "Bukit Timah", "Clementi", "Changi", 
								"Choa Chu Kang", "Jurong", "Mandai", "Marina Bay", "Nee Soon", "Outram", "Pasir Panjang", 
								"Punggol", "Queenstown", "Sembawang", "Sentosa", "Serangoon", "Tampines", "Toa Payoh",
								"Tuas", "Upper Thomson", "Woodlands"};
	
	public Dijkstra(int n) {
		super();
		this.n = n; 
		weight = new int[n+1][n+1]; 
		saveRoute = new String[n];
	}
	
	public int stringToInt(String s) {
		int x = 0;
		for(int i=0; i<vertex.length; i++) {
			if(vertex[i]==s) 
				x=i;
		}
		return x;
	}
	
	public void input(String v1, String v2, int w) {
		int x1 = stringToInt(v1);
		int x2 = stringToInt(v2);
		
		weight[x1][x2] = w;
		weight[x2][x1] = w;
	}
	
	public void algorithm(String a) {
		boolean[] visited = new boolean[n+1]; 
		int distance[] = new int[n+1]; 
		
		for(int i=0; i<n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		int x = stringToInt(a); 
		distance[x] = 0; 
		visited[x] = true; 
		saveRoute[x] = vertex[x]; 
		
		for(int i=0; i<n; i++) {
			if(!visited[i] && weight[x][i]!=0) {
				distance[i] = weight[x][i];
				saveRoute[i] = vertex[x]; 
			}
		}
		
		for(int i=0; i<n; i++) {
			int minDistance = Integer.MAX_VALUE; 
			int minVertex = -1; 
			for(int j=1; j<n+1; j++) {
				if(!visited[j] && distance[j]!=Integer.MAX_VALUE) {
					if(distance[j]<minDistance) {
						minDistance = distance[j];
						minVertex = j;
					}
				}
			}	
			visited[minVertex] = true; 
			for(int j=1; j<n+1; j++) {
				if(!visited[j] && weight[minVertex][j]!=0) {
					if(distance[j]>distance[minVertex]+weight[minVertex][j]) {
						distance[j] = distance[minVertex]+weight[minVertex][j];
						saveRoute[j] = vertex[minVertex]; 
					}
				}
			}
		}
		for(int i=1; i<n; i++) {
			System.out.println("Distance from "+a+" to "+vertex[i]+" is : "+distance[i]);
		}
		
		System.out.println("==================================");
		
		for(int i=0; i<n; i++) {
			String route = "";
			System.out.print("Route from "+a+" to "+vertex[i]+" is : ");
			int index = i;
			while(true) {
				if(saveRoute[index] == vertex[index]) 
					break; 
				route = route + " " + saveRoute[index] +" -> ";
				index = stringToInt(saveRoute[index]); 
			}
			StringBuilder sb = new StringBuilder(route);
			System.out.println(sb + " "+ vertex[i]);
		}
	}
}

public class Assn2a{
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra(24);
		
		d.input("Ang Mo Kio", "Bukit Batok", 18);
		d.input("Ang Mo Kio", "Bukit Panjang", 16);
		d.input("Ang Mo Kio", "Nee Soon", 6);
		d.input("Ang Mo Kio", "Serangoon", 6);
		d.input("Ang Mo Kio", "Upper Thomson", 5);
		d.input("Bedok", "Bukit Timah", 22);
		d.input("Bedok", "Marina Bay",16);
		d.input("Bedok", "Outram",16);
		d.input("Bedok", "Tampines",5);
		d.input("Bedok", "Toa Payoh",13);
		d.input("Bedok", "Upper Thomson",16);
		d.input("Bukit Batok", "Ang Mo Kio",18);
		d.input("Bukit Batok", "Bukit Panjang",7);
		d.input("Bukit Batok", "Bukit Timah",5);
		d.input("Bukit Batok", "Clementi",7);
		d.input("Bukit Batok", "Choa Chu Kang",6);
		d.input("Bukit Batok", "Jurong",19);
		d.input("Bukit Batok", "Tuas",16);
		d.input("Bukit Panjang", "Ang Mo Kio",16);
		d.input("Bukit Panjang", "Bukit Batok",7);
		d.input("Bukit Panjang", "Bukit Timah",6);
		d.input("Bukit Panjang", "Choa Chu Kang",4);
		d.input("Bukit Panjang", "Mandai",15);
		d.input("Bukit Panjang", "Nee Soon",16);
		d.input("Bukit Panjang", "Upper Thomson",14);
		d.input("Bukit Panjang", "Woodlands",11);
		d.input("Bukit Timah","Bedok",22);
		d.input("Bukit Timah","Bukit Batok",5);
		d.input("Bukit Timah","Bukit Panjang",6);
		d.input("Bukit Timah","Clementi",5);
		d.input("Bukit Timah","Jurong",25);
		d.input("Bukit Timah","Queenstown",9);
		d.input("Bukit Timah","Toa Payoh",10);
		d.input("Bukit Timah","Upper Thomson",11);
		d.input("Clementi","Bukit Batok",7);
		d.input("Clementi","Bukit Timah",5);
		d.input("Clementi","Pasir Panjang",7);
		d.input("Clementi","Queenstown",5);
		d.input("Changi","Serangoon",16);
		d.input("Changi","Tampines",5);
		d.input("Changi","Toa Payoh",18);
		d.input("Choa Chu Kang","Bukit Batok",6);
		d.input("Choa Chu Kang","Bukit Panjang",4);
		d.input("Choa Chu Kang","Jurong",22);
		d.input("Choa Chu Kang","Tuas",15);
		d.input("Choa Chu Kang","Woodlands",11);
		d.input("Jurong","Bukit Batok",19);
		d.input("Jurong","Bukit Timah",25);
		d.input("Jurong","Choa Chu Kang",22);
		d.input("Jurong","Tuas",19);
		d.input("Mandai","Bukit Panjang",15);
		d.input("Mandai","Nee Soon",3);
		d.input("Mandai","Sembawang",6);
		d.input("Mandai","Woodlands",8);
		d.input("Marina Bay","Bedok",16);
		d.input("Marina Bay","Outram",2);
		d.input("Marina Bay","Toa Payoh",10);
		d.input("Nee Soon","Ang Mo Kio",6);
		d.input("Nee Soon","Bukit Panjang",16);
		d.input("Nee Soon","Mandai",3);
		d.input("Nee Soon","Sembawang",5);
		d.input("Nee Soon","Woodlands",9);
		d.input("Outram","Bedok",16);
		d.input("Outram","Marina Bay",2);
		d.input("Outram","Queenstown",5);
		d.input("Outram","Sentosa",6);
		d.input("Outram","Toa Payoh",8);
		d.input("Pasir Panjang","Clementi",7);
		d.input("Pasir Panjang","Queenstown",6);
		d.input("Pasir Panjang","Sentosa",8);
		d.input("Punggol","Serangoon",8);
		d.input("Queenstown","Bukit Timah",9);
		d.input("Queenstown","Clementi",5);
		d.input("Queenstown","Outram",5);
		d.input("Queenstown","Pasir Panjang",6);
		d.input("Queenstown","Sentosa",10);
		d.input("Queenstown","Toa Payoh",9);
		d.input("Queenstown","Upper Thomson",10);
		d.input("Sembawang","Mandai",6);
		d.input("Sembawang","Nee Soon",5);
		d.input("Sembawang","Woodlands",5);
		d.input("Sentosa","Outram",6);
		d.input("Sentosa","Pasir Panjang",8);
		d.input("Sentosa","Queenstown",10);
		d.input("Serangoon","Ang Mo Kio",6);
		d.input("Serangoon","Changi",16);
		d.input("Serangoon","Punggol",8);
		d.input("Serangoon","Tampines",12);
		d.input("Serangoon","Toa Payoh",6);
		d.input("Serangoon","Upper Thomson",8);
		d.input("Tampines","Bedok",5);
		d.input("Tampines","Changi",5);
		d.input("Tampines","Serangoon",12);
		d.input("Tampines","Toa Payoh",15);
		d.input("Toa Payoh","Bedok",13);
		d.input("Toa Payoh","Bukit Timah",10);
		d.input("Toa Payoh","Changi",18);
		d.input("Toa Payoh","Marina Bay",10);
		d.input("Toa Payoh","Outram",8);
		d.input("Toa Payoh","Queenstown",9);
		d.input("Toa Payoh","Serangoon",6);
		d.input("Toa Payoh","Tampines",15);
		d.input("Toa Payoh","Upper Thomson",6);
		d.input("Tuas","Bukit Batok",16);
		d.input("Tuas","Choa Chu Kang",15);
		d.input("Tuas","Jurong",19);
		d.input("Upper Thomson","Ang Mo Kio",5);
		d.input("Upper Thomson","Bedok",16);
		d.input("Upper Thomson","Bukit Panjang",14);
		d.input("Upper Thomson","Bukit Timah",11);
		d.input("Upper Thomson","Queenstown",10);
		d.input("Upper Thomson","Serangoon",8);
		d.input("Upper Thomson","Toa Payoh",6);
		d.input("Woodlands","Bukit Panjang",11);
		d.input("Woodlands","Choa Chu Kang",11);
		d.input("Woodlands","Mandai",8);
		d.input("Woodlands","Nee Soon",9);
		d.input("Woodlands","Sembawang",5);

		d.algorithm("Ang Mo Kio");
	}

}