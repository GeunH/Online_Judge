import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String line = reader.readLine();

        int []cnt = new int[10];
        
        char [] numbers = line.toCharArray();
        
        for(int i=0 ; i< numbers.length ;i++){
            cnt[numbers[i]-'0']++;
            if ( numbers[i] - '0' == 6 && cnt[6] > cnt[9]) {
            	cnt[9]++;
            	cnt[6]--;
            }
            else if ( numbers[i] - '0' == 9 && cnt[9] > cnt[6] ) {
            	cnt[6]++;
            	cnt[9]--;
            }
        }
        
        int need = 1;
        for(int i=0; i< 10 ; i++) {
        	if( need < cnt[i] )need = cnt[i];
        }
        
        System.out.println(need);
    }
}
