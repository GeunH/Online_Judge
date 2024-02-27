import java.util.*;
import java.io.*;
public class Main {
	static int N;
	
	static class dot{
		int x;
		boolean isUp;
		dot(int x, boolean isUp){
			this.x=x;
			this.isUp= isUp;
		}
	}
	
	static int[] Y,X;
	
	static PriorityQueue<dot> pq = new PriorityQueue<>((o1,o2)-> o1.x - o2.x);
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine(), " " );
		N = Integer.parseInt(st.nextToken());
		
		Y = new int[N+1];
		X = new int[N+1];
		
		Stack<Integer> stack = new Stack<>();
		boolean start = false;
		
		int cnt= 0;
		for(int i=0; i<=N; i++) {
			int x;
			int y;
			if ( i < N) {
				st =new StringTokenizer(br.readLine(), " " );
				x = Integer.parseInt(st.nextToken());
				y= Integer.parseInt(st.nextToken());
				Y[i] = y;
				X[i] = x;
			}
			else {
				x = X[0];
				y = Y[0];
				Y[i] = y;
				X[i] = x;
			}
			
			if ( i > 0 && (Y[i] > 0 && Y[i-1] < 0)) {
				stack.push(x);
				start = true;
				if(start) {
					cnt= (cnt+1)%2;
					if( cnt == 0) {
						int first = stack.pop();
						int second = stack.pop();
						
						int small = Math.min(first, second);
						int big = Math.max(first, second);
						
						pq.offer(new dot(small, true));
						pq.offer(new dot(big, false));
					}
				}
			}
			else if ( i > 0 && (Y[i] < 0 && Y[i-1] > 0)) {
				stack.push(x);
				if(start) {
					cnt= (cnt+1)%2;
					if( cnt == 0) {
						int first = stack.pop();
						int second = stack.pop();
						
						int small = Math.min(first, second);
						int big = Math.max(first, second);
						
						pq.offer(new dot(small, true));
						pq.offer(new dot(big, false));
					}
				}
			}
		}
		while ( !stack.isEmpty()) {
			int first = stack.pop();
			int second = stack.pop();
			
			int small = Math.min(first, second);
			int big = Math.max(first, second);
			
			pq.offer(new dot(small, true));
			pq.offer(new dot(big, false));
		}
		
		int size = pq.size()/2;
		int upCnt =0;
		boolean last = false;
		
		int answer1 =0;
		int answer2= 0;
	
		while(!pq.isEmpty()) {
			dot now = pq.poll();
			if(now.isUp) {
				upCnt++;
			}
			else {
				upCnt--;
				if ( last) {
					answer2++;
				}
				if( upCnt == 0) {
					answer1++;
				}
			}
			last = now.isUp;
		}
		System.out.println(answer1 + " " + answer2);
	}
}