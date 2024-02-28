import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int map[][];
	
	static long pipe[][][];
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );

		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0 ; i <N; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			for(int j=0 ;j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pipe = new long[N][N][3];
		
		pipe[0][1][0] = 1;
		// 0  오른쪽 , 1 밑 , 2 오른 대각 밑
		for(int i=0; i< N; i++) {
			for(int j=1; j< N; j++) {
				for(int k=0 ;k < 3; k++) {
					if(pipe[i][j][k] != 0) {
						if( i+1<N && j +1 < N && map[i][j+1] == 0 && map[i+1][j] ==0 && map[i+1][j+1] == 0) {
							pipe[i+1][j+1][2] += pipe[i][j][k]; 
						}
						if ( (k ==0 || k == 2) && j+1 < N  && map[i][j+1] == 0 ) {
							pipe[i][j+1][0] += pipe[i][j][k];
						}
						if ( (k==1 || k == 2 ) &&  i + 1 < N&& map[i+1][j] == 0 ) {
							pipe[i+1][j][1] += pipe[i][j][k];
						}
					}
				}
			}
		}
		long answer = pipe[N-1][N-1][0] + pipe[N-1][N-1][1] + pipe[N-1][N-1][2];
		System.out.println(answer);
	}
}
