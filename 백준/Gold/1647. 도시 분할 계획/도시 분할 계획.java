import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int []p;
	
	static PriorityQueue<Edge> vertics;
	
	static class Edge implements Comparable<Edge>{
		int s;
		int d;
		int w;
		
		Edge(int s, int d, int w){
			this.s=s;
			this.d=d;
			this.w=w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int find(int num) {
		if(p[num] == num) {
			return num;
		}
		return find(p[num]);
	}
	
	static void union(int a, int b) {
        p[Math.max(a, b)] = Math.min(a, b);
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());      
        M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        vertics = new PriorityQueue<>();
        for(int i=1 ; i<= N; i++) {
        	p[i] = i;
        }
        
        for(int i=0 ; i< M ; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int first = Integer.parseInt(st.nextToken());
        	int second = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	vertics.offer(new Edge(first,second,m));
        }
        
        int cnt= 0;
        int len = 0;
        int maxLen = 0;
        for(int i=0; i< M; i++) {
        	Edge now = vertics.poll();
        	
        	int x = find(now.s);
        	int y = find(now.d);
        	
        	if( x != y) {
        		cnt++;
        		len += now.w;
        		if ( maxLen < now.w)maxLen = now.w;
        		union(x,y);
        		if ( cnt == N- 1) {
        			break;
        		}
        	}
        }
        System.out.println(len -maxLen);
    }
}
