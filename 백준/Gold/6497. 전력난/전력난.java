import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int p[];
	static int rank[];
	
	static PriorityQueue<Edge> queue;
	
	static class Edge{
		int src;
		int dest;
		int weight;
		
		Edge(int src, int dest, int weight){
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
	}
	
	static void init() {
	    p = new int[N];
	    rank = new int[N];
	    for(int i = 0; i< N; i++) {
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
        StringTokenizer st;
        
        while(true) { 
        	st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0)break;
            init();
            queue = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);
            
            long total =0;
            
            for(int i=0; i< M; i++) {
            	st= new StringTokenizer(br.readLine(), " ");
            	int src = Integer.parseInt(st.nextToken());
            	int dest = Integer.parseInt(st.nextToken());
            	int weight= Integer.parseInt(st.nextToken());
            	queue.offer(new Edge(src,dest,weight));	
            	total += weight;
            }           
            
            int cnt= 0;
            long answer= 0;
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
            System.out.println(total - answer);
        }      
    }
}
