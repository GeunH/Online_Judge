import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        
        int nums[] = new int[N];
        int dp[] = new int[N];
        
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = nums[i]; 
        }
        
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }
        
        int maxSum = dp[0];
        for(int i=1; i<N; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        System.out.println(maxSum);
    }
}
