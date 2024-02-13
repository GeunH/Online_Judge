import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static boolean [][]map;
    static boolean [] row;
    static boolean [] col;
    static boolean [] diag;
    static boolean [] rediag;
    static int answer;
    static void nQueen(int cnt, int i) {
    	if(cnt == N) {
    		answer++;
    		return;
    	}
 
        for(int j=0; j <N ;j++) {
        	if(  !col[j] && !diag[i+j] && !rediag[N-1-(i-j)] ) {
        		col[j] = diag[i+j] = rediag[N-1-(i-j)] = true;
        		nQueen(cnt+1, i+1);
        		col[j] = diag[i+j] = rediag[N-1-(i-j)] = false;
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
              
        nQueen(0,0);
        System.out.println(answer);
    }
}
