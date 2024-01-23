import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
public class Main {
	public static char[][] map;
	
	public static void star(int r, int c, int N) {
	    if (N == 3) {
	        makeStar(r, c);
	        return;
	    }
	    
	    int size = N / 3;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (i == 1 && j == 1) continue; 
	            star(r + i * size, c + j * size, size);
	        }
	    }
	}


	public static void makeStar(int r, int c) {
	    map[r][c] = '*';
	    map[r][c + 1] = '*';
	    map[r][c + 2] = '*';
	    map[r + 1][c] = '*';
	    map[r + 1][c + 2] = '*';
	    map[r + 2][c] = '*';
	    map[r + 2][c + 1] = '*';
	    map[r + 2][c + 2] = '*';
	}

	public static void print(int N) {
		for(int i=0; i < N; i++) {
			System.out.println(String.valueOf(map[i]));
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
	
		int N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], ' ');
		}
		star(0,0,N);
		
		print(N);
	}

}
