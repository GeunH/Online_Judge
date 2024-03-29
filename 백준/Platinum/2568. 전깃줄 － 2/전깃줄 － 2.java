import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ELine lines[];
    static ELine[] arr;
    static int[] idx;
    static int[] prev; 
    static Set<Integer> hi;
    
    static class ELine {
        int src;
        int dest;
        ELine(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static int binarySearch(int i, int len) {
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (lines[i].dest < arr[mid].dest) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        arr[left] = lines[i];
        if (left > 0) prev[i] = idx[left - 1]; 
        idx[left] = i;
        if (left == len) len++;
        return len;
    }

    static void lis() {
        int len = 0;
        Arrays.fill(prev, -1); 
        for (int i = 0; i < N; i++) {
            len = binarySearch(i, len);
        }
        
        int cur = idx[len - 1];
        while (cur != -1) {
        	hi.remove(lines[cur].src);
            cur = prev[cur];
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(N-len);
        for( int a : hi) {
        	sb.append("\n").append(a);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hi = new TreeSet<>();
        
        lines = new ELine[N];
        arr = new ELine[N];
        idx = new int[N];
        prev = new int[N]; 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            lines[i] = new ELine(src, dest);
            hi.add(src);
        }
        Arrays.sort(lines, (o1, o2) -> Integer.compare(o1.src, o2.src));
        lis();
    }
}