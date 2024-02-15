import java.io.*;
import java.util.*;

public class Main {        
	static String first;
	static String second;
    
	static Text[][] texts;
	
	static class Text{
		int cnt;
		String text;
		Text(int cnt, String text){
			this.cnt= cnt;
			this.text =text;
		}
	}
	
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        first = st.nextToken();
        st = new StringTokenizer(br.readLine(), " ");
        second= st.nextToken();
        
        texts = new Text[first.length()+1][second.length()+1];
       
        for(int i=0; i<= first.length() ; i++) {
        	texts[i][0] = new Text(0,"");
        }
        for(int j=0; j<= second.length(); j++) {
        	texts[0][j] = new Text(0,"");
        }
        
        for(int i=1; i <= first.length(); i++) {
        	for(int j=1; j<= second.length() ;j++) {
        		if(first.charAt(i-1) == second.charAt(j-1)) {
        			if( texts[i-1][j-1].cnt + 1 > texts[i][j-1].cnt) {
        				texts[i][j] = new Text(texts[i-1][j-1].cnt+1, texts[i-1][j-1].text+ first.charAt(i-1) );
        			}
        			else {
        				texts[i][j] =  texts[i][j-1];
        			}
        		}
        		else {
        			if( texts[i-1][j].cnt > texts[i][j-1].cnt) {
        				texts[i][j] = texts[i-1][j];
        			}
        			else {
        				texts[i][j] = texts[i][j-1];
        			}
        		}
        	}
        }
        System.out.println(texts[first.length()][second.length()].cnt+"\n"+texts[first.length()][second.length()].text);
        
    }
}
