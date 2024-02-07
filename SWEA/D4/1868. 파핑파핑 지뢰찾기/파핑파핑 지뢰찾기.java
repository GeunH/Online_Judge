import java.io.*;
import java.util.*;

class Solution
{			
	static class Position{
		int y;
		int x;
		Position(int y,int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int N;
	static char [][] map;
	static int dirY[] = {-1,-1,-1,0,1,1,1,0};
	static int dirX[] = {-1,0,1,1,1,0,-1,-1};
	static boolean isVisit[][];
	static Queue<Position> queue;
	static int answer;
	
	static boolean isZero(int y,int x) {
		int cnt= 8;
		for(int k=0; k < 8; k++) {
			int nextY = y + dirY[k];
			int nextX = x + dirX[k];
			
			if(nextY <0 || nextY >= N || nextX <0 || nextX >= N) {
				cnt--;
			}
			else {
				if( map[nextY][nextX] == '.') {
					cnt--;
				}
			}
		}
		if (cnt == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int T= Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <=T ;test_case++) {
			st = new StringTokenizer(reader.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			queue = new LinkedList<>();
			map = new char[N][N];
			isVisit = new boolean[N][N];
			answer = 0;
			for(int i=0; i<N ;i++) {
				char[] elements = reader.readLine().toCharArray();
				for(int j=0; j <N ;j++) {
					map[i][j] = elements[j];
					if( map[i][j] =='.')answer++;
				}
			}
			
			for(int i=0; i< N; i++) {
				for(int j=0; j <N; j++) {
					if( map[i][j] == '.' && !isVisit[i][j]) {
						if(isZero(i,j)) {
							isVisit[i][j] = true;
							queue.offer(new Position(i,j));
						}
						while(!queue.isEmpty()) {
							Position now = queue.poll();
							for(int k= 0; k< 8; k++) {
								int nextY = now.y + dirY[k];
								int nextX = now.x + dirX[k];
								if(nextY >= 0 && nextY < N && nextX>=0 && nextX < N 
										&& map[nextY][nextX] == '.' && !isVisit[nextY][nextX] ){
									if ( isZero(nextY,nextX)) {
										queue.offer(new Position(nextY,nextX));
									}
									answer--;
									isVisit[nextY][nextX] = true;
								}
							}
							
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}