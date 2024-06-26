import java.io.*;
import java.util.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        N = Integer.parseInt(st.nextToken());
       
        int []dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2 ; i<= N; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}