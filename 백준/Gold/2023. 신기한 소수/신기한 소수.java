import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int []numbers;
	static int start[] = {2,3,5,7};
	static int nums[] = {1,3,5,7,9};
	static int N;
	static StringBuilder answer = new StringBuilder("");
	static StringBuilder sb = new StringBuilder("");
	
	public static boolean isPrime(int num) {
		if(num == 1)return false;
		for(int i= 2; i<=(int)(Math.sqrt(num)) ; i++) {
			if(num%i == 0)return false;
		}
		return true;
	}

	public static void hc(int cnt) {
		if( cnt == N-1) {
			if(answer.toString()!= "")answer.append('\n');
			answer.append(sb.toString());
			return;
		}
		
		for(int i=0 ;i< nums.length; i++) {
			sb.append(nums[i]);
			if( isPrime(Integer.parseInt(sb.toString())) ) {
				hc(cnt+1);
			}
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

		N = Integer.parseInt(st.nextToken());		
		numbers = new int[N-1];
		
		for(int i=0; i< 4; i++) {
			sb = new StringBuilder(""+start[i]);
			hc(0);
		}
		
		System.out.println(answer.toString());
	}
}