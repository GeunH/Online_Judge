import java.io.*;
import java.util.*;

public class Main {	
	static int N,M;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer>people = new LinkedList<>();
		for(int i=1; i <= N;  i++) {
			people.add(i);
		}
		
		
		StringBuilder sb = new StringBuilder("<");
		int start = 0;
		while(!people.isEmpty()) {
			start = (start + K-1) % people.size();
			sb.append(people.get(start));
			people.remove(start);	
			if ( people.size() > 0) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
