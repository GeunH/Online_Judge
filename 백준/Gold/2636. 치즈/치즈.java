import java.io.*;
import java.util.*;

public class Main {        

    static int N;
    static int M;
    static int [][]map;
    static boolean isCheck[][];
    static int total;
    static int lastCheese;
    static Queue<Position> queue = new LinkedList<>();
    
    
    static int dirY[] = {-1,0,1,0};
    static int dirX[] = {0,1,0,-1};
        
    static class Position{
        int y ;
        int x;
        Position(int y,int x){
            this.y= y;
            this.x=x;
        }
    }
    
    static void bfs() {
        queue.offer(new Position(0,0));
        isCheck= new boolean[N][M];
        while(!queue.isEmpty()) {
            Position now = queue.poll();
            for(int i=0; i< 4; i++) {
                int y= now.y + dirY[i];
                int x= now.x + dirX[i];
                if(y >= 0 && y < N && x >= 0 && x < M && map[y][x] == 0 && !isCheck[y][x]) {
                    isCheck[y][x] = true;
                    map[y][x] = 2;
                    queue.offer(new Position(y,x));
                }
            }
        }
    }
    
    static void melt() {
        lastCheese = total;
        for(int i=0; i<N; i++) {
            for(int j=0; j< M; j++) {
                if( map[i][j] == 1) {
                    for(int k=0; k< 4; k++) {
                        int y= i + dirY[k];
                        int x= j + dirX[k];
                        if(y >= 0 && y < N && x >= 0 && x < M && map[y][x] == 2 ) {
                            total-=1;
                            map[i][j] = 0;
                            break; 
                        }
                    }
                }
            }
        }
        for(int i=0; i< N;i++) {
            for(int j=0; j <M ;j++) {
                if(map[i][j] == 2) map[i][j] =0; 
            }
        }
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if( map[i][j] == 1)total+=1;
            }
        }    

        int time = 0;
        while (true) {
            bfs(); 
            melt(); 
            time++;
            if (total == 0) {
                System.out.println(time);
                System.out.println(lastCheese);
                break;
            }
        }
    }
}
