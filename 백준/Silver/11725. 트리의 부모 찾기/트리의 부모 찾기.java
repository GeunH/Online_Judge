import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int parentNum[] = new int[100001];
	public static ArrayList<Integer>[]list;
	public static boolean isCheck[] = new boolean[100001];
	
	public static void findChild(int parent) {
		for( int i=0; i< list[parent].size(); i++) {
			int child = list[parent].get(i);
			if( !isCheck[child]) {
				parentNum[child] = parent;
				isCheck[child] = true;
				findChild(child);
			}
		}
	}

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    list = new ArrayList[N+1];
	    for(int i=0; i<= N ;i++) {
	    	list[i] =new ArrayList<>();
	    }
	    
	    for(int i=0; i< N-1; i++) {
	    	st = new StringTokenizer(br.readLine(), " ");
	    	int start = Integer.parseInt(st.nextToken());
	    	int end = Integer.parseInt(st.nextToken());
	    	
	    	list[start].add(end);
	    	list[end].add(start);
	    }
	    isCheck[1] = true;
	    findChild(1);
	    StringBuilder sb = new StringBuilder("");
	    for(int i=2 ; i<=N ;i++) {
	    	sb.append(parentNum[i]);
	    	if( i < N)sb.append('\n');
	    }
	    System.out.println(sb);
	}
}