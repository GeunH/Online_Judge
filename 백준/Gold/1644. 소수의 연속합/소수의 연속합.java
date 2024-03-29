import java.io.*;
import java.util.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> prime = getPrimes(N); // 소수 리스트
        
        int[] arr = prime.stream().mapToInt(i -> i).toArray(); // List<Integer>를 int[]로 변환
        int start = 0, end = 0, sum = 0, answer = 0;

        while (true) {
            if (sum >= N) sum -= arr[start++]; 
            else if (end == arr.length) break; 
            else sum += arr[end++]; 

            if (sum == N) answer++;
        }

        System.out.println(answer);
    }

    static List<Integer> getPrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();
        
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return primes;
    }
}