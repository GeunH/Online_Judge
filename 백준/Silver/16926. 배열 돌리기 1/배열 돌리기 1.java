import java.io.*;
import java.util.*;

public class Main {		
	static int N,M,R;
	static int [][]map;
	
	static void moveSquare(int depth) {
		int start = map[depth][depth];
		
		for(int i = depth ; i< M -depth - 1; i++) {
			map[depth][i] = map[depth][i+1];
		}
		for(int i = depth ; i < N -depth -1; i++) {
			map[i][M-depth-1] = map[i+1][M-depth-1];
		}
		for(int i= M - depth -1 ; i > depth; i--) {
			map[N-depth-1][i] = map[N-depth-1][i-1];
		}
		for(int i = N - depth - 1 ; i > depth ; i--) {
			map[i][depth] = map[i-1][depth];
		}
		map[depth+1][depth] = start;
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j< M ; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int cnt =0; cnt < R; cnt++) {
			int min = Math.min(N, M);
			for(int i=0; i< min/2; i++) {
				moveSquare(i);
			}
		}
		
		for(int i=0; i <N ;i++) {
			for(int j=0; j <M ;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
