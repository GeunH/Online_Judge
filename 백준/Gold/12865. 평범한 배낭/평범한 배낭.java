import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, K;
    static int[][] DP;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        DP = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
        	st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for(int j=1;j<=K;j++){
                DP[i][j] = j < w ? DP[i-1][j] :
                        v + DP[i-1][j-w] > DP[i-1][j] ?
                                v + DP[i-1][j-w] : DP[i-1][j];
            }
        }
        System.out.println(DP[N][K]);
    }
}