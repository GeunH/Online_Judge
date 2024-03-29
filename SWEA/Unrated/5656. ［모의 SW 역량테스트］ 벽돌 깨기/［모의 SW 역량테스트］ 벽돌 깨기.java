import java.io.*;
import java.util.*;

class Brick {
    int y;
    int x;
    int range;
    
    public Brick(int y, int x, int range) {
        this.y = y;
        this.x = x;
        this.range = range;
    }
}

public class Solution {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    private static int N, W, H;
    private static int[][] originMap;
    
    private static int totalBrickAmount;
    private static int minRemainBrickAmount;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<T+1; t++) {
            int answer = run();
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
    
    private static int run() throws IOException {
        setInput();
        game(0, 0, originMap);
        return minRemainBrickAmount;
    }
    
    private static void setInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        originMap = new int[H][W];
        
        totalBrickAmount = 0;
        for (int j=0; j<H; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<W; i++) {
                originMap[j][i] = Integer.parseInt(st.nextToken());
                if (originMap[j][i] != 0) {
                    totalBrickAmount++;
                }
            }
        }
    
        minRemainBrickAmount = Integer.MAX_VALUE;
    }
    
    private static void game(int count, int brokenBrick, int[][] map) {
        if (count == N) {
            minRemainBrickAmount = Math.min(minRemainBrickAmount, totalBrickAmount - brokenBrick);
            return;
        }
        
        for (int i=0; i<W; i++) {
            int[][] copiedMap = copyMap(map);
            int broke = drop(i, copiedMap);
            game(count + 1, brokenBrick + broke, copiedMap);
        }
    }
    
    private static int drop(int w, int[][] map) {
        int brokenBrickAmount = 0;
        
        Queue<Brick> queue = new LinkedList<>();
        for (int j=0; j<H; j++) {
            if (map[j][w] != 0) {
                queue.add(new Brick(j, w, map[j][w]));
                map[j][w] = 0;
                brokenBrickAmount++;
                break;
            }
        }
        
        //벽돌 폴발
        while (!queue.isEmpty()) {
            Brick brick = queue.poll();
            
            //y축 폭발
            for (int j=(-1) * (brick.range - 1); j<brick.range; j++) {
                if (brick.y + j < 0 || brick.y + j >= H || map[brick.y + j][brick.x] == 0) {
                    continue;
                }
                queue.add(new Brick(brick.y + j, brick.x, map[brick.y + j][brick.x]));
                map[brick.y + j][brick.x] = 0;
                brokenBrickAmount++;
            }
            //x축 폭발
            for (int i=(-1) * (brick.range - 1); i<brick.range; i++) {
                if (brick.x + i < 0 || brick.x + i >= W || map[brick.y][brick.x + i] == 0) {
                    continue;
                }
                queue.add(new Brick(brick.y, brick.x + i, map[brick.y][brick.x + i]));
                map[brick.y][brick.x + i] = 0; 
                brokenBrickAmount++;
            }
        }
        
        
        //빈 공간 떨어뜨리기
        for (int i=0; i<W; i++) {
            Queue<Integer> column = new LinkedList<>();
            for (int j=H-1; j>=0; j--) {
                if (map[j][i] == 0) {
                    continue;
                }
                column.add(map[j][i]);
            }
            
            for (int j=H-1; j>=0; j--) {
                if (column.isEmpty()) {
                    map[j][i] = 0;
                } else {
                    map[j][i] = column.poll();
                }
            }
        }
        
        return brokenBrickAmount;
    }
    
    private static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[H][W];
        for (int j=0; j<H; j++) {
            for (int i=0; i<W; i++) {
                copiedMap[j][i] = map[j][i];
            }
        }
        return copiedMap;
    }
    




}