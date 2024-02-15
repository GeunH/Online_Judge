import java.io.*;
import java.util.*;

public class Main {        
    static String first;
    static String second;
    
    static int[][] cnt;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        first = br.readLine();
        second = br.readLine();
        
        cnt = new int[first.length()+1][second.length()+1];
        
        for(int i=1; i <= first.length(); i++) {
            for(int j=1; j<= second.length() ;j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    cnt[i][j] = cnt[i-1][j-1]+1;
                } else {
                    cnt[i][j] = Math.max(cnt[i-1][j], cnt[i][j-1]);
                }
            }
        }
        
        System.out.println(cnt[first.length()][second.length()]);
        
        StringBuilder lcs = new StringBuilder();
        int i = first.length(), j = second.length();
        while(i > 0 && j > 0) {
            if(cnt[i][j] == cnt[i-1][j]) {
                i--;
            } else if(cnt[i][j] == cnt[i][j-1]) {
                j--;
            } else {
                lcs.append(first.charAt(i-1));
                i--;
                j--;
            }
        }
        if(cnt[first.length()][second.length()] != 0) {
            System.out.println(lcs.reverse().toString());
        }
    }
}
