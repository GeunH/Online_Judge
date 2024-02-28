import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int y, x, cost;
    
    public Node(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    
    static int[] dirY = { -1, 0, 1, 0 };
    static int[] dirX = { 0, 1, 0, -1 };
    
    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        distance[0][0] = map[0][0];
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int y = current.y;
            int x = current.x;
            
            if (visited[y][x]) continue;
            visited[y][x] = true;
            
            for (int i = 0; i < 4; i++) {
                int nextY = y + dirY[i];
                int nextX = x + dirX[i];
                
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N) {
                    if (distance[nextY][nextX] > distance[y][x] + map[nextY][nextX]) {
                        distance[nextY][nextX] = distance[y][x] + map[nextY][nextX];
                        pq.offer(new Node(nextY, nextX, distance[nextY][nextX]));
                    }
                }
            }
        }
        
        return distance[N-1][N-1];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        int cnt = 1;
        
        while (N != 0) {
            map = new int[N][N];
            distance = new int[N][N];
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            System.out.println("Problem " + cnt + ": " + dijkstra());
            cnt++;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
        }
    }
}
