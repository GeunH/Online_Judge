import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> []list;
	static int[] indegree;
	
	static PriorityQueue<Integer> queue;
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());      
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        indegree = new int[N+1];
        
  
		queue = new PriorityQueue<>((o1, o2)->{ 
		if (indegree[o1] == indegree[o2]) {
			return o1-o2;
		}
		else {
			return indegree[o1] - indegree[o2];
		}
		});
		
        for(int i= 1 ; i<= N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int first = Integer.parseInt(st.nextToken());
        	int second = Integer.parseInt(st.nextToken());
        	list[first].add(second);
        	indegree[second]++;
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i=1 ;i<=N; i++) {
        	if(indegree[i] == 0) {
        		queue.offer(i);
        	}
        }
        
        while(!queue.isEmpty()) {
        	 int now = queue.poll();
        	 sb.append(now+ " ");	
        	 for(int j= 0; j< list[now].size(); j++) {
      			indegree[list[now].get(j)]--;
      			if(indegree[list[now].get(j)] == 0) {
      				queue.offer(list[now].get(j));
      			}
      		 }  	
        }   
        System.out.println(sb.toString()); 
    }
}
