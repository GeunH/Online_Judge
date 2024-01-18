import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Position{
	int y;
	int x;
	Position(int y, int x){
		this.y= y;
		this.x =x;
	}
}

public class Main {
	public static int [][] map;
	public static boolean [][] chosen;
	public static int N;
	public static int M;
	public static Position[] virus;
	public static int virusCnt= 0;
	public static Position[] wall = new Position[3];
	public static int[] dirY = new int[] {-1,0,1,0};
	public static int[] dirX = new int[] {0,1,0,-1};
	public static int maxSize = 0;
	public static int safeCnt = 0;
	
	public static void spreadVirus() {
		Queue <Position> queue = new LinkedList<>();
		boolean [][]visit = new boolean[N][M];
		for(int i=0; i< 3; i++) {
			map[wall[i].y][wall[i].x] = 1;
		}
		for(int i=0; i< virusCnt; i++) {
			queue.offer(virus[i]);
		}
		int answer= 0;
		while(!queue.isEmpty()) {
			Position now= queue.poll();
			visit[now.y][now.x]= true;
			answer++;
			for(int i=0; i< 4; i++) {
				int nextY = now.y + dirY[i];
				int nextX = now.x + dirX[i];
				
				if ( nextY>=0 && nextY< N && nextX >=0 && nextX < M 
						&& map[nextY][nextX] == 0 && !visit[nextY][nextX]) {
					visit[nextY][nextX] = true;
					queue.offer(new Position(nextY,nextX));
				}
			}
			
		}
		
		if (maxSize < (safeCnt-3) - answer + virusCnt) {
			maxSize = (safeCnt-3) - answer + virusCnt ;
		}
		
		for(int i=0; i< 3; i++) {
			map[wall[i].y][wall[i].x] = 0;
		}
	}
	
	public static void makeWall(int cnt ) {
		if( cnt < 3) {
			for(int i=0; i< N; i++) {
				for(int j=0; j <M; j++) {
					if(chosen[i][j] == false && map[i][j] == 0 ) {
						chosen[i][j] = true;
						wall[cnt] = new Position(i,j);
						makeWall(cnt+1);
						chosen[i][j] = false;
					}
				}
			}
		}
		else if( cnt == 3) {
			spreadVirus();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		
		String line = reader.readLine();
		String [] tokens = line.split(" ");
		N = Integer.parseInt(tokens[0]);
		M = Integer.parseInt(tokens[1]);
		
		map = new int[N][M];
		chosen = new boolean[N][M];
	    virus= new Position[10];

		for(int i=0; i <N ;i++) {
			line=reader.readLine();
			tokens = line.split(" ");
			for(int j= 0; j < M ; j++) {
				map[i][j] = Integer.parseInt(tokens[j]);
				if (map[i][j] == 2) {
					virus[virusCnt++] = new Position(i,j);
				}
				if ( map[i][j] == 0 )safeCnt++;
			}
		}
		
		makeWall(0);
		
		System.out.println(maxSize);
    }
}
