import java.util.*;
import java.io.*;

public class Main {
	static int T,N;
	
	static int[]p;
	
	static void findCommonP(int f,int s) {
		boolean isCheck[] = new boolean[N+1];
		
		while( f != 0) {
			isCheck[f] = true;
			f = p[f];
		}
		
		while(!isCheck[s]) {
			s = p[s];
		}
		
		System.out.println(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );
		
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i< T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			for(int j=0; j< N-1; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				p[child] = parent;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			findCommonP(f,s);
		}
	}

}