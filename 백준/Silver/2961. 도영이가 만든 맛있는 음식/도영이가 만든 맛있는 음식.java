import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int []nums;
	static int []sour;
	static int []bitter;
	static int N;
	static long answer = 1000000000;
	
	public static void comb(int start) {
		if( start == (1<<N)) {
			return;
		}
		int sourSum = 1;
		int bitterSum = 0;
		for(int i=0; i< N ; i++) {
			if( ((1 << i)&start) == (1 << i)) {
				sourSum *= sour[i];
				bitterSum += bitter[i];
			}
		}
		
		if ( answer > Math.abs(sourSum - bitterSum)) {
			answer =  Math.abs(sourSum - bitterSum);
		}
		comb(start + 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		
		sour = new int[N];
		bitter = new int[N];
		nums = new int[N];
		
		for(int i=0; i< N ;i++) {
			st = new StringTokenizer(reader.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
				
		comb(1);
		System.out.println(answer);
	}
}