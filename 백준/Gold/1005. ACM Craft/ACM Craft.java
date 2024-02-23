import java.io.*;
import java.util.*;

public class Main {
    static int N, K, W;
    static ArrayList<Integer>[] list;
    static int[] t, dp;
    
    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            for(int next: list[i]) {
                inDegree[next]++;
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                dp[i] = t[i]; 
            }
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next: list[now]) {
                dp[next] = Math.max(dp[next], dp[now] + t[next]); 
                if(--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
    
    static void init() {
        t = new int[N+1];
        dp = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int T = Integer.parseInt(st.nextToken());
        
        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            init();
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int i=1; i<=N; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                
                list[src].add(dest);
            }
            
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            
            topologicalSort();
            
            System.out.println(dp[W]); 
        }
    }
}
