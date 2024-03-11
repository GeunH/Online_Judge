import java.util.*;
import java.io.*;

class Main
{
	static int N,M;
	static int [][]map ;
	
	static class Pos{
		int y;
		int x;
		Pos(int y,int x){
			this.y=y;
			this.x=x;
		}
	}
	
	static int dirY[] = new int[] {-1,0,1,0};
	static int dirX[] = new int[] {0,1,0,-1};
	
	static int bfs() {
		int year =0;
		while(true) {
			boolean isVisit[][] = new boolean[N][M];
			Queue<Pos> queue= new LinkedList<>();
			int[][] copyMap = new int[N][M];
			for(int i=0; i< N; i++) {
				copyMap[i] = Arrays.copyOf(map[i], M);
			}
			int cnt= 0;
			for(int i=0; i< N; i++) {
				for(int j= 0; j< M; j++) {
					if ( !isVisit[i][j] && copyMap[i][j] != 0) {
						cnt++;
						if( cnt == 2)return year; 
						queue.offer(new Pos(i,j));
						isVisit[i][j] = true;
						while(!queue.isEmpty()) {
							Pos now=  queue.poll();
							int meltCnt=0;
							for(int k=0; k<4 ;k++) {
								int nextY = now.y + dirY[k];
								int nextX = now.x + dirX[k];
								
								if( copyMap[nextY][nextX] == 0) {
									meltCnt++;
								}
								if ( copyMap[nextY][nextX] != 0 && !isVisit[nextY][nextX]) {
									isVisit[nextY][nextX] =true;
									queue.offer(new Pos(nextY,nextX));
								}
							}
							map[now.y][now.x] = map[now.y][now.x] - meltCnt < 0 ? 0 : map[now.y][now.x]-meltCnt;    
						}
					}
				}
			}
			if(cnt == 0)return 0;
			year++;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i< N; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j= 0; j< M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = bfs();
		System.out.println(answer);
	}
}