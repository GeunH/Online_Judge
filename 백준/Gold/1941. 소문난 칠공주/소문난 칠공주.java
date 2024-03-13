import java.util.*;
import java.io.*;

public class Main {
	
	static char [][]map;	
	static int []dirY = new int[] {-1,0,1,0};
	static int []dirX = new int[] {0,1,0,-1};
	static int answer;
	static int nums[];
	
	static class Position{
		int y;
		int x;
		Position(int y,int x){
			this.y=y;
			this.x=x;
		}
	}
	
	static boolean princess() {
		boolean[][] exist = new boolean[5][5];
		
		for(int i=0; i< 7; i++) {
			int y = nums[i]/5;
			int x = nums[i]%5;
			exist[y][x] = true;
		}
		
		boolean[][] isVisit = new boolean[5][5];
		Queue<Position> queue =new LinkedList<>();
		
		queue.offer(new Position(nums[0]/5, nums[0]%5));
		
		int cnt= 0;
		int yCnt = 0;
		isVisit[nums[0]/5][nums[0]%5] = true;
		while(!queue.isEmpty()) {
			Position now = queue.poll();
			cnt++;
			if( map[now.y][now.x]== 'Y' )yCnt++;
			if( yCnt ==4)return false;
			
			for(int i=0; i< 4; i++) {
				int nextY = now.y+ dirY[i];
				int nextX = now.x+ dirX[i];
				
				if(nextY>=0 && nextY<5 && nextX>=0 && nextX <5 && !isVisit[nextY][nextX] && exist[nextY][nextX]) {
					isVisit[nextY][nextX] = true;
					queue.offer(new Position(nextY,nextX));
				}
			}
		}
		
		if( cnt == 7)return true;
		return false;
	}
	
	static void comb(int cnt , int start) {
		if( cnt == 7) {
			if(princess())answer++;
			return;
		}
		for(int i= start ; i <25; i++) {
			nums[cnt] = i;
			comb(cnt+1,i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		nums = new int[7];
		for(int i=0; i< 5; i++) {
			String line = br.readLine();
			for(int j=0; j < 5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		comb(0,0);
		System.out.println(answer);
	}
}
