import java.util.*;
import java.io.*;
public class Main {
	
	static fibo[] nums;
	
	static class fibo{
		int zeroCnt;
		int oneCnt;
		fibo(int zeroCnt, int oneCnt){
			this.zeroCnt = zeroCnt;
			this.oneCnt = oneCnt;
		}
	}
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );

		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i< T; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			int N = Integer.parseInt(st.nextToken());
			
			nums = new fibo[N+1];
			
			nums[0] = new fibo(1,0);
			
			if ( N >= 1 )nums[1] = new fibo(0,1);
			
			for(int j = 2 ; j<= N; j++ ) {
				nums[j] = new fibo(nums[j-1].zeroCnt + nums[j-2].zeroCnt , nums[j-1].oneCnt + nums[j-2].oneCnt);
			}
			System.out.println(nums[N].zeroCnt + " " + nums[N].oneCnt);
		}
		
		
	}
}
