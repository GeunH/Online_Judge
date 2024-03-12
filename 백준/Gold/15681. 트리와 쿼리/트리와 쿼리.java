import java.util.*;
import java.io.*;

class Main
{
	static int N,R,Q;
	static ArrayList<Integer>[] nodes;
	
	static node[] V;
	
	static int vCnt[];
	
	static class node{
		int num;
		node par;
		ArrayList<node> child;
		node( int num, node par){
			this.num = num;
			this.par= par;
			this.child = new ArrayList<>();
		}
	}
	
	static void bfs() {
		boolean [] isVisit = new boolean[N+1];
		isVisit[R] = true;
		
		Queue< node> queue = new LinkedList<>();
		
		queue.offer( new node(R,null));
		
		while(!queue.isEmpty()){
			node now = queue.poll();
			V[now.num] = now;
			for(int i=0; i< nodes[now.num].size();i++) {
				int child = nodes[now.num].get(i);
				if ( !isVisit[child]) {
					node childNode = new node(child, now);
					now.child.add(childNode);
					isVisit[child] = true;
					queue.offer(childNode);
				}
			}
		}
	}
	
	static int subTreeNodeNum(int src) {
		vCnt[src] = 1;
		if ( V[src].child.size() == 0) {
			return vCnt[src];
		}
		for(int i=0; i< V[src].child.size(); i++) {
			if ( vCnt[V[src].child.get(i).num] == 0) {
				vCnt[src] += subTreeNodeNum(V[src].child.get(i).num);
			}
			else {
				vCnt[src] += vCnt[V[src].child.get(i).num];
			}
		}
		return vCnt[src];
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		V = new node[N+1];
		vCnt = new int[N+1];
		nodes = new ArrayList[N+1];
		
		for(int i=1 ; i<= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0; i< N-1; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			
			nodes[src].add(dest);
			nodes[dest].add(src);
		}
		bfs();
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i< Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			sb.append(subTreeNodeNum(num)+"\n");
		}
		System.out.println(sb.toString());
	}
}