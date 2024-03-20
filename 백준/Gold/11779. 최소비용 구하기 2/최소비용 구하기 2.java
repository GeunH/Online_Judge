import java.util.*;
import java.io.*;

class Main
{
	static int N,M,s,e;
	
	static ArrayList<Edge> []nodes;
	static PriorityQueue<Node> queue;
	
	static class Edge{
		int dest;
		int weight;
		Edge(int dest, int weight){
			this.dest= dest;
			this.weight= weight;
		}
	}
	
	static class Node implements Comparable<Node> {
	    int index;
	    long distance;
	    
	    public Node(int index, long distance) {
	        this.index = index;
	        this.distance = distance;
	    }
	    
	    @Override
	    public int compareTo(Node other) {
	        return Long.compare(this.distance, other.distance);
	    }
	}
	
	static void djikstra() {
		long d[] = new long[N+1];
		int c[] = new int[N+1];
		Arrays.fill(d, Long.MAX_VALUE);
		queue = new PriorityQueue<>();
		d[s] = 0;
		c[s] = 1;
		
		StringBuilder sb[] = new StringBuilder[N+1];
		queue.offer(new Node(s, 0));
		sb[s] = new StringBuilder("" + s);
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int city = current.index;
			if(d[city] < current.distance) continue;
			
			for(Edge edge : nodes[city]) {
			    int dest = edge.dest;
				long newDist = d[city] + edge.weight;
				
				if(newDist < d[dest]) {
					sb[dest] = new StringBuilder(sb[city]+ " " +dest);
					d[dest] = newDist;
					queue.offer(new Node(dest, newDist));
					c[dest] = c[city]+1;
				}
			}
		}
		System.out.println(d[e]);
		System.out.println(c[e]);
		System.out.println(sb[e].toString());
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		
		for(int i= 1 ; i<= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0; i< M; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());	
			nodes[src].add(new Edge(dest,weight));
		}	
		
		st = new StringTokenizer(br.readLine(), " ");
		
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		djikstra();
	}
}
