import java.io.*;
import java.util.*;

public class Main {	
	static int N,M,B;
	static int map [][];
	static int time = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		int minH = Integer.MAX_VALUE;
		for(int i=0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( minH > map[i][j]) minH = map[i][j];
			}
		}

		int cnt= 0;
		while(true) {
			int answer = 0;
			int block = 0;
			
			for(int i=0; i <N ; i++) {
				for(int j= 0; j <M ; j++) {
					if( map[i][j] > minH + cnt ) {
						answer += (map[i][j] - (minH+cnt))*2;
						block -= (map[i][j] - (minH+cnt));
					}
					else if (map[i][j] < minH+cnt) {
						answer += (minH+cnt - map[i][j]);
						block += (minH+cnt - map[i][j]);
					}
				}
			}	
			if( B - block < 0 || time < answer) {
				cnt--;
				break;
			}
			
			time = answer;
			cnt++;
		}
		
		System.out.println(time+ " " + (minH + cnt));
	}
}
