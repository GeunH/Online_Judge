import java.util.*;
import java.io.*;

/*
 	정렬해서 이분 탐색을 해보자
 	정렬 기준을 뭘로 할 것인가 ? 
 	1. 0에서부터 가까운 순서대로?
 	-> 출발지? 도착지? 둘 다 해서?
 	2. 1번대로 하면 결국 증가하는 순서대로 찾는 것.
	-> 최장 증가하는 수열 LIS
	3. LIS는 DP와 이분탐색으로 풀 수 있다
	4. 이분탐색으로 풀어보기
 */

class Main
{
	static int N;
	static int arr[];
	static int answer[];
	
	static int LIS() {
		int len = 0;
		Arrays.fill(answer, Integer.MAX_VALUE);
		for(int i=0; i< N; i++) {
			int left = 0;
			int right = len;
			while(left < right) {
				int mid = left  + (right - left)/2;
				if ( arr[i] <= answer[mid]) {
					right = mid;
				}
				else {
					left = mid + 1;
				}
			}
			answer[left] = arr[i];
			if ( left == len) {
				len++;
			}
		}
		return len;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[N];
		st = new StringTokenizer(br.readLine(), " " );
		for(int i=0; i< N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(LIS());
	}
}