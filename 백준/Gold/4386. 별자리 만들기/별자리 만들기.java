import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int p[];
	static int rank[];
	
	static double x[];
	static double y[];
	
	static PriorityQueue<Edge> queue;
	
	static class Edge{
		int src;
		int dest;
		double weight;
		
		Edge(int src, int dest, double weight){
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
	}
	
	static void init() {
	    p = new int[N+1];
	    x = new double[N+1];
	    y = new double[N+1];
	    rank = new int[N+1];
	    for(int i = 1; i<= N; i++) {
        	p[i] = i;
        	rank[i] = 1;
        }
	}
	
	static int find(int num) {
		if(p[num] == num)return num;
		return p[num] = find(p[num]);
	}
	
	static void union(int x,int y) {
		if( rank[x] < rank[y]) {
			p[x] = p[y];
			rank[y] += rank[x];
		}
		else {
			p[y] = p[x];
			rank[x] += rank[y];
		}
	}
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        init();

        for(int i=1; i<= N; i++) {
        	st= new StringTokenizer(br.readLine(), " ");
        	x[i] = Double.parseDouble(st.nextToken());
        	y[i] = Double.parseDouble(st.nextToken());
        }
        queue = new PriorityQueue<>((o1,o2)-> {
        	if( o1.weight > o2.weight) return 1;
        	else if (o1.weight == o2.weight) return 0;
        	else return -1;
        });
        
        for(int i=1 ; i <= N; i++) {
        	for(int j=i+1 ;j<= N; j++) {
        		double dist = Math.sqrt( (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]) );
        		queue.offer(new Edge(i,j,dist));	
        	}
        }
        int cnt= 0;
        double answer= 0;
        while(!queue.isEmpty()) {
        	Edge now = queue.poll();
        	
        	int x = find(now.src);
        	int y = find(now.dest);
        	if( x != y) {
        		cnt++;
        		union(x,y);
        		answer += now.weight;
        		if( cnt == N-1) {
        			break;
        		}
        	}
        }
        System.out.printf("%.2f", answer);
        
    }
}
