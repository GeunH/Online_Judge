import java.util.*;
import java.io.*;

/*
 	4단위 
 */

class Main
{
	static int N;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		int []dp =  new int[N+2];
		dp[0] = 1;
		dp[2] = 3;
		
		for(int i=4 ; i<= N; i+=2) {
			dp[i] = dp[i-2]*3;
			for(int j = 4; j <= i; j+=2) {
				dp[i] += dp[i-j]*2;
			}
		}
		System.out.println(dp[N]);
	}
}