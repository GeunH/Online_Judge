import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int []rings = new int[N];
		
		st = new StringTokenizer(reader.readLine(), " ");
		for(int i=0; i< N; i++) {
			rings[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i< N; i++) {
			int bigRing = rings[i] > rings[0] ? rings[i] : rings[0];
			int smallRing = rings[i] > rings[0] ? rings[0] : rings[i];
			boolean isFirstBig = false;
			if ( bigRing != rings[0])isFirstBig = true;
			for(int j = smallRing ; j > 0 ; j--) {
				if( bigRing%j == 0 && smallRing%j == 0) {
					bigRing/=j;
					smallRing/=j;
				}
			}
			
			if(isFirstBig) System.out.println(smallRing + "/" + bigRing);
			else System.out.println(bigRing + "/" + smallRing);
		}
	}

}
