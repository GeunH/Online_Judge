import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> []list;
	static boolean[] isCheck;
	static int[] indegree;
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());      
        M = Integer.parseInt(st.nextToken());
        isCheck = new boolean[N+1];
        list = new ArrayList[N+1];
        indegree = new int[N+1];
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
        int cnt =0 ;
        while(true) {
        	 for(int i=1 ;i<= N; i++) {
             	if(!isCheck[i] && indegree[i] == 0) {
             		isCheck[i] = true;
             		sb.append(i+ " ");		
             		cnt++;
             		for(int j= 0; j< list[i].size(); j++) {
             			indegree[list[i].get(j)]--;
             		}
             		break;
             	}
             }
        	 if(cnt == N)break;   	
        }   
        System.out.println(sb.toString()); 
    }
}
