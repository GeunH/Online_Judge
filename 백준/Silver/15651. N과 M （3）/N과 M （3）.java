import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int nums[];
    static int p[];
    static boolean isVisit[];
    static StringBuilder sb= new StringBuilder("");
    static void perm(int cnt) {
    	if( cnt ==M ) {
    		for(int i=0; i< M; i++) {
    			sb.append(p[i]+ " ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i=0; i< N; i++) {
    		p[cnt] = nums[i];
    		perm(cnt+1);
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisit = new boolean[N];
        nums = new int[N];
        p = new int[M];
        for(int i=0; i< N; i++) {
        	nums[i] = i+1;
        }
        perm(0);
        System.out.println(sb.toString());
    }
}
