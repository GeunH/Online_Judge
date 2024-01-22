import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {	
	public static void makeStars(int num,int N) {
		if (num == 0 )return;
		for(int i=0; i < N - num ; i++) {
			System.out.print(' ');
		}
		for(int i=0; i< 2*num-1 ; i++) {
			System.out.print('*');
		}
		System.out.println();
		makeStars(num-1,N);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		

		makeStars(N,N);
		
	}
}
