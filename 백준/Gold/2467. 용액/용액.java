import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int liquid[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		liquid = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i< N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N-1;
		
		int sum = Integer.MAX_VALUE;
		
		int answer1 = 0;
		int answer2 = 0;
		
		while(start < end) {
			if( Math.abs(liquid[start] + liquid[end]) < sum) {
				sum  = Math.abs(liquid[start] + liquid[end]);
				answer1 = liquid[start];
				answer2 = liquid[end];
			}
			else {
				if( Math.abs(liquid[start+1] + liquid[end]) < Math.abs(liquid[start] + liquid[end-1]) ) {
					start++;
				}
				else {
					end--;
				}
			}
		}
		System.out.println(answer1 + " " + answer2);
	}
}
