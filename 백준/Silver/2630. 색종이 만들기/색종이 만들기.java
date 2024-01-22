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
	public static int answerW;
	public static int answerB;
	public static int [][]map;
	
	public static void checkPaper(int width, int y, int x) {
		int color = map[y][x];
		int cnt= 0;
		for(int i=y; i < y+width; i++) {
			for(int j=x; j < x+width ;j++) {
				if(map[i][j] == color)cnt++;
			}
		}
		
		if (cnt == width*width) {
			if(color == 1)answerB++;
			else answerW++;
		}
		else {
			width/=2;
			int placeY[] = new int[] {0,0,1,1};
			int placeX[] = new int[] {0,1,0,1};
			for(int i=0; i< 4; i++) {
				checkPaper(width, y+placeY[i]*width, x+placeX[i]*width );
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(reader.readLine(), " ");
			for(int j=0; j< N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		checkPaper(N,0,0);
		System.out.println(answerW + "\n" + answerB);
	}
}
