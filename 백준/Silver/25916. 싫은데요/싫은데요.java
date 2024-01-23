import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {		
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int hole[] = new int[N];
		
		st = new StringTokenizer(reader.readLine(), " ");
		for(int i=0; i<N; i++) {
			hole[i]= Integer.parseInt(st.nextToken());
		}
		
		int start = 0,end = 0;
		int sum = 0;
		int answer = 0;
		while(end < N) {
			if ( sum + hole[end] <= M ) {
				sum += hole[end++];
			}
			else {
				if ( start == end) {
					start++;
					end++;
				}
				else {
					sum -= hole[start++];
				}
			}
			if (answer < sum)answer =sum;
		}
		System.out.println(answer);
	}
}
