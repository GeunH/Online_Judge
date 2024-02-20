import java.io.*;
import java.util.*;

public class Main {
	static int N,M;	
	static int p[];
	
	static PriorityQueue<Edge> queue;
	static class Edge{
		int src;
		int dest;
		int weight;
		
		Edge(int src, int dest, int weight){
			this.src= src;
			this.dest= dest;
			this.weight = weight;
		}
	}
	
	static int find(int num) {
		if ( p[num] == num) {
			return num;
		}
		return find(p[num]);
	}
	
	static void union(int first, int second) {
		p[Math.max(first, second)] = Math.min(first, second);
	}
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());      
        p = new int[N+1];
        
        queue = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);
        
        M = Integer.parseInt(st.nextToken());
        for(int i=1; i<= N; i++) {
        	p[i] = i;
        }

        for(int i=0; i< M ;i++) {
        	st= new StringTokenizer(br.readLine(), " ");
        	int src = Integer.parseInt(st.nextToken());
        	int dest = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	queue.offer(new Edge(src,dest,weight));
        }
        
        int cnt= 0;
        int answer =0;

        while(!queue.isEmpty()) {
        	Edge now = queue.poll();
        	int src = find(now.src);
        	int dest = find(now.dest);
        	
        	if ( src != dest) {
        		cnt++;
        		union(src,dest);
        		answer += now.weight;
        		if(cnt == N-1)break;
        	}
        }
        System.out.println(answer);
    }
}
