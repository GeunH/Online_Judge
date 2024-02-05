import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int map[][];
	static boolean isVisit[][];
	static Queue<Position> queue;
	
	static int dirY[] = {-1,0,1,0};
	static int dirX[] = {0,1,0,-1};
	static int count;
	static int answer =1;
	static class Position{
		int y;
		int x;
		Position(int y,int x ){
			this.y=y;
			this.x=x;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		int maxHeight = 1;
		
		for(int i=0; i<N ;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j=0; j< N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( maxHeight < map[i][j]) {
					maxHeight = map[i][j];
				}
			}
		}
		
		
		for(int i=1; i < maxHeight; i++ ) {
			isVisit = new boolean[N][N];
			
			for(int j=0; j< N; j++) {
				for(int k=0; k< N; k++) {
					map[j][k] = map[j][k] -1 < 0 ? 0 : map[j][k]-1;
				}
			}
			queue= new LinkedList<>();
			
			count =0;
			for(int j=0; j< N ;j++) {
				for(int k=0; k<N ; k++) {
					if(map[j][k] > 0 && !isVisit[j][k]) {
						count++;
						isVisit[j][k] = true;
						queue.offer(new Position(j,k));
						
						while(!queue.isEmpty()) {
							Position now = queue.poll();
							int y = now.y;
							int x = now.x;
							for(int d=0; d< 4; d++) {
								int nextY = y + dirY[d];
								int nextX = x + dirX[d];
								
								if( nextY < N && nextY >= 0 && nextX< N && nextX >= 0
										&& !isVisit[nextY][nextX] && map[nextY][nextX] > 0) {
									isVisit[nextY][nextX] = true;
									queue.offer(new Position(nextY,nextX));
								}
							}
						}
					}
				}
			}
			if(answer < count)answer =count;
		}
		System.out.println(answer);
	}
	
}
