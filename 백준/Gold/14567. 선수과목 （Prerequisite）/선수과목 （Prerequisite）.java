import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static List<Integer> []list;
	
	static int semester[];
	
	static class Subject{
		int cnt;
		int num;
		
		Subject(int num,int cnt){
			this.cnt=cnt;
			this.num=num;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		semester = new int[N+1];	
		for(int i=1 ; i <= N; i++) {
			list[i] = new ArrayList<>();
			semester[i] = 1;
		}
		
		for(int i=0; i< M; i++) {
			st =new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			list[f].add(s);
		}
		
		
		for(int i=1 ;i <= N; i++) {
			for(int j=0; j< list[i].size(); j++) {
				semester[list[i].get(j)] = Math.max(semester[list[i].get(j)],semester[i]+1);
			}
		}
		

		StringBuilder sb= new StringBuilder("");
		for(int i=1; i<= N; i++) {
			sb.append(semester[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}