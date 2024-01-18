import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Position{
	int y;
	int x;
	int distance= 0;
	Position(int y, int x, int distance){
		this.y= y;
		this.x =x;
		this.distance= distance;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		
		String line = reader.readLine();
		
		String[] tokens = line.split(" ");
		
		int N = Integer.parseInt(tokens[0]);
		int M = Integer.parseInt(tokens[1]);
		
		int [][] map = new int[N][M];
		boolean [][] visit = new boolean[N][M];
		
		int []dirY= new int[] {-1,0,1,0};
		int []dirX = new int[] {0,1,0,-1};
		
		Queue <Position> queue = new LinkedList<>();
		
		for(int i=0; i< N; i++) {
			line = reader.readLine();
			tokens = line.split(" ");
			for(int j=0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokens[j]);
				if (map[i][j] == 2)queue.offer(new Position(i,j,0));
			}
		}
		
		while(!queue.isEmpty()) {
			Position now = queue.poll();
			
			visit[now.y][now.x]= true;
			map[now.y][now.x]= now.distance; 
			
			for(int i=0; i< 4; i++) {
				int nextY = now.y + dirY[i];
				int nextX = now.x + dirX[i];
				
				if( nextY >= 0 && nextY <N && nextX >=0  && nextX< M 
						&& !visit[nextY][nextX] && map[nextY][nextX] == 1) {
					visit[nextY][nextX] = true;
					queue.offer(new Position(nextY,nextX, now.distance+1));
				}
			}
		}
		
		for(int i=0; i< N; i++) {
			for(int j=0; j< M ; j++) {
				if(visit[i][j] == false && map[i][j] != 0)map[i][j] = -1;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		
    }
}
