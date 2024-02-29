import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static ArrayList<Edge>[] edges;
    static boolean[] isVisited;
    static int maxDistance;
    static int farthestNode;

    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void dfs(int node, int distance) {
        isVisited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Edge edge : edges[node]) {
            if (!isVisited[edge.dest]) {
                dfs(edge.dest, distance + edge.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        edges = new ArrayList[V + 1];
        isVisited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                int dest = Integer.parseInt(st.nextToken());
                if (dest == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                edges[num].add(new Edge(dest, weight));
                edges[dest].add(new Edge(num, weight));
            }
        }

        maxDistance = 0;
        dfs(1, 0);

        Arrays.fill(isVisited, false);
        maxDistance = 0;

        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }
}
