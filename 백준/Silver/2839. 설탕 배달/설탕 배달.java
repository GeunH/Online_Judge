import java.util.*;
import java.io.*;
public class Main {
	
	static int N;
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );

		int N = Integer.parseInt(st.nextToken());
		
		int []dp = new int[N+1 < 6 ? 6 : N+1];
		
		dp[3] = 1;
		dp[5] = 1;
		
		for(int i= 6 ; i<= N; i++) {
			if( dp[i-5] != 0 && dp[i-3] != 0) {
				dp[i] = Math.min(dp[i-5], dp[i-3])+1;
			}
			else if ( dp[i-5] != 0) {
				dp[i] =dp[i-5] + 1;
			}
			else if ( dp[i-3] != 0) {
				dp[i] = dp[i-3] + 1;
			}
		}
		if(dp[N] == 0)System.out.println(-1);
		else System.out.println(dp[N]);
	}
}
