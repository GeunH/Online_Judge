import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );
		
		int N = Integer.parseInt(st.nextToken());

		int [] switches = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i< N ;i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");	
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i< M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int gender = Integer.parseInt(st.nextToken());
			int base = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j = base-1; j < N; j += base) {
					switches[j] = (switches[j] + 1) %2;
				}
			}
			else {
				switches[base-1] = (switches[base-1] + 1) %2;
				int cnt =1;
				while(base-1-cnt >= 0 && base-1+cnt < N && switches[base-1-cnt] == switches[base-1+cnt]) {
					switches[base-1-cnt] = switches[base-1+cnt] = (switches[base-1-cnt] + 1) %2;
					cnt++;
				}
			}
		}
		for(int i=0; i<N ;i++) {
			if ( i > 0 && i %20 == 0)System.out.println();
			System.out.print(switches[i] + " ");
		}
		
	}
}