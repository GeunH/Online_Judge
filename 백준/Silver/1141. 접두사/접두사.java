import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String[] words;

	static int answer =0 ;	
	static List<String> list = new ArrayList<>();
	
	static void check() {
		for(int i=0; i< list.size()-1 ; i++){
			for(int j= i+1 ; j < list.size(); j++) {
				if( list.get(j).substring(0, list.get(i).length()).equals(list.get(i))) {
					list.remove(i); 
					i--;
					break;
				}
			}
		}
	}	
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());

        words = new String[N];
        for(int i=0; i< N ; i++) {
        	words[i] = br.readLine();
        }
        Arrays.sort(words, (o1,o2)-> o1.length() - o2.length());
        for(int i=0; i< N; i++) {
        	list.add(words[i]);
        }
        check();
        
        System.out.println(list.size());
    }
}
