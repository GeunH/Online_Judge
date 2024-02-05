import java.io.*;
import java.util.*;

public class Main {	
	static Node [] nodes;
	static boolean[]isVisit;
	static Queue<Node> que = new LinkedList<>();
	
	static class Node implements Comparable<Node>{
		int num;
		List<Node> next; 
		Node(int num){
			this.num =num;
			this.next = new ArrayList<>();
		}
		void setPath(int num) {
			nodes[num].next.add(this);
			this.next.add(nodes[num]);
		}
		@Override
		public int compareTo(Node o) {
			if(this.num > o.num) return 1;
			else if (this.num == o.num) return 0;
			return -1;
		}		
	}
	
	static void dfs(int num) {
		System.out.print(num);
		isVisit[num] = true;
		Collections.sort(nodes[num].next);
		for( Node a : nodes[num].next) {
			if(!isVisit[a.num]) {
				System.out.print(" ");
				dfs(a.num);
			}
		}
	}
	
	static void bfs(int V) {
		que.offer(nodes[V]);
		isVisit[V] = true;
		while(!que.isEmpty()) {
			Node now = que.poll();
			System.out.print(now.num+ " ");
			for( Node a : now.next) {
				if(!isVisit[a.num]) {
					isVisit[a.num] = true;
					que.offer(nodes[a.num]);
				}
			}			
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[N+1];
		
		nodes = new Node[N+1];
		
		for(int i=1; i<= N;i++) {
			nodes[i] = new Node(i);
		}		
		
		for(int i=0; i< M;i++) {
			st = new StringTokenizer(reader.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			nodes[from].setPath(to);
			nodes[to].setPath(from);
		}
		
		
		dfs(V);
		
		System.out.println();
		isVisit = new boolean[N+1];
		bfs(V);
	}
}
