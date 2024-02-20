import java.io.*;
import java.util.*;

public class Main {        
	static int N;
	static boolean isCheck[];
	static ArrayList<Node>[] links;
    static int answer;
    static int lastChild;
    
    static boolean isParent[];
    
    static class Node{
    	int num;
    	int weight;
    	Node(int num, int weight){
    		this.num = num;
    		this.weight = weight;
    	}
    }
    
	static void findMaxDiameter(int num, int len) {
		boolean isRest = false;
		for(int i=0 ; i< links[num].size(); i++) {
			if ( !isCheck[links[num].get(i).num]) {
				isCheck[links[num].get(i).num] = true;
				isRest = true;
				findMaxDiameter(links[num].get(i).num , len + links[num].get(i).weight);
			}
		}
		
		if( !isRest) {
			if(len > answer)answer =len;
		}
	}
	
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        
   
        links = new ArrayList[N+1];
        isParent = new boolean[N+1];
        
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
        	lastChild = c;
        	
        	isParent[p] = true;
        }
        
        for(int i=1 ; i<= N; i++) {
        	if( !isParent[i]) {
        		isCheck = new boolean[N+1];
        		isCheck[i] = true;
        		findMaxDiameter(i,0);
        	}
        }
        
        System.out.println(answer);
    }
}
