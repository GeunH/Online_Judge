import java.io.*;
import java.util.*;

class Solution
{
	static int N;
	static int D,W,K; // D 두께 , W 가로, K 최소 개수
	
	static int wall[][];
	
	static boolean nums[];
	static int[][] copyWall;
	
	static int answer;
	
	static void check(int changeCnt) {
		if(changeCnt > answer)return;
		int passCnt = 0;
		int cnt= 0;
		for(int j=0 ; j< W; j++) {
			cnt =1;
			if( K == 1) {
				passCnt++;
				continue;
			}
			for(int i=0; i< D-1; i++) {
				if(i+1 < D && copyWall[i][j] == copyWall[i+1][j]) {
					cnt++;
					if( cnt == K) {
						passCnt++;
						break;
					}
				}
				else {
					cnt = 1;
				}
			}
			if(passCnt != j+1)return;
		}
		if(changeCnt < answer )answer= changeCnt;
	}
	
	static void injection(int depth,int changeCnt ) {
		if(depth == D) {
			check(changeCnt);
			return;
		}
		if( nums[depth]) {
			for(int j=0 ; j< W; j++) {
				copyWall[depth][j] = 0;
			}
			injection(depth+1, changeCnt);
			for(int j=0 ; j< W; j++) {
				copyWall[depth][j] = 1;
			}
			injection(depth+1, changeCnt);
		}
		else {
			injection(depth+1,changeCnt);
		}
	}
	
	static void subset(int cnt, int changeCnt) {
		if(changeCnt > answer)return;
		if(cnt == D) {
			copyWall = new int[D][W];
			for(int i=0; i< D; i++) {
				copyWall[i] = Arrays.copyOf(wall[i], W);
			}
			injection(0,changeCnt);
			return;
		}
		nums[cnt] = false;
		subset(cnt+1, changeCnt);	
		nums[cnt] = true;
		subset(cnt+1, changeCnt+1);
	}
	
	static void init() {
		answer = Integer.MAX_VALUE;
		nums = new boolean[D];
		wall = new int[D][W];
		copyWall = new int[D][W];
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine(), " " );
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			init();
			for(int i=0; i< D ;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j= 0; j < W; j++) {
					wall[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i< D; i++) {
				copyWall[i] = Arrays.copyOf(wall[i], W);
			}
			check(0);
			if (answer != 0)subset(0,0);
			System.out.println("#" + test_case + " " + answer);
		}
	}
}