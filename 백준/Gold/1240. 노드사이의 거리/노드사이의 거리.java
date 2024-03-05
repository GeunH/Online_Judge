import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    
    
    static ArrayList<Node> nodes[];
    static boolean isVisit[];
    static class Node{
    	int d;
    	int w;
    	Node(int d,int w){
    		this.d=d;
    		this.w=w;
    	}
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nodes = new ArrayList[N+1];
        
        for(int i= 1 ;i<= N; i++) {
        	nodes[i] = new ArrayList<>();
        }
        
        for(int i=0 ;i < N-1; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	nodes[s].add(new Node(d,w));
        	nodes[d].add(new Node(s,w));
        }
        
        for(int i=0; i< M; i++) {
        	isVisit = new boolean[N+1];
        	st  = new StringTokenizer(br.readLine(), " ");
        	int s = Integer.parseInt(st.nextToken());
        	int d= Integer.parseInt(st.nextToken());
        	Queue<Node> queue = new LinkedList<>();
        	queue.offer(new Node(s,0));
        	isVisit[s]= true;
        	while(!queue.isEmpty()) {
        		Node now = queue.poll();
        		for(int j=0; j< nodes[now.d].size(); j++) {
        			if(nodes[now.d].get(j).d == d ) {
        				System.out.println(nodes[now.d].get(j).w + now.w);
        				queue.clear();
        				break;
        			}
        			else if( !isVisit[nodes[now.d].get(j).d] ){
        				queue.offer(new Node(nodes[now.d].get(j).d, nodes[now.d].get(j).w + now.w));
            			isVisit[nodes[now.d].get(j).d] = true;
        			}
        		}
        	}
        }
    }
}
