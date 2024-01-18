import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
      String line = reader.readLine();
       
      String[] tokens = line.split(" ");
       
      int N = Integer.parseInt(tokens[0]);
      int M = Integer.parseInt(tokens[1]);
      
      int []dirY = new int[] {0,1,1};
      int []dirX = new int[] {1,0,1};
       
      int [][]map= new int[N][M];
      for(int i=0; i< N ;i++) {
    	  line = reader.readLine();
    	  tokens = line.split(" ");
    	  
    	  for(int j=0 ; j< M; j++) {
    		  map[i][j] = Integer.parseInt(tokens[j]);
    	  }
      }
      
      int [][] dp = new int[N][M];
      
      for(int i=0; i< N ; i++) {
    	  for(int j=0; j <M ;j++) {
    		  int diag = i-1 >=0 && j-1 >=0 ? dp[i-1][j-1] : 0;
    		  int left = j-1 >= 0 ? dp[i][j-1] : 0;
    		  int up = i-1>= 0 ? dp[i-1][j] : 0;
    		  dp[i][j] = Math.max(diag , Math.max(left, up)) + map[i][j];
    	  }
      }
      
      System.out.println(dp[N-1][M-1]);
      
      
    }
}
