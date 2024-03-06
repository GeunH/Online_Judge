import java.util.*;
import java.io.*;

/*
 minHeap에 중간값보다 작은 값들.
 maxHeap에 중간값보다 큰 값들.
 중간값 확인을 어떻게 할까??
*/

public class Main {
	static int N;
	static PriorityQueue<Integer> minheap;		
	static PriorityQueue<Integer> maxheap;		
	static void addToMinHeap(int a) {
		minheap.offer(a);
	}
	static int deleteFromMinHeap() {
		int delNum = minheap.poll();
		while( minCnt.get(delNum) != null && minCnt.get(delNum) > 0) {
			minCnt.put(delNum, minCnt.get(delNum)-1);
			delNum = minheap.poll();
		}
		return delNum;
	}
	static void addToMaxHeap(int a) {
		maxheap.offer(a);
	}
	static int deleteFromMaxHeap() {
		int delNum = maxheap.poll();
		while( maxCnt.get(delNum) != null && maxCnt.get(delNum) > 0) {
			maxCnt.put(delNum, maxCnt.get(delNum)-1);
			delNum = maxheap.poll();
		}
		return delNum;
	}
	
	static Map<Integer,Integer> maxCnt;
	static Map<Integer,Integer> minCnt;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			maxCnt = new HashMap<>();
			minCnt = new HashMap<>();
			minheap = new PriorityQueue<>((o1,o2)->{
				if( o1 > o2)return 1;
				else if ( o1 == o2)return 0;
				else return -1;
			});
			maxheap = new PriorityQueue<>((o1,o2)->{
				if( o2 > o1)return 1;
				else if ( o1 == o2)return 0;
				else return -1;
			});	
			int size = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			for(int i=0; i< N; i++) {
				st = new StringTokenizer(br.readLine(), " " );
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if( command == 'D') {
					if( size == 0)continue;
					size--;
					if( num == -1) {
						int delNum = deleteFromMinHeap();
						if( maxCnt.get(delNum) == null) {
							maxCnt.put(delNum, 1);
						}
						else {
							maxCnt.put(delNum, maxCnt.get(delNum)+1);	
						}
					}
					else if ( num == 1) {
						int delNum = deleteFromMaxHeap();
						if( minCnt.get(delNum) == null) {
							minCnt.put(delNum, 1);
						}
						else {
							minCnt.put(delNum, minCnt.get(delNum)+1);	
						}
					}
				}
				else if ( command == 'I') {
					addToMinHeap(num);
					addToMaxHeap(num);
					size++;
				}
			}
			if( size == 0)System.out.println("EMPTY");
			else System.out.println(deleteFromMaxHeap() + " " + deleteFromMinHeap());
		}	
	}

}
