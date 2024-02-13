import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static int M;
    static int D;
    static int [][] map;
    
    static int R = 3;
    static int nums[];
    
    static int answer;
    
    static Queue<Arrow> arrows = new LinkedList<>();
    
    static ArrayList<Monster> monsters = new ArrayList<>();
    
    static int dirY[] = {0,-1,0};
    static int dirX[] = {-1,0,1};
    static class Arrow{
    	int y;
    	int x;
    	int d;
    	Arrow(int y,int x,int d){
    		this.y=y;
    		this.x=x;
    		this.d=d;
    	}
    }
    
    static class Monster{
    	int y;
    	int x;
    	Monster(int y,int x){
    		this.y=y;
    		this.x=x;
    	}
    }
    
    
    static boolean gameOver(int turn) {
    	for(int i=0; i< N-1-turn; i++) {
    		for(int j=0; j< M; j++) {
    			if( map[i][j] == 1)return false;
    		}
    	}
    	return true;
    }
    
    static int shootArrow(int turn) {
    	int cnt = 0;
    	List <Monster> target = new LinkedList<>();
    	for(int i=0; i< nums.length;i++) {
    		boolean [][] isVisit = new boolean[N][M];
    		arrows.offer(new Arrow(N-1-turn,nums[i],1));
    		isVisit[N-1][nums[i]] = true;
    		while(!arrows.isEmpty()) {
    			Arrow arrow = arrows.poll();
    			if( map[arrow.y][arrow.x] == 1) {
    				target.add(new Monster(arrow.y,arrow.x));
    				arrows.clear();
    				break;
    			}
    			if( arrow.d < D) {
    				for(int k=0; k < 3; k++) {
    	    			int nextY = arrow.y + dirY[k];
    	    			int nextX = arrow.x + dirX[k];
    	    			if( nextY>=0 && nextX>=0 && nextX < M && !isVisit[nextY][nextX]) {
    	    				isVisit[nextY][nextX]= true;
    	    				arrows.offer(new Arrow(nextY,nextX,arrow.d+1));
    	    			}
    	    		}
    			}
    		}
    	}
    	for(int i=0; i< target.size(); i++) {
    		Monster m= target.get(i);
    		if(map[m.y][m.x] != 0 ) {
    			cnt++;
    			map[m.y][m.x] = 0;
    		}
    	}
    	return cnt;
    }
    
    static void gameStart() {
    	for( Monster monster : monsters) {
    		map[monster.y][monster.x] = 1;
    	}
    	int gameScore =0;
    	int turn = 0;
    	while(true) {
    		gameScore += shootArrow(turn);
    		if(gameOver(turn))break;
    		turn++;
    	}
    	if(answer < gameScore)answer= gameScore;
    }
    
    static void comb(int cnt, int start) {
    	if( cnt == R) {
    		gameStart();
    		return;
    	}
    	for(int i= start ;i < M; i++) {
    		nums[cnt] = i;
    		comb(cnt+1,i+1);
    	}
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        nums = new int[R];
        map = new int[N][M];
        for(int i=0 ; i< N ;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) {
        			monsters.add(new Monster(i,j));
        		}
        	}
        }
        
        comb(0,0);
        System.out.println(answer);
    }
}
