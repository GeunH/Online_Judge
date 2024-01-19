import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	public static boolean check(int A, int [] B) {
		int left = 0;
		int right = B.length -1;
		int middle = ( left + right )/2;
		
		while(left <= right) {
			middle = (left + right)/2;
			if ( B[middle] >  A) {
				right = middle -1;
			}
			else if (B[middle]<  A ) {
				left = middle + 1;
			}
			else return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = reader.readLine();
		
		
		StringTokenizer tokens = new StringTokenizer(line," ");
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int []A = new int[N];
		int []B = new int[M];
		
		line = reader.readLine();
		tokens = new StringTokenizer(line," ");

		for(int i=0; i <N;i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
		line = reader.readLine();
		tokens = new StringTokenizer(line," ");

		for(int i=0; i <M;i++) {
			B[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		int cnt = 0;
		
		StringBuilder sb = new StringBuilder("");
	
		for(int i=0; i < A.length ;i++) {
			if(!check(A[i], B)) {
				cnt++;
				sb.append(A[i]).append(" ");
			}
		}
		System.out.println(cnt);
		if(cnt !=0 )System.out.println(sb);
    }
}
