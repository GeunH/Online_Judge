import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int [][]map;    
    
    static boolean [][] isCheck;
    
    static int dirY[] = new int[] {-1,0,1,0};
    static int dirX[] = new int[] {0,1,0,-1};
    
    static int congestion[];
    
    static class Pos{
    	int r;
    	int c;
    	int d;
    	int p;
    	Pos(int r,int c, int d, int p){
    		this.r=r;
    		this.c=c;
    		this.d=d;
    		this.p=p;
    	}
    }
    
    static void makeCongestion(int r,int c,int d) {

    	for(int i=0; i<= d; i++) {
    		if( r-d+i >= 0 && r-d+i < N ) {
    			if( c-i >= 0 )map[r-d+i][c-i] = 1;
        		if( c+i < M ) map[r-d+i][c+i] = 1;
    		}
    		if( r+d-i >= 0 && r+d-i < N ) {
    			if( c-i >= 0 )map[r+d-i][c-i] = 1;
        		if( c+i < M ) map[r+d-i][c+i] = 1;
    		}
    	}
    }
    
    static int bfs() {
    	isCheck = new boolean[N][M];
    	Queue<Pos> queue = new LinkedList<>();
    	
    	queue.offer(new Pos(0,0,0,0));
    	isCheck[0][0] = true;
    	
    	while(!queue.isEmpty()) {
    		Pos now = queue.poll();
    		if( now.r == N-1 && now.c == M-1)return now.d;
    		for(int i=0; i< 4; i++) {
    			int nextR = now.r + dirY[i];
    			int nextC = now.c + dirX[i];
    			
    			if(nextR>=0 && nextR < N && nextC >=0 && nextC < M && !isCheck[nextR][nextC] && map[nextR][nextC] == 0 ) {
    				isCheck[nextR][nextC]= true;
    				queue.offer(new Pos(nextR,nextC, now.d+1, now.p));
    			}
    		}
    	}
    	return -1;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), "  ");
        
        int num = Integer.parseInt(st.nextToken());
        congestion = new int[num+1];
        
        for(int i=1; i<= num ; i++) {
        	st = new StringTokenizer(br.readLine() , " ");
        	int r =Integer.parseInt(st.nextToken())-1;
        	int c= Integer.parseInt(st.nextToken())-1;
        	int d = Integer.parseInt(st.nextToken());
        	makeCongestion(r,c,d);
        } 
        
        int cnt = bfs();
        
        if( cnt == -1) {
        	System.out.println("NO");
        }
        else {
        	System.out.println("YES");
        	System.out.println(cnt);
        }
    }
}