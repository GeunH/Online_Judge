import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt[] = new int[10001];
		
		for(int i=0 ; i <N; i++) {
			String line = br.readLine();
			cnt[Short.parseShort(line)]++;
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i=1 ; i<= 10000; i++) {
			while( cnt[i] > 0)	{
				sb.append(i + "\n");
				cnt[i]--;
			}
		}
		System.out.println(sb.toString());
	}
}
