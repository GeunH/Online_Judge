import java.util.Scanner;

public class Main{
    static int N, K;
    static int[][] DP;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        DP = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            int w = sc.nextInt();
            int v = sc.nextInt();

            for(int j=1;j<=K;j++){
                DP[i][j] = j < w ?
                        DP[i-1][j] :
                        v + DP[i-1][j-w] > DP[i-1][j] ?
                                v + DP[i-1][j-w] :
                                DP[i-1][j];
            }
        }
        System.out.println(DP[N][K]);
    }
}