import java.io.*;
import java.util.*;

public class Main {
	static char [][] map;
	static boolean isVisit[][];
	static int R,C;
	
	static Queue<Position> water;
	
	static Queue<Position> dochi;
	
	static int dirY[] = {-1,0,1,0};
	static int dirX[] = {0,1,0,-1};
	
	static class Position{
		int r;
		int c;
		int cnt;
		Position(int r,int c,int cnt){
			this.r=r;
			this.c=c;
			this.cnt=cnt;
		}
	}
	
	static String bfs() {
		int cnt= 0;
		while(!dochi.isEmpty()) {
			
			while(!water.isEmpty() && water.peek().cnt == cnt) {
				Position nowWater = water.poll();
				for(int i=0; i< 4; i++) {
					int nextY = nowWater.r+ dirY[i];
					int nextX = nowWater.c+ dirX[i];
					
					if( nextY>=0 && nextY < R && nextX >=0 && nextX < C 
							&& map[nextY][nextX] == '.') {
						map[nextY][nextX] = '*';
						water.offer(new Position(nextY,nextX,nowWater.cnt+1));
					}
				}
			}

			while(!dochi.isEmpty() && dochi.peek().cnt == cnt) {
				Position nowDochi = dochi.poll();
				for(int i=0; i< 4; i++) {
					int nextY = nowDochi.r+ dirY[i];
					int nextX = nowDochi.c+ dirX[i];	
					if( nextY>=0 && nextY < R && nextX >=0 && nextX < C 
							&& !isVisit[nextY][nextX] ) {
						if( map[nextY][nextX] == '.') {
							isVisit[nextY][nextX]= true;
							dochi.offer(new Position(nextY,nextX,nowDochi.cnt+1));
						}
						if( map[nextY][nextX] == 'D') {
							return String.valueOf(nowDochi.cnt+1);
						}
					}
				}
			}
			cnt++;
		}
		return "KAKTUS";
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        water = new LinkedList<>();
        dochi = new LinkedList<>();
        isVisit =new boolean[R][C];
        map = new char[R][C];
        
        for(int i=0; i< R ;i++) {
        	char [] line = br.readLine().toCharArray();
        	for(int j=0; j< C; j++) {
        		map[i][j] = line[j];
        		if(map[i][j] == '*')water.offer(new Position(i,j,0));
        		if(map[i][j] == 'S') {
        			isVisit[i][j] = true;
        			dochi.offer(new Position(i,j,0));
        		}
        	}
        }
        
        String answer = bfs();
        
        System.out.println(answer);
    }		
}