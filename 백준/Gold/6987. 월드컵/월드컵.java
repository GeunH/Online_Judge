import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
public class Main{
    static int[] g1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] g2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static int sumWin;
    static int sumDraw;
    static int sumLose;
    static int[] win ;
    static int[] draw;
    static int[] lose;
    static boolean answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 4; t++) {
            sumWin = sumDraw = sumLose = 0;
            win = new int[6];
            draw = new int[6];
            lose = new int[6];
            answer = false;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                sumWin += win[i] = Integer.parseInt(st.nextToken());
                sumDraw += draw[i] = Integer.parseInt(st.nextToken());
                sumLose += lose[i] = Integer.parseInt(st.nextToken());
            }
            if(sumWin+sumDraw+sumLose!=30) {
                answer = false;
            }else {
                game(0);
            }
            System.out.print((answer==true ? 1:0)+" ");
            
        }System.out.println();            
    }
    private static void game(int cnt) {
        if(cnt == 15) {
            answer = true;
            return;
        }
        int t1 = g1[cnt];
        int t2 = g2[cnt];
        //t1이 이기는 게 가능한 경우
        if(win[t1]>0 && lose[t2]>0) {
            win[t1]--;
            lose[t2]--;
            game(cnt+1);
            win[t1]++;
            lose[t2]++;    
        }
        //t2가 이기는 게 가능한 경우
        if(lose[t1]>0 && win[t2]>0) {
            lose[t1]--;
            win[t2]--;
            game(cnt+1);
            lose[t1]++;
            win[t2]++;
        }
        //무승부가 가능한 경우
        if(draw[t1]>0 && draw[t2]>0) {
            draw[t1]--;
            draw[t2]--;
            game(cnt+1);
            draw[t1]++;
            draw[t2]++;        
        }
    }

    

}