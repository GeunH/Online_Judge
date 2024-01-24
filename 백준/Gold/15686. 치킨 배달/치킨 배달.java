import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Position{
	int y;
	int x;
	int cnt;
	Position(int y,int x, int cnt){
		this.y=y;
		this.x=x;
		this.cnt = cnt;
	}
}

public class Main {
	public static List<Position> list = new ArrayList<>();
	public static List<Position> house = new ArrayList<>();
	public static List<Position> realList = new LinkedList<>();
	public static int answer = Integer.MAX_VALUE;
	
	public static void makeDistance(int N,int M,int start,int cnt) {
		if(cnt == M) {
			int sum=0;
			for(int i=0; i< house.size();i++) {
				int distance = 2500;
				for(int j=0; j < realList.size();j++) {
					int nowDistance = Math.abs(house.get(i).y - realList.get(j).y)
							+ Math.abs(house.get(i).x - realList.get(j).x);
					if(distance >nowDistance){
						distance = nowDistance;
					}
				}
				sum += distance;
			}
			if ( answer > sum) answer =sum;
		}
		else {
			for(int i = start ; i < list.size(); i++) {
				Position now = list.get(i);
				realList.add(now);
				makeDistance(N,M,i+1,cnt+1);
				realList.remove(now);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0 ; i< N ;i++) {
			st = new StringTokenizer(reader.readLine(), " ");
			for(int j=0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 2) {
					list.add(new Position(i,j,0));
				}
				else if ( n == 1) {
					house.add(new Position(i,j,0));
				}
			}
		}
		
		makeDistance(N,M,0,0);
		System.out.println(answer);
	}
}
