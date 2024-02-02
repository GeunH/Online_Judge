import java.io.*;
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
	static int map[][];
	static Queue<Position> queue;
	static int dirY[] = {-1,0,1,0};
	static int dirX[] = {0,1,0,-1};
	static boolean[][] isVisit;
	
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();		
		map = new int[N][N];
		isVisit = new boolean[N][N];
		
		for(int i=0; i< N;i++) {
			char []line = reader.readLine().toCharArray();
			for(int j=0; j< N ;j++) {
				map[i][j] = line[j]- '0';
			}
		}
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i< N; i++ ) {
			for(int j=0; j <N; j++) {
				if(map[i][j] == 1 && !isVisit[i][j]) {
					int cnt= 0;
					queue.offer(new Position(i,j));
					while(!queue.isEmpty()) {
						Position now =queue.poll();
						cnt++;
						int y= now.y;
						int x= now.x;
						isVisit[y][x] =true;
						
						for(int k=0; k< 4; k++) {
							int nextY = y+ dirY[k];
							int nextX = x + dirX[k];
							if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N
									&& !isVisit[nextY][nextX] && map[nextY][nextX] == 1) {
								isVisit[nextY][nextX] = true;
								queue.offer(new Position(nextY,nextX));
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		
		int [] answer = new int[list.size()];
		for(int i=0; i< list.size();i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		System.out.println(answer.length);
		for( int a : answer) {
			System.out.println(a);
		}
	}
}
