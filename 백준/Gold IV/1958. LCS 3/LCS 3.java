import java.io.*;
import java.util.*;

public class Main {        
    
    static int[][][] cnt;
    
    static void makeLCS(String first , String second, String third ) {
    	cnt = new int[first.length()+1][second.length()+1][third.length()+1];
        
        for(int i=1; i <= first.length(); i++) {
            for(int j=1; j<= second.length() ;j++) {
            	for(int k=1; k<= third.length() ;k++) {
	                if(first.charAt(i-1) == second.charAt(j-1) && second.charAt(j-1) ==third.charAt(k-1)) {
	                    cnt[i][j][k] = cnt[i-1][j-1][k-1]+1;
	                } else {
	                	int one = cnt[i-1][j][k];
	                	int two = cnt[i][j-1][k];
	                	int three = cnt [i][j][k-1];
	                    cnt[i][j][k] = Math.max(one , Math.max(two, three));
	                }
            	}
            }
        }
        System.out.println(cnt[first.length()][second.length()][third.length()]);
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
        
        makeLCS(first,second,third);

    }
}
