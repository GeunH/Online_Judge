import java.io.*;
import java.util.*;

public class Main {
	static int []y;
	static int []x;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st;
        
        y = new int[3];
        x = new int[3];
        
        for(int i=0; i<3 ;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	x[i] = Integer.parseInt(st.nextToken());
        	y[i] = Integer.parseInt(st.nextToken());
        }
      
        
        double s = 1.0*(x[1] - x[0])*(y[2] - y[1]) - 1.0*(y[1] -y[0])*(x[2] - x[1]);
        if ( s > 0) {
        	System.out.println(1);
        }
        else if ( s == 0) {
        	System.out.println(0);
        }
        else {
        	System.out.println(-1);
        }
    }
}
