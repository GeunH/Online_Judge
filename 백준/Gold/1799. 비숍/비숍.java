import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int [][]map;
	static boolean []diag;
	static boolean []reDiag;
	static int answerW;
	static int answerB;
	
	static ArrayList<Position> []wdiags;
	static ArrayList<Position> []bdiags;
	
	static class Position{
		int y;
		int x;
		Position(int y,int x){
			this.y=y;
			this.x=x;
		}
	}
	
	static void nQueenW(int diagNum, int queenNum) {
		boolean isFound = false;
		if ( answerW < queenNum)answerW =queenNum;
		if( diagNum == N) {
			return;
		}
		for(int i=0; i< wdiags[diagNum].size(); i++) {
			Position now = wdiags[diagNum].get(i);
			if( !diag[now.y+now.x] && !reDiag[ N-1 -now.y + now.x ]) {
				isFound=  true;
				diag[now.y+now.x] = reDiag[N-1 -now.y + now.x ]= true;
				nQueenW(diagNum+1, queenNum+1);
				diag[now.y+now.x] = reDiag[ N-1 -now.y + now.x]= false;
			}
		}
		if(!isFound)nQueenW(diagNum+1, queenNum);
	}
	
	static void nQueenB(int diagNum, int queenNum) {
		boolean isFound = false;
		if ( answerB < queenNum)answerB =queenNum;
		if( diagNum == N) {
			return;
		}
		for(int i=0; i< bdiags[diagNum].size(); i++) {
			Position now = bdiags[diagNum].get(i);
			if( !diag[now.y+now.x] && !reDiag[ N-1 -now.y + now.x ]) {
				isFound=  true;
				diag[now.y+now.x] = reDiag[N-1 -now.y + now.x ]= true;
				nQueenB(diagNum+1, queenNum+1);
				diag[now.y+now.x] = reDiag[ N-1 -now.y + now.x]= false;
			}
		}
		if(!isFound)nQueenB(diagNum+1, queenNum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		diag = new boolean[2*N-1];
		wdiags = new ArrayList[N];
		bdiags = new ArrayList[N];
		reDiag = new boolean[2*N-1];
		
		for(int i=0; i< N ; i++) {
			wdiags[i] = new ArrayList<>();
			bdiags[i] = new ArrayList<>();
		}
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			for(int j=0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1 && (i+j)%2 ==0) {
					wdiags[(i+j)/2].add(new Position(i,j));
				}
				if(map[i][j] == 1 && (i+j)%2 ==1) {
					bdiags[(i+j)/2].add(new Position(i,j));
				}
			}
		}
		
		nQueenW(0,0);
		nQueenB(0,0);
		System.out.println(answerW+answerB);
	}
}
