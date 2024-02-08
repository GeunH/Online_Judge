import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    
    static int [][] lists;
    static int people[];
    static boolean isVisit[];
    
    static int city[];
    static int total;
    static int answer = Integer.MAX_VALUE;
    
    static boolean isSelectedLinked(int selNum) {
    	int cnt =0;
    	boolean isCheck[] = new boolean[N+1];
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i=1 ;i<= N;i++) {
    		if ( isVisit[i]) {
    			queue.add(i);
    			isCheck[i]= true;
    			break;
    		}
    	}
    	while(!queue.isEmpty()) {
    		int now =queue.poll();
    		cnt++;
    		for( int city : lists[now]) {
    			if( !isCheck[city] && isVisit[city] ) {
    				isCheck[city] = true;
    				queue.offer(city);
    			}
    		}
    	}
    	if( cnt == selNum)return true;
    	return false;
    }
    static boolean isUnSelecedLinked(int unSelNum) {
    	int cnt =0;
    	boolean isCheck[] = new boolean[N+1];
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i=1 ;i<= N;i++) {
    		if ( !isVisit[i]) {
    			queue.add(i);
    			isCheck[i]= true;
    			break;
    		}
    	}

    	while(!queue.isEmpty()) {
    		int now =queue.poll();
    		cnt++;
    		for( int city : lists[now]) {
    			if( !isCheck[city] && !isVisit[city] ) {
    				isCheck[city] = true;
    				queue.offer(city);
    			}
    		}
    	}
    	if( cnt == unSelNum)return true;
    	return false;
    }
    
    static void subset(int cnt, int tot, int selNum) {
    	if(cnt == N) {
    		if ( selNum == 0 || selNum == N) {
    			return;
    		}
    		if( isSelectedLinked(selNum) && isUnSelecedLinked(N-selNum)) {
    			if ( Math.abs(tot - (total - tot)) <answer  ) {
        			answer = Math.abs(tot - (total - tot));
        		}
    		}
    		return;
    	}
    	isVisit[cnt+1] = true;
    	city[cnt] = cnt+1;
    	subset(cnt+1, tot+ people[cnt+1], selNum+1);
    	city[cnt] = 0;
    	isVisit[cnt+1] = false;
    	subset(cnt+1, tot, selNum);
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        
        lists = new int[N+1][];
        people = new int[N+1];
        isVisit = new boolean[N+1];
        city = new int[N];
        
        
        st = new StringTokenizer(br.readLine(), " " );
        for(int i=1 ; i <= N; i++ ) {
        	people[i] = Integer.parseInt(st.nextToken());
        	total += people[i];
        }
        
        for(int i=1; i<= N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int cities = Integer.parseInt(st.nextToken());
        	lists[i] = new int[cities];
        	for(int j= 0; j < cities; j++) {
        		int cityNum = Integer.parseInt(st.nextToken());
        		lists[i][j] = cityNum;
        	}
        }
        subset(0,0,0);
        if(answer == Integer.MAX_VALUE)answer = -1;
        System.out.println(answer);
    }
}
