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
		st = new StringTokenizer(br.readLine(), " " );
		for(int i=0; i< N; i++ ) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid);
		int start = 0;
		int end = N-1;
		
		int answer1 = liquid[start];
		int answer2 = liquid[end];
		
		while( start < end) {
			if( Math.abs(answer1 + answer2) >= Math.abs(liquid[start] + liquid[end]) ) {
				answer1 = liquid[start];
				answer2 = liquid[end];
			}
			if( Math.abs(liquid[start +1] + liquid[end]) > Math.abs(liquid[start] + liquid[end-1])) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println(answer1 + " " + answer2);
	}
}
