import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		boolean isDestroyed[] = new boolean[N];
		boolean isHas[] = new boolean[N];
		st = new StringTokenizer(reader.readLine(), " ");
		for(int i=0; i< S ; i++) {
			int team = Integer.parseInt(st.nextToken());
			isDestroyed[team-1] = true;
		}
		st = new StringTokenizer(reader.readLine(), " ");
		for(int i=0;i<R; i++) {
			int team = Integer.parseInt(st.nextToken());
			isHas[team-1]= true;
		}
		
		int answer =0 ;
		for(int i=0; i< N; i++) {
			if( isDestroyed[i] && !isHas[i] ) {
				if ( i > 0 && !isDestroyed[i-1] && isHas[i-1]) {
					isHas[i-1] = false;
				}
				else if ( i < N-1 && !isDestroyed[i+1] && isHas[i+1] ) {
					isHas[i+1] = false;
				}
				else {
					answer++;
				}
			}
			else if (isDestroyed[i] && isHas[i]) {
				isHas[i] = false;
			}
		}
		System.out.println(answer);
	}
}
