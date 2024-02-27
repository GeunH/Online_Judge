import java.util.*;
import java.io.*;
public class Main {
	static int N,M,K,X;
	
	static ArrayList<Integer> []lists;

	static boolean isVisit[];
	
	static class City{
		int num;
		int w;
		City(int num, int w){
			this.num =num;
			this.w=w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine(), " " );
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N+1];
		isVisit = new boolean[N+1];
		for(int i= 1 ; i <= N; i++) {
			lists[i]= new ArrayList<>();
		}
		
		for(int i=0; i< M; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int src= Integer.parseInt(st.nextToken());
			int dest =Integer.parseInt(st.nextToken());
			
			lists[src].add(dest);
		}
		
		Queue <City> queue = new LinkedList<>();
		queue.offer(new City(X,0));
		isVisit[X]= true;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(!queue.isEmpty()) {
			City city = queue.poll();
			int now = city.num;
			int distance = city.w;
			if(distance == K) {
				pq.offer(now);
			}
			for(int i=0 ; i < lists[now].size(); i++) {
				if( !isVisit[lists[now].get(i)]) {
					isVisit[lists[now].get(i)] = true;
					queue.offer(new City(lists[now].get(i), distance+1));
				}
			}
		}
		
		if(pq.isEmpty())System.out.println(-1);
		else {
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
		}
	}
}