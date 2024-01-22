import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Position{
	int y;
	int x;
	Position (int y,int x ){
		this.y=y;
		this.x=x;
	}
}

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int dirY[] = new int[] {-1,0,1,0};
		int dirX[] = new int[] {0,1,0,-1};
		
		boolean isVisit[][] = new boolean[N][M];
		
		char [][]map = new char[N][M];
		
		Queue <Position> queue = new LinkedList<>();
		
		for(int i=0; i < N ;i ++) {
			st = new StringTokenizer(reader.readLine(), " ");
			String line = st.nextToken();
			for(int j=0; j< M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'I') {
					queue.offer(new Position(i,j));
				}
			}
		}
		
		int answer =0;
		while(!queue.isEmpty()) {
			Position now = queue.poll();
			isVisit[now.y][now.x] = true;
			if(map[now.y][now.x]== 'P' )answer++;
			
			for(int i=0; i<4 ;i++) {
				int nextY = now.y + dirY[i];
				int nextX = now.x + dirX[i];
				
				if( nextY>= 0 && nextY < N && nextX >= 0 && nextX < M 
						&& !isVisit[nextY][nextX] && map[nextY][nextX] != 'X' ) {
					isVisit[nextY][nextX]=true;
					queue.offer(new Position(nextY,nextX));
				}
			}
			
		}
		if(answer ==0 )System.out.println("TT");
		else System.out.println(answer);
	}
}
