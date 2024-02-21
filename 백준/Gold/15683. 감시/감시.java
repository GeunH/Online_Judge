import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copymap;
    static int[][][] dirY = {
        {{0}, {-1}, {0}, {1}},
        {{0, 0}, {1, -1}},
        {{-1, 0}, {0, 1}, {1, 0}, {0, -1}},
        {{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {1, 0, -1}},
        {{-1, 0, 1, 0}}
    };
    static int[][][] dirX = {
        {{1}, {0}, {-1}, {0}},
        {{1, -1}, {0, 0}},
        {{0, 1}, {1, 0}, {0, -1}, {-1, 0}},
        {{-1, 0, 1}, {0, 1, 0}, {1, 0, -1}, {0, -1, 0}},
        {{0, 1, 0, -1}}
    };
    static List<CCTV> cctvs = new ArrayList<>();
    static int answer;
    static int[] dirs;

    static class CCTV {
        int y, x, num;
        CCTV(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }

    static void runCCTV() {
    	int cnt = 0;
        for (CCTV cctv : cctvs) {
            int y = cctv.y;
            int x = cctv.x;
            int num = cctv.num;
            for (int j = 0; j < dirY[num][dirs[cnt]].length; j++) {
            	
                int nextY = y + dirY[num][dirs[cnt]][j];
                int nextX = x + dirX[num][dirs[cnt]][j];
                while (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && copymap[nextY][nextX] != 6) {
                    if (copymap[nextY][nextX] == 0) {
                        copymap[nextY][nextX] = -1; 
                    }
                    nextY += dirY[num][dirs[cnt]][j];
                    nextX += dirX[num][dirs[cnt]][j];
                }
            }
            cnt++;
        }
    }

    static void makeCCTV(int cnt) {
        if (cnt == cctvs.size()) {
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copymap[i], 0, M);
            }
            runCCTV();
            int unwatched = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copymap[i][j] == 0) {
                        unwatched++;
                    }
                }
            }
            answer = Math.min(answer, unwatched);
            return;
        }
        int num = cctvs.get(cnt).num;
        int maxCnt = (num == 1) ? 2 : (num == 4) ? 1 : 4; 
        for (int i = 0; i < maxCnt; i++) {
            dirs[cnt] = i;
            makeCCTV(cnt + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copymap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new CCTV(i, j, map[i][j] - 1));
                }
            }
        }
        answer = Integer.MAX_VALUE;
        dirs = new int[cctvs.size()];
        makeCCTV(0);
        System.out.println(answer);
    }
}
