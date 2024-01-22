import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		boolean [] isNotPrime = new boolean[1005001];
		isNotPrime[1] = true;
		for(int i=2; i<= 1005000; i++) {
			int now = i;
			while(now + i<= 1005000) {
				now += i;
				isNotPrime[now] = true;
			}
		}
		
		for(int i= N ;i < 1005000;i++) {
			if (!isNotPrime[i]) {
				StringBuilder sb = new StringBuilder(String.valueOf(i));
				if( sb.toString().equals(sb.reverse().toString()) ) {
					System.out.println(sb.toString());
					break;
				}
			}
		}
		
	}
}
