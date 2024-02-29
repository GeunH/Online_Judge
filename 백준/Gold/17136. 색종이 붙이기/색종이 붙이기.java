import java.util.*;
import java.io.*;

public class Main {
    static int paper[] = {0,5,5,5,5,5};
    static int answer = Integer.MAX_VALUE;
    static int oneCnt;
    static boolean isVisit[][] = new boolean[10][10];
    static int map[][] = new int[10][10];
    static ArrayList<Position> list = new ArrayList<>();
    
    static class Position{
    	int y;
    	int x;
    	Position(int y,int x){
    		this.y=y;
    		this.x=x;
    	}
    }
    
    static boolean checkMap(int y ,int x, int range) {
    	if( y+range >10 || x + range >10)return false;
    	
    	for(int i=0; i< range; i++) {
    		for(int j=0; j< range; j++) {
    			if( isVisit[y+i][x+j] || map[y+i][x+j] != 1)return false;
    		}
    	}
    	return true;
    }
    
    static void start(int cnt, int oneCnt, int listCnt) {
    	if( cnt >= answer)return;
    	if(oneCnt ==0) {
    		if( cnt < answer)answer =cnt;
    		return;
    	}
    	
    	if( listCnt < list.size()) {
	    	int y = list.get(listCnt).y;
			int x = list.get(listCnt).x;
			
	    	if( !isVisit[y][x] && map[y][x] == 1){
	    		for(int k=5 ; k >= 1 ;k--) {
	    			if(paper[k]==0)continue;
	    			if(checkMap(y,x,k)) {
	    				paper[k]--;
	    				for(int m=0; m < k ;m++) {
	    					for(int l=0; l < k ;l++) {
	        					isVisit[y+m][x+l] = true;
	        				}
	    				}
	    				start(cnt+1, oneCnt-k*k, listCnt+1);
	    				for(int m=0; m < k ;m++) {
	    					for(int l=0; l < k ;l++) {
	    						isVisit[y+m][x+l] = false;
	        				}
	    				}
	    				paper[k]++;
	    			}	
	    		}	
	    	}
	    	else {
	    		start(cnt,oneCnt, listCnt+1);
	    	}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i< 10; i++) {
        	st = new StringTokenizer(br.readLine(), " " );
        	for(int j=0; j< 10 ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) {
        			oneCnt++;
        			list.add(new Position(i,j));
        		}
        	}
        }
        start(0,oneCnt, 0);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }
}
