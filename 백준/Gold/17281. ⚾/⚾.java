import java.io.*;
import java.util.*;

public class Main {	
	static int [] p = {0,1,2,3,4,5,6,7,8};
	static int [][] player;
	static int [] real;
	static int [] gamePlayer;
	static int turnCnt = 0;
	static int N;
	static boolean base[];
	static boolean isIn[];
	static int answer = 0;
	
	public static int startGame() {
		base = new boolean[4];
		int score =0;
		int outCnt = 0;
		while(outCnt < 3 ) {
			if( real[turnCnt] == 0) {
				outCnt++;
				turnCnt = (turnCnt +1)%9;
				continue;
			}
			base[0] = true;
			for(int j= 3; j >= 0; j--) {
				if( base[j] && j + real[turnCnt] > 3 ) {
					base[j] = false;
					score++;
				}
				else if(base[j] && j + real[turnCnt] <= 3){
					base[j+ real[turnCnt]] = true;
					base[j] = false;
				}
			}
			turnCnt = (turnCnt +1)%9;
		}
		return score;
	}
	
	static void perm(int cnt)throws IOException {
		if( cnt == 9 ) {
			if(gamePlayer[3] != 0)return;
			int score = 0;
			for(int i=0; i< N ; i++) {
				for(int j=0; j <9 ;j++) {
					real[j] = player[i][gamePlayer[j]];
				}
				score += startGame();
			}
			if(answer < score)answer= score;
			turnCnt = 0;
			return;
		}
		
		for(int i = 0; i < 9 ;i++) {
			if(!isIn[i]) {
				isIn[i] = true;
				gamePlayer[cnt] = p[i];
				perm(cnt+1);
				isIn[i] = false;
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		player = new int[N][9];
		real = new int[9];
		isIn = new boolean[9];
		gamePlayer = new int[9];
		
		for(int i=0 ; i < N ; i++) {
			st = new StringTokenizer(reader.readLine(), " ");			
			for(int j= 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}		
		}
		
		perm(0);
		
		System.out.println(answer);
	}
}
