import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		boolean []isIn = new boolean[N+1];
		boolean []isOut = new boolean[N+1];
		
		int top = 0;
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i< N; i++) {
			st= new StringTokenizer(reader.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			
			if(isOut[num]) {
				sb= new StringBuilder("NO");
				break;
			}
			
			if ( top > num) {
				while( top > num) {
					top--;
					while(isOut[top] && top > 0) {top--;}
					if (top != num) {
						sb.append('-').append('\n');
						isOut[top] = true;
					}
				}
			}
			if(top < num) {
				while( top < num) {
					top++;
					while(isIn[top] && top < num)top++;
					isIn[top] = true;
					sb.append('+').append('\n');
				}
			}
				
			if( top == num) {
				isOut[num] =true;
				sb.append('-').append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}
