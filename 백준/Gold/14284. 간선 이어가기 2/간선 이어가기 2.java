import java.util.*;
import java.io.*;

/*

*/

public class Main {
	static int N,M;
	
	static ArrayList<Edge> edges[] ;

	static int distance[];
	
	static class Edge{
		int d;
		int w;
		Edge(int d, int w){
			this.d=d;
			this.w=w;
		}
	}
	
	static void findPath(int s, int d) {
		PriorityQueue<Edge> pq =  new PriorityQueue<>((o1,o2)->o1.w-o2.w);
		pq.offer(new Edge(s,0));
		distance[s] = 0;
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			for(int i=0; i< edges[now.d].size() ;i++) {
				if( distance[edges[now.d].get(i).d] > distance[now.d] + edges[now.d].get(i).w  ) {
				    distance[edges[now.d].get(i).d] =  distance[now.d] + edges[now.d].get(i).w;
				    pq.offer(new Edge(edges[now.d].get(i).d, distance[edges[now.d].get(i).d]));
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges= new ArrayList[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=1 ;i<= N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i=0; i< M; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[src].add(new Edge(dest,weight));
			edges[dest].add(new Edge(src,weight));
		}
	
		st = new StringTokenizer(br.readLine(), " " );
		int s = Integer.parseInt(st.nextToken());
		int d =  Integer.parseInt(st.nextToken());
		
		findPath(s,d);
		System.out.println(distance[d]);
	}

}
