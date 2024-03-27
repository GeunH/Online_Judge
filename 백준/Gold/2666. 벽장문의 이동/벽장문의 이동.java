import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static int N, d1, d2, res;
	static int[] door;
	static int[][][] DP;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
    	N = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	d1 = Integer.parseInt(st.nextToken());
    	d2 = Integer.parseInt(st.nextToken());
    	
    	door = new int[Integer.parseInt(br.readLine())+1];
    	DP = new int[door.length+1][N+1][N+1];
    	for(int i=1;i<door.length;i++)
    		door[i] = Integer.parseInt(br.readLine());
    	DP[0][d1][d2] = 1;
    	DFS(1);
    	System.out.println(res-1);
    }
    
    static void DFS(int dept) {
    	int min = Integer.MAX_VALUE;
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			if(DP[dept-1][i][j] !=0) {
    				int move = Math.abs(i-door[dept]);
    				if(DP[dept][door[dept]][j]==0)
    					DP[dept][door[dept]][j] = DP[dept-1][i][j]+move;
    				else DP[dept][door[dept]][j] = Math.min(DP[dept][door[dept]][j], DP[dept-1][i][j]+move);
    				min = Math.min(min, DP[dept][door[dept]][j]);
    				move = Math.abs(j-door[dept]);
    				if(DP[dept][i][door[dept]]==0)
    					DP[dept][i][door[dept]] = DP[dept-1][i][j]+move;
    				else DP[dept][i][door[dept]] = Math.min(DP[dept][i][door[dept]], DP[dept-1][i][j]+move);
    				min = Math.min(min, DP[dept][i][door[dept]]);
    			}
    		}
    	}
    	if(dept == door.length-1) {
    		res = min;
    		return;
    	}
    	DFS(dept+1);
    }
}