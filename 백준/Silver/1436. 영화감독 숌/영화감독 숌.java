import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int cnt =1;
		int start = 666;
		
		while(cnt < N) {
			start++;
			if(String.valueOf(start).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(start);
		
	}
}
