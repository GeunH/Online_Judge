import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static int nums[];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			nums = new int[N];
			st = new StringTokenizer(br.readLine(), " " );
			for(int i=0; i< N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int dp[] = new int[N];
			dp[0]= 1;
			int answer = -1;
			for(int i=1; i< N; i++) {
				dp[i] = 1;
				for(int j = 0 ; j < i ; j++) {
					if( nums[j] < nums[i] && dp[j] + 1 > dp[i] ) {
						dp[i] = dp[j] +1;
						if( dp[i] > answer)answer = dp[i];
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer );
		}
	}
}