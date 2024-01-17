import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Position{
	int y;
	int x;
	Position(int y,int x){
		this.y= y;
		this.x= x;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
       String line = reader.readLine();
       
       String [] elements = line.split(" ");
       
       int N = Integer.parseInt(elements[0]);
       int M = Integer.parseInt(elements[1]);
       
       int []dirY = new int[]{ -1, 0,1, 0};
       int []dirX = new int[] {0,1,0,-1};
       
       int [][] map = new int[N][M];
       
       for(int i=0; i< N ;i++) {
    	   line= reader.readLine();
    	   elements = line.split(" ");
    	   for(int j=0; j< M; j++) {
    		   map[i][j] = Integer.parseInt(elements[j]);
    	   }
    	   
       }
       
       boolean check[][] = new boolean[N][M];
       
       Queue <Position> queue = new LinkedList<>();
       
       int paintCnt = 0;
       int answer = 0;
       for(int i=0; i< N; i++) {
    	   for(int j=0; j <M; j++) {
    		   if(check[i][j] == false && map[i][j] == 1) {
    			   paintCnt++;
    			   queue.offer(new Position(i,j));
    			   int cnt =0;
    			   while(!queue.isEmpty()) {
    				   Position now = queue.poll();
    				   cnt++;
    				   check[now.y][now.x]= true; 
    				   for(int k=0; k < 4; k++) {
    					   int nextY = now.y + dirY[k];
    					   int nextX = now.x + dirX[k];
    					   if(nextY >=0 && nextY<N && nextX >=0 && nextX < M
    							   && check[nextY][nextX] == false && map[nextY][nextX] == 1) {
    						   check[nextY][nextX] = true;
    						   queue.offer(new Position(nextY,nextX));
    					   }
    				   }
    			   }
    			   if( cnt > answer)answer =cnt;
    		   }
    	   }
       }
       System.out.println(paintCnt);
       System.out.println(answer);
    }
}
