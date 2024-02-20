import java.io.*;
import java.util.*;

public class Main {
	static int N,M;

	static PriorityQueue<Integer> queue;
	static int indegree[];
	
	static ArrayList<Integer> list[];
	
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());      
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1 ;i<= N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        queue = new PriorityQueue<>((o1,o2) ->  indegree[o1] - indegree[o2] );
        
        for(int i=0; i< M ;i++) {
        	st = new StringTokenizer(br.readLine(), " " );
        	
        	int num = Integer.parseInt(st.nextToken());
        	
        	int []order = new int[num];
        	
        	for(int j =0; j< num ;j++) {
        		order[j] = Integer.parseInt(st.nextToken());
        	}
        	
        	for(int j=0; j < num-1 ;j++) {
        		for(int k =j+1 ; k < num ; k++) {
        			list[order[j]].add(order[k]);
        			indegree[order[k]]++;
        		}
        	}
        }
        
        for(int i=1 ; i<= N; i++) {
        	if(indegree[i] == 0 ) {
        		queue.offer(i);
        	}
        }
        
        int cnt =0;
        StringBuilder sb = new StringBuilder("");
        
        while(!queue.isEmpty()) {
        	int now = queue.poll();
        	if(sb.toString() != "")sb.append("\n");
        	sb.append(now);
        	cnt++;
        	for(int i=0; i< list[now].size() ;i++) {
        		indegree[list[now].get(i)]--;
        		if( indegree[list[now].get(i)] == 0) {
        			queue.offer(list[now].get(i));
        		}
        	}
        }
        if ( cnt != N) {
        	System.out.println(0);
        }
        else {
        	System.out.println(sb);
        }
    }
}
