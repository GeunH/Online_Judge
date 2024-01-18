import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
      String line = reader.readLine();
       
      int N = Integer.parseInt(line);
      
      int dp[][] = new int[N+1][10];
      for(int i=0 ; i < 10 ;i++) {
    	  dp[1][i] = 1;
      }
      
      for(int i= 2; i <= N ; i++) {
    	  for(int j= 0; j < 10; j++) {
    		  for(int k= 0; k <= j ; k++) {
    			  dp[i][j] = (dp[i][j] + dp[i-1][k])%10007;
    		  }
    	  }
      }
    	  
      int answer =0;
      for(int i= 0; i <10 ;i++) {
    	  answer= (answer + dp[N][i])%10007;
      }
      System.out.println(answer);
      
      
    }
}
