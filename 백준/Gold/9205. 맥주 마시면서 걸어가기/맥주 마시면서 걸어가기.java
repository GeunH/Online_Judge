import java.util.*;
import java.io.*;

public class Main {
    static int T,N;
    
    static List<Integer>[]nodes;
    
    static Position[] stores;
    
    static class Position{
    	int y;
    	int x;
    	Position(int y,int x){
    		this.y=y;
    		this.x=x;
    	}
    }
    
    static String bfs() {
    	Queue<Integer> queue= new LinkedList<>();
    	
    	queue.offer(0);
    	boolean isVisit[] = new boolean[N+2];
    	
    	while(!queue.isEmpty()) {
    		int now = queue.poll();
    		if( now == N+1)return "happy";
    		
    		for(int i=0; i < nodes[now].size() ;i++) {
    			int dest = nodes[now].get(i);
    			
    			if(!isVisit[dest] ) {
    				isVisit[dest] =true;
    				queue.offer(dest);
    			}
    		}
    	}
    	return "sad";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        
        for(int tc =0; tc < T; tc++) {
        	st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            
            stores = new Position[N+2];
            
            st = new StringTokenizer(br.readLine(), " " );
            
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            
            stores[0] = new Position(y,x);
            
            for(int i=1; i<= N; i++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	y = Integer.parseInt(st.nextToken());
            	x = Integer.parseInt(st.nextToken());
            	stores[i] = new Position(y,x);
            }
            
            st = new StringTokenizer(br.readLine(), " ");
        	y = Integer.parseInt(st.nextToken());
        	x = Integer.parseInt(st.nextToken());
        	stores[N+1] = new Position(y,x);
        	
        	
        	nodes = new ArrayList[N+2];
        	
        	for(int i=0; i< N+2; i++) {
        		nodes[i] = new ArrayList<>();
        	}
        	for(int i=0; i< N+2; i++) {
        		for(int j =i+1; j< N+2 ; j++) {        			
        			if( Math.abs(stores[i].y - stores[j].y) + Math.abs(stores[i].x - stores[j].x) <= 1000 ) {
        				nodes[i].add(j);
        				nodes[j].add(i);
        			}
        		}
        	}
        	
        	String answer = bfs();
        	System.out.println(answer);
        }
    }
}