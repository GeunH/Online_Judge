import java.io.*;
import java.util.*;

class Solution {
    static int changeNum;
    static int answer;
    static boolean isDone;
    
    static boolean isMade(StringBuilder num) {
    	for(int i=0;i< num.length() -1; i++) {
    		if( num.charAt(i) < num.charAt(i+1)) {
    			return false;
    		}
    	}
    	return true;
    }

    static void comb(int changeCnt, StringBuilder num) {
        if (changeCnt == 0) {
            int currentNum = Integer.parseInt(num.toString());
            if (currentNum > answer) {
                answer = currentNum;
            }
            return;
        }
        int length = num.length();
        if (isMade(num)  ) {      
        	isDone = true;
        	if(changeCnt %2 ==1) {
        		for (int i = 0; i < length - 1; i++) {
                    for (int j = i + 1; j < length; j++) {
                    	swap(num, i, j);
                        comb(0, num);            
                        swap(num, i, j);
                    }
                }
        	}
        	else {
        		int currentNum = Integer.parseInt(num.toString());
                if (currentNum > answer) {
                    answer = currentNum;
                }
        	}
        	return;
        }
        
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if(isDone)return;
            	swap(num, i, j);
                comb(changeCnt - 1, num);            
                swap(num, i, j);
            }
        }
    }

    static void swap(StringBuilder num, int i, int j) {
        char temp = num.charAt(i);
        num.setCharAt(i, num.charAt(j));
        num.setCharAt(j, temp);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
        	isDone = false;
            st = new StringTokenizer(reader.readLine(), " ");
            StringBuilder num = new StringBuilder(st.nextToken());
            changeNum = Integer.parseInt(st.nextToken());
            answer = 0;
            comb(changeNum, num);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
