import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	    int N = Integer.parseInt(br.readLine());
	    
	    int [] weight = new int[N];
	    int [] height = new int[N];
	    StringTokenizer st;
	    for(int i=0; i< N; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        weight[i] = Integer.parseInt(st.nextToken());
	        height[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    for(int i=0; i< N; i++) {
	    	int rank = 1;
	    	for(int j=0; j< N; j++) {
	    		if( height[i] < height[j] && weight[i] < weight[j]) {
	    			rank++;
	    		}
	    	}
	    	System.out.print(rank);
	    	if( i < N-1)System.out.print(" ");
	    }
	}
}