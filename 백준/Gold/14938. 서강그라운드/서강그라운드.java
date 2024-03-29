import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R;
    
    static int []items;
    
    static int distance[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        distance= new int[N+1][N+1];
        items = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=1; i<= N; i++) {
        	items[i] = Integer.parseInt(st.nextToken());
        	Arrays.fill(distance[i], 16);
        }
        
        for(int i=0; i< R; i++) {
        	st = new StringTokenizer(br.readLine(), " " );
        	int src = Integer.parseInt(st.nextToken());
        	int dest = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	weight = Math.min(distance[src][dest], weight);
        	distance[src][dest] = distance[dest][src] = weight;
        }
        
        for(int v = 1 ; v <= N; v++) {
        	for(int i=1; i<= N; i++) {
        		for(int j=1 ; j <= N; j++) {
        			if ( distance[i][j] > distance[i][v] + distance[v][j]) {
        				distance[i][j] = distance[i][v] + distance[v][j];
        			}
        		}
        	}
        }
        
        int total[] = new int[N+1];
        int answer=  0;
        for(int i=1 ; i< N; i++) {
        	total[i] += items[i];
        	for(int j =i+1 ; j <= N; j++) {
        		if(distance[i][j] <= M) {
        			total[i] += items[j];
        			total[j] += items[i];
        		}
        	}
        	if( answer < total[i])answer= total[i];
        }
        System.out.println(answer);
    }
}
