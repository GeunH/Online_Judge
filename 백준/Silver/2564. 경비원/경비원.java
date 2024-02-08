import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static int M;
    static int S;
    
    static int[] positions;
    static int cnt = 0;
    
    static int position(int dir, int x) {
    	if (dir == 1) {
    		return x;
    	}
    	if (dir == 2) {
    		return N +M + (N-x);
    	}
    	if (dir == 3) {
    		return 2*N+M+ (M-x);
    	}
    	else 
    	return N + x;
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        S = Integer.parseInt(st.nextToken());
        positions = new int[S];
        
        int answer = 0;
        for(int i=0; i< S; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int y = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	int p = position(y,x);
        	positions[i] = p;
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int start = position( Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
        
        for(int i=0; i< S; i++) {
        	int big = Math.max(positions[i], start);
        	int small = Math.min(positions[i], start);
        	
        	int first = big - small;
        	int second = Math.abs(small + (2*M+2*N)-big );
        	answer += Math.min( first, second);
        }
        System.out.println(answer);
    }
}
