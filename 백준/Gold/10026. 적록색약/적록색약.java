import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static char map[][];
	static boolean [][] isVisit;
	static int dirY[] = new int[] {-1,0,1,0};
	static int dirX[] = new int[] {0,1,0,-1};
	
	static class Position{
		int y;
		int x;
		Position(int y,int x){
			this.y=y;
			this.x=x;	
		}
	}
	
	static int bfs(int state) {
		Queue <Position> queue = new LinkedList<>(); 
		isVisit = new boolean[N][N];
		
		int cnt = 0;
		for(int i=0; i< N; i++) {
			for(int j=0; j< N; j++) {
				if( !isVisit[i][j] ) {
					cnt++;
					queue.offer(new Position(i,j));
					isVisit[i][j] = true;
					
					while(!queue.isEmpty()) {
						Position now = queue.poll();
						
						for(int k=0; k< 4; k++) {
							int nextY = now.y + dirY[k];
							int nextX = now.x + dirX[k];
							
							if ( state == 1) {
								if ( map[i][j] == 'B'&& nextY >= 0 && nextY < N && nextX >= 0 && nextX < N 
										&& !isVisit[nextY][nextX] && map[nextY][nextX] == map[i][j]) {
									isVisit[nextY][nextX] = true;
									queue.offer(new Position(nextY,nextX));
								}
								else if (map[i][j] != 'B' && nextY >= 0 && nextY < N && nextX >= 0 && nextX < N 
										&& !isVisit[nextY][nextX] && map[nextY][nextX] != 'B') {
									isVisit[nextY][nextX] = true;
									queue.offer(new Position(nextY,nextX));
								}
							}
							else {
								if ( nextY >= 0 && nextY < N && nextX >= 0 && nextX < N 
										&& !isVisit[nextY][nextX] && map[nextY][nextX] == map[i][j]) {
									isVisit[nextY][nextX] = true;
									queue.offer(new Position(nextY,nextX));
								}
							}
							
						}
					}
				}
			}
		}
		return cnt;
	}
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());     

        map = new char[N][N];
        
        for(int i=0; i <N; i++) {
        	char [] line = br.readLine().toCharArray();
        	for(int j=0; j< N; j++) {
        		map[i][j] = line[j];
        	}
        }
        
        System.out.println(bfs(0)+ " " + bfs(1));
    }
}
