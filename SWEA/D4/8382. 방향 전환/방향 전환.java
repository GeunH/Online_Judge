import java.io.*;
import java.util.*;

class Solution {         
	
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int dir = 0;
        	
        	st = new StringTokenizer(reader.readLine(), " ");
           
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            
            if( Math.abs(dx-sx) >= Math.abs(dy-sy)) {
            	dir = 1;
            }
            else {
            	dir = 0;
            }
            int answer =0;
            while(sy != dy || sx != dx) {
            	if( dir %2 ==0) {
            		if( sy < dy) {
            			sy+=1;
            		}
            		else {
            			sy-=1;
            		}
                }
                else {
                	if( sx < dx) {
            			sx +=1;
            		}
            		else {
            			sx -=1;
            		}
                }
            	dir++;
            	answer++;
            }
            System.out.println("#" + test_case+ " "+ answer);
        }
    }
}
