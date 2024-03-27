import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static char [][]map;
	static boolean isCheck[][][];
	
	static int dirY[] = new int[] {-1,-1,-1,0,1,1,1,0};
	static int dirX[] = new int[] {-1,0,1,1,1,0,-1,-1};

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][N];
			isCheck = new boolean[8][N][N];
			for(int i=0; i< N; i++) {
				char [] line = br.readLine().toCharArray();
				for(int j=0; j <N ; j++) {
					map[i][j] = line[j];
				}
			}
			
			String answer = "NO";
			loop:
			for(int i=0; i< N; i++) {
				for(int j=0; j <N; j++) {
					if( map[i][j] == 'o') {
						for(int k=0; k < 8; k++ ) {
							int cnt = 1;
							isCheck[k][i][j] = true;
							int tempY = i + dirY[k];
							int tempX = j + dirX[k];
							while(tempY >=0 && tempY < N && tempX>=0 && tempX< N
									&& map[tempY][tempX] == 'o' && !isCheck[k][tempY][tempX]){
								isCheck[k][tempY][tempX] = true;
								tempY = tempY + dirY[k];
								tempX = tempX + dirX[k];
								cnt++;
							}
							
							if( cnt >= 5) {
								answer = "YES";
								break loop;
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + answer );
		}
	}
}