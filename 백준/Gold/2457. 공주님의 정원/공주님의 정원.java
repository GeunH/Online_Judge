import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Flower> flowers = new ArrayList<>();

    static class Flower implements Comparable<Flower> {
        int start, end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) return o.end - this.end; 
            return this.start - o.start; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;

            flowers.add(new Flower(start, end));
        }

        Collections.sort(flowers);

        int count = 0;
        int currentEnd = 301;
        int maxEnd = 301;
        int idx = 0;

        while (currentEnd <= 1130) {
            boolean updated = false;

            for (; idx < N && flowers.get(idx).start <= currentEnd; idx++) {
                if (flowers.get(idx).end > maxEnd) {
                    maxEnd = flowers.get(idx).end;
                    updated = true;
                }
            }

            if (!updated) { 
                break;
            }

            count++;
            currentEnd = maxEnd; 

            if (maxEnd > 1130) break;
        }

        if (currentEnd <= 1130) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}
