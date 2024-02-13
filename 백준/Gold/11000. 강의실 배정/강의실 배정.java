import java.io.*;
import java.util.*;

public class Main {        
    static int N;
    static PriorityQueue<Integer> pq;
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
			if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
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
        Arrays.sort(meetings);

        pq.offer(meetings[0].end);
        for(int i=1; i< N; i++) {
        	if(pq.peek() <= meetings[i].start) {
        		pq.poll();
        	}
        	pq.offer(meetings[i].end);
        }
        System.out.println(pq.size());
    }
}
