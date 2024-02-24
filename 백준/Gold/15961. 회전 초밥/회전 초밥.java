import java.util.*;
import java.io.*;

public class Main {
    static int N, d, k, c;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] foods = new int[N];

        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[d + 1];
        int differ = 0;
        
        for (int i = 0; i < k; i++) {
            if (cnt[foods[i]]++ == 0) differ++;
        }

        int answer = differ;
        if (cnt[c] == 0) answer++;

        for (int i = 0; i < N; i++) {
            if (--cnt[foods[i]] == 0) differ--;
            if (cnt[foods[(i + k ) % N]]++ == 0) differ++;

            if (cnt[c] == 0) {
                answer = Math.max(answer, differ + 1);
            } else {
                answer = Math.max(answer, differ);
            }
        }

        System.out.println(answer);
    }
}
