import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int nums[];
	public static boolean isCheck[];
	public static int N;
	public static int [][]score;
	public static int total;
	public static int answer = Integer.MAX_VALUE;
	
	public static void makeTeam(int cnt,int start) {
		if(cnt == N/2) {
			ArrayList<Integer> rest = new ArrayList<>();
			int sum = 0;
			for(int i=0; i< N; i++) {
				if(!isCheck[i])rest.add(i);
			}
			
			for(int i=0; i< cnt; i++) {
				for(int j=0; j< cnt; j++) {
					sum += (score[nums[i]][nums[j]] + score[nums[j]][nums[i]]);
					sum -= (score[rest.get(i)][rest.get(j)] + score[rest.get(j)][rest.get(i)]);
				}
			}
			sum/=2;
			if( answer > Math.abs(sum) )answer =Math.abs(sum);
			return;
		}
		
		for(int i=start ; i < N ; i++ ) {
			if(!isCheck[i]) {
				isCheck[i] = true;
				nums[cnt] = i;
				makeTeam(cnt+1,i+1);
				nums[cnt] = 0;
				isCheck[i] = false;
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		score = new int[N][N];
		for(int i=0 ; i< N ; i++) {
			st = new StringTokenizer(reader.readLine(), " ");
			for(int j=0; j< N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nums = new int[N/2];
		isCheck = new boolean[N];
		makeTeam(0,0);
		System.out.println(answer);
	}
}