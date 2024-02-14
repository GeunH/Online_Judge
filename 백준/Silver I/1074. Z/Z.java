import java.io.*;
import java.util.*;

public class Main {        
    static int N,R,C;
    
    static void divCon(int N,int r,int c, int cnt) {
    	if(N>1) {
    		if( R < r+N/2 && C < c+N/2) {
    			divCon(N/2,r,c,cnt);
    		}
    		if ( R < r+N/2 && C >= c+N/2) {
    			divCon(N/2,r,c+N/2,cnt + N/2*N/2);
    		}
    		if ( R >= r+N/2 && C < c+N/2) {
    			divCon(N/2,r+N/2,c, cnt + N/2*N/2*2);
    		}
    		if( R >= r+N/2 && C >= c+N/2) {
    			divCon(N/2,r+N/2,c+N/2, cnt + N/2*N/2*3);
    		}
    		return;
    	}
    	if(r == R && c== C) {
    		System.out.println(cnt);
    		return;
    	}
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        int size = 1;
        for(int i=0; i< N; i++) {
        	size*=2;
        }
        divCon(size,0,0,0);
    }
}
