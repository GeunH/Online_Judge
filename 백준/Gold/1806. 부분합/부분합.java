import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int nums[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        
        st = new StringTokenizer(br.readLine(), " " );
        
        for(int i=0; i< N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int end = 1;
        int sum = nums[0];
        int answer = Integer.MAX_VALUE;
        if ( sum >= S)answer = 1;
        
        for(int start = 0 ; start < N ;start++) {
        	while(end < N && sum < S) {
        		sum += nums[end++];
        	}
        	
        	if( sum >= S) {
        		if ( end - start < answer)answer= end -start;     
        		sum -= nums[start];
        	}	
        }
        
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
