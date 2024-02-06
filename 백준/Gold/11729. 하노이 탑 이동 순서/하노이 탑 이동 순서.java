import java.io.*;
import java.util.*;

public class Main {	
	static boolean isOdd;
	static int N;
	static StringBuilder sb = new StringBuilder("");
	static int count = 0;
	static void hanoi(int n,int from, int middle ,int to ) {
		count++;
		if( n == 1) {
			sb.append(from + " " + to + "\n");
			return;	
		}
		hanoi(n-1,from,to,middle);
		sb.append(from + " " + to + "\n");
		hanoi(n-1,middle,from,to );
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		hanoi(N,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
		sb.deleteCharAt(sb.length()-1);
	}
}
