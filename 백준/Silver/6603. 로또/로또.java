import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static int []p;
    static int R = 6;
    static int []nums;
    static void comb(int cnt, int start) {
    	if( cnt == R) {
    		for(int i=0; i< R; i++) {
    			System.out.print(nums[i]+" ");
    		}
    		System.out.println();
    		return;
    	}
    	for(int i = start ; i < N; i++) {
    		nums[cnt] = p[i];
    		comb(cnt+1,i+1);
    	}
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        
        while( N != 0) {
        	 p = new int[N];
        	 nums = new int[R];
             for(int i=0; i< N; i++) {
            	 p[i] = Integer.parseInt(st.nextToken());
             }
             comb(0,0);
             st = new StringTokenizer(br.readLine(), " ");
             N = Integer.parseInt(st.nextToken());
             System.out.println();
        }
        
        
    }
}
