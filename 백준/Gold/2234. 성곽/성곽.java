import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    
    static int map[][];
    
    static int dirY[] = new int[] {0,-1,0,1};
    static int dirX[] = new int[] {-1,0,1,0};
    
    static class Pos{
    	int r;
    	int c;
    	Pos(int r,int c){
    		this.r=r;
    		this.c=c;
    	}
    }
    
    static class Link{
    	int src;
    	int dest;
    	Link(int rsc, int dest){
    		this.src = rsc;
    		this.dest =dest;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    	    if (this == obj) return true;
    	    if (obj == null || getClass() != obj.getClass()) return false;
    	    Link link = (Link) obj;
    	    return src == link.src && dest == link.dest;
    	}

    	@Override
    	public int hashCode() {
    	    return Objects.hash(src, dest);
    	}

    }
    
    static void bfs() {
    	boolean isVisit[][] = new boolean[M][N];
    	
    	int roomNum[][] = new int[M][N]; 
    	Queue<Pos> queue= new LinkedList<>();
    	
    	List<Integer> room = new ArrayList<>();
    	
    	Set<Link> links = new HashSet<>();
    	
    	int maxSize=0;
    	for(int i=0; i < M; i++ ) {
    		for(int j=0; j < N ;j++ ) {
    			if( !isVisit[i][j]) {
    				int cnt= 1;
    				queue.offer(new Pos(i,j));
    				isVisit[i][j] = true;
    				while(!queue.isEmpty()) {
    					Pos now = queue.poll();
    					roomNum[now.r][now.c]= room.size()+1; 
    					for(int k=0; k< 4; k++) {
    						int nextR = now.r + dirY[k];
    						int nextC = now.c + dirX[k];
    						
    						if( nextR>=0 && nextR < M && nextC >=0 && nextC< N) {
    							if ( !isVisit[nextR][nextC] && (map[now.r][now.c]&(1<<k)) == 0 ) {
    								isVisit[nextR][nextC]= true;
        							queue.offer(new Pos(nextR,nextC));
        							cnt++;
    							}
    							else if( roomNum[i][j] != roomNum[nextR][nextC] && roomNum[nextR][nextC] != 0) {
    								links.add(new Link(roomNum[i][j], roomNum[nextR][nextC]));
    							}
    						}
    					}
    				}
    				if ( cnt > maxSize)maxSize= cnt;
    				room.add(cnt);
    			}
    		}
    	}

    	System.out.println(room.size());
    	System.out.println(maxSize);
    	int answer =0 ;
    	for(Link link : links) {
    		int f = link.src-1;
    		int s = link.dest-1;
    		if (room.get(f) + room.get(s) > answer) {
    			answer= room.get(f) + room.get(s);
    		}
    	}
    	System.out.println(answer);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        
        for(int i=0; i< M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0 ; j< N ;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        bfs();
    }
}