import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		for(int j=0; j < N; j++) {
			for(int i= 0; i< j; i++) {
				System.out.print(' ');
			}
			for(int i=N; i > j ; i--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
