import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] liquid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        liquid = new int[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);

        long minSum = Long.MAX_VALUE;
        int[] answer = new int[3];

        for (int i = 0; i < N - 2; i++) {
            int s = i + 1, e = N - 1;

            while (s < e) {
                long sum = (long) liquid[i] + liquid[s] + liquid[e];
                long absSum = Math.abs(sum);

                if (absSum < minSum) {
                    minSum = absSum;
                    answer[0] = liquid[i];
                    answer[1] = liquid[s];
                    answer[2] = liquid[e];
                }

                if (sum < 0) {
                    s++; 
                } else {
                    e--; 
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}