import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static boolean [][]map;
    static boolean [] row;
    static boolean [] col;
    static boolean [] diag;
    static boolean [] rediag;
    static int[] nums;
    
    static boolean isDone;
    static void nQueen(int i) {
    	if(i == N) {
    		isDone= true;
    		return;
    	}
    	if( row[i] ) {
    		nQueen(i+1);   		
    	}
    	else {
    		for(int j=0; j <N ;j++) {
            	if(  !col[j] && !diag[i+j] && !rediag[N-1-(i-j)] ) {
            		col[j] = diag[i+j] = rediag[N-1-(i-j)] = true;
            		nums[i] = j+1;
            		nQueen(i+1);
            		if(isDone)return;
            		col[j] = diag[i+j] = rediag[N-1-(i-j)] = false;
            	}
            }
    	}
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        
        row = new boolean[N];
        col = new boolean[N];
        diag = new boolean[2*N-1];
        rediag = new boolean[2*N-1];
            
        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< N; i++) {
        	int j = Integer.parseInt(st.nextToken());
        	if( j != 0) {
        		j--;
        		row[i]= true;
        		col[j] = true;
        		diag[i+j] = true;
        		rediag[N-1-(i-j)]= true;
        		nums[i] =j+1;
        	}
        }
        nQueen(0);
        if(!isDone) {
        	System.out.println(-1);
        }
        else {
			for(int j=0; j< N ;j++) {
    			System.out.print(nums[j] + " ");
    		}
		}
    }
}
