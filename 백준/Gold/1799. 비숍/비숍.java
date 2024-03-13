import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int [][]map;
	static boolean []diag;
	static boolean []reDiag;
	static int answer;
	
	static ArrayList<Position> []diags;
	
	static class Position{
		int y;
		int x;
		Position(int y,int x){
			this.y=y;
			this.x=x;
		}
	}
	
	static void nQueen(int diagNum, int queenNum) {
		boolean isFound = false;
		if ( answer < queenNum)answer =queenNum;
		if ( queenNum == 2*N-2)return;
		if( diagNum == 2*N-1) {
			return;
		}
		for(int i=0; i< diags[diagNum].size(); i++) {
			Position now = diags[diagNum].get(i);
			if( !diag[now.y+now.x] && !reDiag[ N-1 -now.y + now.x ]) {
				isFound=  true;
				diag[now.y+now.x] = reDiag[N-1 -now.y + now.x ]= true;
				nQueen(diagNum+1, queenNum+1);
				diag[now.y+now.x] = reDiag[ N-1 -now.y + now.x]= false;
			}
		}
		if(!isFound)nQueen(diagNum+1, queenNum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		diag = new boolean[2*N-1];
		diags = new ArrayList[2*N-1];
		reDiag = new boolean[2*N-1];
		
		for(int i=0; i< 2*N-1 ; i++) {
			diags[i] = new ArrayList<>();
		}
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			for(int j=0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					diags[i+j].add(new Position(i,j));
				}
			}
		}
		
		nQueen(0,0);
		System.out.println(answer);
	}
}
