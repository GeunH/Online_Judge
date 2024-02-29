import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int nums[];
    static int p[];
    static boolean isVisit[];

    static Set<String> answer = new TreeSet<>();
    static StringBuilder sbb = new StringBuilder("");
    static void perm(int cnt) {
    	if( cnt ==M ) {
    		StringBuilder sb= new StringBuilder("");
    		for(int i=0; i< M; i++) {
    			sb.append(p[i]+ " ");
    		}
    		if( !answer.contains(sb.toString())) {
    			answer.add(sb.toString());
    			sbb.append(sb.toString()+"\n");
    		}

    		return;
    	}
    	for(int i=0; i< N; i++) {
    		if(!isVisit[i]) {
    			isVisit[i]= true;
    			p[cnt] = nums[i];
        		perm(cnt+1 );
        		isVisit[i]= false;
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisit = new boolean[N];
        nums = new int[N];
        p = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        perm(0);

        System.out.println(sbb.toString());
    }
}
