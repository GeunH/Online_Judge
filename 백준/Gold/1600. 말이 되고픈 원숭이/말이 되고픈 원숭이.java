import java.util.*;
import java.io.*;

public class Main {
    static int K,W,H;
    static int[][] map;
 
    static int answer= Integer.MAX_VALUE;
    static int[] dirY = {-1,-2,-2,-1,1,2,2,1};
    static int[] dirX = {-2,-1,1,2,2,1,-1,-2};
    
    static int[] dirR = {-1,0,1,0};
    static int[] dirC = {0,1,0,-1};
    
    static class Position{
    	int y;
    	int x;
    	int cnt;
    	int jump;
    	Position(int y,int x, int cnt, int jump){
    		this.y=y;
    		this.x=x;
    		this.cnt = cnt;
    		this.jump = jump;
    	}
    }
    
    static void bfs() {
    	Queue <Position> queue = new LinkedList<>();
		boolean [][][]isVisit = new boolean[H][W][K+1];
		
		queue.offer(new Position(0,0,0,0));

		isVisit[0][0][0]=true;
		
		while(!queue.isEmpty()) {
			Position now = queue.poll();
			if(now.y == H-1 && now.x == W-1) {
				if(now.cnt < answer)answer= now.cnt;
			}
			
			if( now.cnt+1 > answer)return;
			if ( now.jump < K) {
				for(int i=0; i< 8; i++) {
					int nextY = now.y + dirY[i];
					int nextX = now.x + dirX[i];
					if( nextY >=0 && nextY < H && nextX>= 0 && nextX < W && map[nextY][nextX] == 0
							&& !isVisit[nextY][nextX][now.jump+1]) {
	        			queue.offer(new Position(nextY,nextX,now.cnt+1,now.jump+1));
	        			isVisit[nextY][nextX][now.jump+1] = true;
	        		}
				}
			}
			for(int i=0; i < 4; i++) {
				int nextY = now.y + dirR[i];
				int nextX = now.x + dirC[i];
				if( nextY >=0 && nextY < H && nextX>= 0 && nextX < W && map[nextY][nextX] == 0
						&& !isVisit[nextY][nextX][now.jump]) {
        			queue.offer(new Position(nextY,nextX,now.cnt+1, now.jump));
        			isVisit[nextY][nextX][now.jump] = true;
        		}
			}
		}
    }
    
 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        K = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine(), " ");
        
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
  
        for(int i=0; i< H; i++) {
        	st = new StringTokenizer(br.readLine(), " " );
        	for(int j=0; j< W ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
