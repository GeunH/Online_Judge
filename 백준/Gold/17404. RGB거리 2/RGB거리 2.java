import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000 * 1000 + 1; // 충분히 큰 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;

        // 첫 번째 집의 색을 고정시키고 시작
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];
            // 초기화: 첫 번째 집의 색을 제외한 나머지는 큰 값으로 설정
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) dp[0][i] = house[0][i];
                else dp[0][i] = INF;
            }

            // 점화식을 이용한 DP 채우기
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
            }

            // 마지막 집에 대해 첫 번째 집과 다른 색을 고려하여 최소값 계산
            for (int i = 0; i < 3; i++) {
                if (i != firstColor) {
                    answer = Math.min(answer, dp[N-1][i]);
                }
            }
        }

        System.out.println(answer);
    }
}