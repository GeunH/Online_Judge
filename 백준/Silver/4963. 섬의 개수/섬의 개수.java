import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Position{
	int y;
	int x;
	Position(int y,int x){
		this.y=y;
		this.x=x;
	}
}

public class Main {		
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int [] dirY = new int[] {-1,-1,-1,0,1,1,1,0};
		int [] dirX = new int[] {-1,0,1,1,1,0,-1,-1};
		
		while(w != 0 && h != 0) {
			
			Queue<Position> queue = new LinkedList<>();
			int map[][] = new int[h][w];
			boolean isVisit[][] = new boolean[h][w];
			for(int i=0; i< h; i++) {
				st = new StringTokenizer(reader.readLine(), " ");
				for(int j=0; j< w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer =0;
			for(int i=0; i< h; i++) {
				for(int j=0; j< w ;j++) {
					
					if(!isVisit[i][j] && map[i][j] == 1) {
						answer++;
						queue.offer(new Position(i,j));
						while (!queue.isEmpty()) {
							Position now = queue.poll();
							isVisit[now.y][now.x] = true;
							for(int k=0; k< 8; k++) {
								int nextY = now.y + dirY[k];
								int nextX = now.x + dirX[k];
								
								if(nextY >=0 && nextY < h && nextX >= 0 && nextX < w
										&& !isVisit[nextY][nextX] && map[nextY][nextX] == 1) {
									isVisit[nextY][nextX] = true;
									queue.offer(new Position(nextY,nextX));
								}
							}
						}
					}
				}
			}
			System.out.println(answer);
			
			
			st = new StringTokenizer(reader.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		
		
		
	}
}
