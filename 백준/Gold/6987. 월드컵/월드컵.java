import java.util.*;
import java.io.*;

public class Main {
    
    static int[] w, b, l, t;
    static boolean isCould;
    
    static int t1[] = new int[] { 1,1,1,1,1,2,2,2,2,3,3,3,4,4,5};
    static int t2[] = new int[] { 2,3,4,5,6,3,4,5,6,4,5,6,5,6,6};
    
    static void startGame(int gameIndex) {
        if (gameIndex == 15) {
            isCould = true; 
            return;
        }
        if (isCould) return;
        {
        	int teamA = t1[gameIndex];
        	int teamB = t2[gameIndex];
        	if (w[teamA] > 0 && l[teamB] > 0) {
                w[teamA]--;
                l[teamB]--;
                startGame(gameIndex + 1);
                w[teamA]++;
                l[teamB]++;
            }
            
            if (b[teamA] > 0 && b[teamB] > 0) {
                b[teamA]--;
                b[teamB]--;
                startGame(gameIndex + 1);
                b[teamA]++;
                b[teamB]++;
            }
            if (l[teamA] > 0 && w[teamB] > 0) {
                l[teamA]--;
                w[teamB]--;
                startGame(gameIndex + 1);
                l[teamA]++;
                w[teamB]++;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w = new int[7];
            b = new int[7];
            l = new int[7];
            isCould = false;
            
            boolean isValid = true;
            int totalGames = 0;
            
            for (int j = 1; j <= 6; j++) {
                w[j] = Integer.parseInt(st.nextToken());
                b[j] = Integer.parseInt(st.nextToken());
                l[j] = Integer.parseInt(st.nextToken());
                totalGames += w[j] + b[j] + l[j];
                
                if ((w[j] + b[j] + l[j]) != 5) isValid = false;
            }
            
            if (isValid && totalGames == 30) {
                startGame(0); 
            } else {
                isValid = false;
            }
            
            System.out.print(isCould && isValid ? "1 " : "0 ");
        }
    }
}
