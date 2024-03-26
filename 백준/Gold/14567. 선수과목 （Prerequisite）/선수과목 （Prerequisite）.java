import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] tree;
	static int[] indegree, res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1];
		indegree = new int[N+1];
		res = new int[N+1];
		
		for(int i=1;i<=N;i++) tree[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			tree[start].add(end);
			indegree[end]++;
		}
		Queue<Node> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(new Node(i, 1));
				res[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			
			for(int c : tree[p.num]) {
				indegree[c]--;
				if(indegree[c]==0) {
					res[c] = p.cnt+1;
					q.add(new Node(c, res[c]));
				}
			}
		}
		
		for(int i=1;i<=N;i++)
			System.out.printf("%d ", res[i]);
		System.out.println();
	}
	
	static class Node{
		int num, cnt;
		Node(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
}
