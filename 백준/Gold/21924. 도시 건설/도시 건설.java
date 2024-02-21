import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int p[];
    static int r[];
    
    static PriorityQueue<Edge> queue;
    
    static class Edge{
    	int src;
    	int dest;
    	int weight;
    	
    	Edge(int src, int dest, int weight){
    		this.src= src;
    		this.dest= dest;
    		this.weight= weight;
    	}
    }
    
    static void init() {
    	queue= new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);
    	p = new int[N+1];
    	r = new int[N+1];
    	
    	for(int i=1; i<= N; i++) {
    		p[i] = i;
    		r[i] = 1;
    	}
    }
    
    static int find(int num) {
    	if(p[num] == num)return num;
    	return p[num] = find(p[num]);
    }
    
    static void union(int x,int y) {
    	if( r[x] > r[y]) {
    		p[y] = p[x];
    		r[x] += r[y];
    	}
    	else {
    		p[x] = p[y];
    		r[y] += r[x];
    	}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        
        long total = 0;
        for(int i=0; i< M; i++) {
        	st= new StringTokenizer(br.readLine(), " ");
        	
        	int src = Integer.parseInt(st.nextToken());
        	int dest= Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	total += weight;
        	queue.offer(new Edge(src,dest,weight));
        }
        
        int cnt= 0;
        long answer =0;
        while(!queue.isEmpty()) {
        	Edge now= queue.poll();
        	
        	int x = find(now.src);
        	int y = find(now.dest);
        	
        	if( x != y) {
        		cnt++;
        		answer += now.weight;
        		union(x,y);
        		if(cnt == N-1)break;
        	}
        }
        if(cnt != N-1)System.out.println(-1);
        else System.out.println(total-answer);
    }
}
