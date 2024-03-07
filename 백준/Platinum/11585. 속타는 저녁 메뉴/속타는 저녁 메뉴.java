import java.util.*;
import java.io.*;

/*
 	원본 문자열을 하나씩 뒤로 밀면서 
 */

class Main
{
	static int p[],answer;
	static StringBuilder content;
	static StringBuilder word; 
	
	static void getPi() {
		int j = 0;		
		for(int i = 1 ; i< word.length() ; i++) {
			while( j > 0 && word.charAt(i) != word.charAt(j)) {
				j = p[j-1];
			}
			if ( word.charAt(i) == word.charAt(j)) {
				p[i] = ++j;
			}
		}
	}
	
	static void kmp() {
		int j= 0;
		getPi();
		
		for(int i = 0 ; i< content.length(); i++) {
			while( j > 0 && content.charAt(i) != word.charAt(j)) {
				j = p[j-1];
			}
			if ( content.charAt(i) == word.charAt(j)) {
				if( j == word.length() - 1) {
					answer++;
					j = p[j];
				}
				else {
					++j;
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " " );
		int N = Integer.parseInt(st.nextToken());
		answer = 0;
		
		content = new StringBuilder("");
		word = new StringBuilder("");
		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreElements()) {
			content.append(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " " );
		while(st.hasMoreElements()) {
			word.append(st.nextToken());
		}
		p = new int[word.length()];
		content.append(content.toString());
		content.deleteCharAt(content.length()-1);
		kmp();
		
		for(int i=answer ; i > 1; i--) {
			if( answer % i == 0 && N % i == 0) {
				N/=i;
				answer/=i;
			}
		}
		System.out.println(answer+ "/" + N);
	}
}