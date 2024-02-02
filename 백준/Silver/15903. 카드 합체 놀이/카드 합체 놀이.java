import java.io.*;
import java.util.*;

public class Main {	
	static int cards[];
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> queue = new PriorityQueue<>();

		st = new StringTokenizer(reader.readLine(), " ");
		long answer= 0;
		
		for(int i=0; i < N; i++) {
			long num = Integer.parseInt(st.nextToken());
			queue.add(num);
			answer += num;
		}
		for(int i=0; i< M ;i++) {
			long first = queue.poll();
			long second = queue.poll();
			long result = first + second;
			
			answer+=result;
			queue.offer(result);
			queue.offer(result);
		}
		System.out.println(answer);
	}
}
