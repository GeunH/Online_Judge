import java.io.*;
import java.util.*;

public class Main {	
	static Node [] nodes;
	static boolean[]isVisit;
	static int count =0;
	
	static class Node{
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
	}
	
	static void dfs(int num) {
		count++;
		isVisit[num] = true;
		for ( Node node : nodes[num].next) {
			if( !isVisit[node.num]) {
				dfs(node.num);
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(reader.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
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
		
		
		dfs(1);
		
		System.out.println(count-1);

	}
}
