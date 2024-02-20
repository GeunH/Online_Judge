import java.io.*;
import java.util.*;

public class Main {
	static int N,M;	
	static int p[];
	static int rank[];
	
	static int find(int num) {
		if(p[num] == num)return num;
		return p[num] = find(p[num]);
	}
	
	static void union(int x, int y ) {
		if( rank[y] > rank[x]) {
			p[x] = p[y];
			rank[y] += rank[x];
		}
		else {
			p[y] = p[x];
			rank[x] += rank[y];
		}
	}
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        p = new int[N+1];
        rank = new int[N+1];
        for(int i=0 ; i<= N; i++) {
        	p[i] = i;
        	rank[i] = 1;
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i< M ;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	char command = st.nextToken().charAt(0);
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());

        	if ( command == '0' && a != b) {
        		int x = find(a);
        		int y= find(b);
        		union(x,y);
        	}
        	else if ( command =='1') {
        		if(a==b) {
        			sb.append("YES\n");
        		}
        		else {
        			int x = find(a);
            		int y= find(b);
            		if( x == y) {
            			sb.append("YES\n");
            		}
            		else {
            			sb.append("NO\n");
            		}
        		}	
        	}		
        }
        System.out.println(sb.toString());
    }
}
