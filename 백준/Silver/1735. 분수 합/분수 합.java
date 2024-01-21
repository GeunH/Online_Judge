import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		
		int firstHead = Integer.parseInt(st.nextToken());
		int firstTail = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(reader.readLine(), " ");
		
		int secondHead = Integer.parseInt(st.nextToken());
		int secondTail = Integer.parseInt(st.nextToken());
		
		int answerHead = firstHead*secondTail  + secondHead*firstTail;
		int answerTail = firstTail * secondTail;
		
		for( int i= answerHead ; i > 1; i--) {
			if( answerHead % i == 0 && answerTail % i == 0) {
				answerHead /=i;
				answerTail /=i;
			}
		}
		System.out.println(answerHead + " " + answerTail);
	}

}
