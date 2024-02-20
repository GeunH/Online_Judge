import java.io.*;
import java.util.*;

public class Main {        
	static int N;
	static boolean isCheck[];
	static ArrayList<Node>[] links;
    static int answer;
    static int lastChild;
    
    static class Node{
    	int num;
    	int weight;
    	Node(int num, int weight){
    		this.num = num;
    		this.weight = weight;
    	}
    }
    
	static int findMaxDiameter(int num) {
		isCheck = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		
		int distance[] = new int[N+1];
		int maxDistance = 0;
		int maxDistanceNode = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			isCheck[now] = true;
			if(distance[now] > maxDistance) {
				maxDistance= distance[now];
				maxDistanceNode= now;
				if(distance[now] > answer)answer= distance[now];
			}
			for(int i=0; i < links[now].size(); i++) {
				if( !isCheck[links[now].get(i).num]) {
					distance[links[now].get(i).num] = distance[now] + links[now].get(i).weight;
					queue.offer(links[now].get(i).num);
				}
			}
		}
		return maxDistanceNode;
	}
	
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());      
        links = new ArrayList[N+1];
        
        for(int i=1 ; i <= N; i++) {
        	links[i] = new ArrayList<>();
        }
        
        for(int i=0; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int p = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	links[p].add(new Node(c,v));
        	links[c].add(new Node(p,v));
        }
        if ( N != 1) {
        	int node = findMaxDiameter(1);
            findMaxDiameter(node);
        }
        System.out.println(answer);
    }
}
