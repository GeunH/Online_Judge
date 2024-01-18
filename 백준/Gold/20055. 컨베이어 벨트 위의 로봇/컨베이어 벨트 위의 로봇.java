import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void moveBelt(int[] duration, boolean[] isExist, int N) {
	  int last = duration[N*2-1];
	  for(int i= N*2-1; i> 0 ; i--) {
  		  duration[i] = duration[i-1];
  		  if( i > 0 && i < N && isExist[i-1]) {
  			  isExist[i]=isExist[i-1];
  			  isExist[i-1] = false;
  		  }
  	  }
	  duration[0] = last;
  	  isExist[N-1]=false;
	}
	public static void moveRobot(int[] duration, boolean[] isExist, int N) {
	  for(int i= N-1; i> 0 ; i--) {
  		  if(duration[i] > 0 && !isExist[i] && isExist[i-1]) {
  			  duration[i]--;
  			  isExist[i]=true;
  			  isExist[i-1] = false;
  		  }
  	  }
  	  isExist[N-1]=false;
  	  if(duration[0]>0) {
  		  duration[0]--;
  		  isExist[0]= true;
  	  }
	}
	
	public static boolean check(int[] duration, int N, int K) {
  	  int cnt = 0;
  	  for(int i=0; i< N*2; i++) {
  		  if( duration[i] == 0 ) {
  			  cnt++;
  		  }
  	  }
  	  if( cnt >= K)return true;
  	  return false;
    }
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
      String line = reader.readLine();
      
      String[] tokens = line.split(" ");
      
      int N = Integer.parseInt(tokens[0]);
      int K = Integer.parseInt(tokens[1]);
      
      int []duration = new int[N*2];
      boolean []isExist = new boolean[N];
      
      line = reader.readLine();
      tokens = line.split(" ");
      
      for(int i=0; i <N*2; i++) {
    	  duration[i] = Integer.parseInt(tokens[i]);
      }
      int answer = 0;
      while(!check(duration,N,K)) {
    	  answer++;
    	  moveBelt(duration, isExist, N);
    	  moveRobot(duration, isExist,N);
      }
      System.out.println(answer);
    }
}
