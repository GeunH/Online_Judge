import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static PriorityQueue<Meeting> pq;
    static Meeting meetings[];
    
    static class Meeting implements Comparable<Meeting>{
    	int start;
    	int end;
    	Meeting(int start, int end){
    		this.start =start;
    		this.end = end;
    	}
    	
		@Override
		public int compareTo(Meeting o) {
			if ( o.start > this.start )return -1;
			else if (o.start == this.start) return 0;
			return 1;
		}
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        meetings = new Meeting[N];
      
        pq = new PriorityQueue<>();
       
        for(int i=0; i< N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	meetings[i] = new Meeting(start,end);
        }
        int [] rooms = new int[N];
        Arrays.sort(meetings);
        int answer = 1;
        rooms[0] = meetings[0].end;
        loop:
        for(int i=1; i< N; i++) {
        	for(int j= 0; j< answer; j++) {
        		if( meetings[i].start >= rooms[j] ) {
        			rooms[j] = meetings[i].end;
        			continue loop;
        		}
        	}
        	rooms[answer++] = meetings[i].end; 
        }
        System.out.println(answer);
    }
}
