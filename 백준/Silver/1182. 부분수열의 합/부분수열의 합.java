import java.util.*;
import java.io.*;

public class Main {
    static int N,S;
    static int nums[];
    static int answer;
    static boolean isVisit[];
    static void subset(int cnt, int start, int sum) {
        if(sum == S && cnt > 0) {
            answer++;
        }
        for(int i = start; i < N; i++) {
            if(!isVisit[i]) { 
                isVisit[i] = true;
                subset(cnt + 1, i + 1, sum + nums[i]);
                isVisit[i] = false;
            }
        }
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        isVisit = new boolean[N];
        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        subset(0,0,0);
        System.out.println(answer);
    }
}
