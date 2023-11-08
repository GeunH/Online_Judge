import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int front = 0, rear = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                arr[rear++] = num;
            }
            if (command.equals("pop")) {
                if (front == rear)
                    System.out.println(-1);
                else
                    System.out.println(arr[front++]);
            }
            if (command.equals("size")) {
                System.out.println(rear - front);
            }
            if (command.equals("empty")) {
                if (rear - front == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            if (command.equals("front")) {
                if (rear == front)
                    System.out.println(-1);
                else
                    System.out.println(arr[front]);
            }
            if (command.equals("back")) {
                if (rear == front)
                    System.out.println(-1);
                else
                    System.out.println(arr[rear - 1]);
            }
        }
    }
}