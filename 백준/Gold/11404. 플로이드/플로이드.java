import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int [][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " " );
        M = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];
        
        for(int i=1 ; i <=N; i++) {
        	Arrays.fill(distance[i], 10000001);
        	distance[i][i] = 0;
        }
        
        for(int i=0; i< M ; i++) {
        	st = new StringTokenizer(br.readLine(), " " );
        	int src = Integer.parseInt(st.nextToken());
        	int dest = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	distance[src][dest] = Math.min( weight, distance[src][dest]);
        }
        for(int v= 1; v <= N ; v ++) {
        	for(int s = 1 ; s <= N; s++) {
        		for(int d =1 ; d <= N; d++) {
        			if ( distance[s][d] > distance[s][v] + distance[v][d]) {
        				distance[s][d] = distance[s][v] + distance[v][d];
        			}
        		}
        	}
        }

        for(int s = 1 ; s <= N; s++) {
    		for(int d =1 ; d <= N; d++) {
    			if( distance[s][d] == 10000001)distance[s][d] = 0;
    			System.out.print(distance[s][d] + " " );
    		}
    		System.out.println();
    	}
    }
}