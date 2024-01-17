import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
       String line = reader.readLine();
       
       String[] words = new String[line.length()];
       
       for(int i=0; i< words.length ; i++) {
    	   words[i] = line.substring(i);
       }
       
       Arrays.sort(words);
       for(int i=0; i< words.length; i++) {
    	   System.out.println(words[i]);
       }
    }
}
