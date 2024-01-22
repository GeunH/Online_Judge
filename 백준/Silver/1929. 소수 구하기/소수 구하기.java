import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		StringBuilder sb = new StringBuilder("");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean [] isNotPrime = new boolean[1000001];
		for(int i=2; i<= N; i++) {
			int now = i;
			while(now + i<= N) {
				now += i;
				isNotPrime[now] = true;
			}
			if(!isNotPrime[i] && i >= M)sb.append(i).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
}
