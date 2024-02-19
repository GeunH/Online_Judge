import java.io.*;
import java.util.*;

public class Main {        
	static int N;
    static int map[][];
    
    static boolean row[][];
    static boolean col[][];
    static boolean sqr[][];
    static boolean isNot;
    
    static int zeroCnt;
    static int zeroY[];
    static int zeroX[];
    
    static boolean answer= false;
    
    
    static void makePuzzle(int cnt) {
    	if(cnt == 5) {
    		answer = true;
    		for(int i=0; i< 9; i++) {
    			for(int j=0; j< 9; j++) {
    				System.out.print(map[i][j]);
    			}
    			System.out.println();
    		}
    		return;
    	}

    	int y= zeroY[cnt];
    	int x= zeroX[cnt];
 
    	for(int k=1 ; k <= 9 ; k++) {
    		if( !row[y][k] && !col[x][k] && !sqr[y/3*3+x/3][k] ) {
    			row[y][k] = col[x][k] = sqr[y/3*3+x/3][k] = true;
    			map[y][x] = k;
    			makePuzzle(cnt+1);
    			map[y][x] = 0;
    			row[y][k] = col[x][k] = sqr[y/3*3+x/3][k] = false;
    		}
    	}
    }
    
    static void init() {
    	map = new int[9][9];
        row = new boolean[9][10];
        col = new boolean[9][10];
        sqr = new boolean[9][10];
        zeroCnt = 0;
        
        zeroY = new int[5];
        zeroX = new int[5];
        isNot = false;
        answer = false;
    }
    
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
       
        for(int t=0; t< N ; t++) {
        	init();
            for(int i =0; i< 9; i++ ) {
            	char [] nums = br.readLine().toCharArray();
            	for(int j=0; j< 9 ;j++) {
            		map[i][j] = nums[j]-'0';
            		int num = map[i][j];
            		if( num != 0) {
            			if ( row[i][num] || col[j][num] || sqr[i/3*3+j/3][num] ) {
            				isNot = true;
            				continue;
            			}
            			row[i][num] = true;
            			col[j][num] = true;
            			sqr[i/3*3+j/3][num] = true;
            		}
            		else {
            			zeroY[zeroCnt] = i;
            			zeroX[zeroCnt] = j;
            			zeroCnt++;
            		}
            	}
            }   
            if( isNot) {
            	System.out.println("Could not complete this grid.");
            	if(t < N-1)System.out.println();
            }
            else {
            	makePuzzle(0);
                if(!answer) {
                	System.out.println("Could not complete this grid.");
                }
                if(t < N-1)System.out.println();
            }
        }
    }
}
