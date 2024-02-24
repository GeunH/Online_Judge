import java.util.*;
import java.io.*;

public class Main
{
	static int N, M;
	static int map[][];
	static int dirY[] = new int[] {-1,0,1,0};
	static int dirX[] = new int[] {0,1,0,-1};
	
	static int r[];
	static int p[];
	
	static PriorityQueue<Edge> edges = new PriorityQueue<>((o1,o2)-> o1.weight -o2.weight);
	static int islandCnt = 0;
	
	static class Position{
		int y;
		int x;
		Position(int y,int x){
			this.y=y;
			this.x=x;
		}
	}
	
	static class Edge{
		int src;
		int dest;
		int weight;
		Edge(int src, int dest, int weight){
			this.src =src;
			this.dest =dest;
			this.weight = weight;
		}
	}
	
	static void bfs() {
		boolean [][]isVisit = new boolean[N][M];
		Queue<Position> queue = new LinkedList<>();
		for(int i=0; i< N; i++) {
			for(int j=0; j <M ;j++) {
				if(map[i][j] == 1 && !isVisit[i][j]) {
					islandCnt++;
					queue.offer(new Position(i,j));
					isVisit[i][j] = true;

					map[i][j] = islandCnt;
					while(!queue.isEmpty()) {
						Position now = queue.poll();
						for(int k=0; k< 4; k++) {
							int nextY = now.y+dirY[k];
							int nextX = now.x+dirX[k];
							if( nextY>=0 && nextY < N && nextX>=0 && nextX < M
									&& !isVisit[nextY][nextX] && map[nextY][nextX] == 1) {
								isVisit[nextY][nextX] = true;
								map[nextY][nextX] = islandCnt;
								queue.offer(new Position(nextY,nextX));
							}
						}
					}
				}
			}
		}
	}
	
	static int find(int num) {
		if(p[num] == num)return num;
		return p[num] = find(p[num]);
	}
	
	static void union(int x,int y) {
		if( r[x] > r[y]) {
			r[x] += r[y];
			p[y]= p[x];
		}
		else {
			r[y] += r[x];
			p[x] = p[y];
		}
	}
	
	static void makeBridge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int cnt = 0;
                        int nextY = i + dirY[k];
                        int nextX = j + dirX[k];
                        while (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 0) {
                            cnt++;
                            nextY += dirY[k];
                            nextX += dirX[k];
                        }
                        if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] != map[i][j] && cnt > 1) {
                            edges.add(new Edge(map[i][j], map[nextY][nextX], cnt));
                        }
                    }
                }
            }
        }
    }
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0; i <N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j < M ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        bfs();
        r = new int[islandCnt+1];
        p = new int[islandCnt+1];
        
        for(int i =1 ; i <= islandCnt ; i++) {
        	p[i] = i;
        	r[i] = 1;
        }
        makeBridge();
        int answer =0;
        int cnt = 0;
        while(!edges.isEmpty()) {
			Edge now = edges.poll();
			if( now.weight == 1)continue;
			int x = find(now.src);
			int y = find(now.dest);
			
			if(x != y) {
				cnt++;
				union(x,y);
				answer += now.weight;
				if( cnt == islandCnt - 1) {
					break;
				}
			}
		}
        if(cnt == islandCnt - 1)System.out.println(answer);
        else System.out.println(-1);        
    }
}