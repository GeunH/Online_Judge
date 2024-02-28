import java.util.*;
import java.io.*;

public class Solution {
	static int w[],N, answer;
	static int left, right;
	
	static boolean isVisit[];
	static int nums[];
	
	static void setWeight( int left, int right, int start) {
		if(start == N) 
		{
			answer++;
			return;
		}
		setWeight( left +nums[start], right, start+1 );
		if( left >= right + nums[start])setWeight( left, right+nums[start], start+1 );
	}
	
	static void per(int cnt) {
		if( cnt == N) {
			setWeight(0,0,0);
			return;
		}
		for(int i=0; i< N; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				nums[cnt] = w[i];
				per(cnt+1);
				isVisit[i] = false;
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );

		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1 ; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N  = Integer.parseInt(st.nextToken());
			w = new int[N];
			answer=  0;
			left = right = 0;
			nums= new int[N];
			isVisit = new boolean[N];
			
			st= new StringTokenizer(br.readLine(), " " );
			for(int i=0; i< N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}
			
			per(0);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
