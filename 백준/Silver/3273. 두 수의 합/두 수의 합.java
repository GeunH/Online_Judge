import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String line = reader.readLine();
               
        line = reader.readLine();
        StringTokenizer elements = new StringTokenizer(line, " ");

        Map<Integer, Integer> cnt = new HashMap<>();
        
        List<Integer> tokens = new ArrayList<>();

        int answer= 0 ;
        while( elements.hasMoreTokens())
        {
        	String token = (String) elements.nextElement();
        	int key = Integer.parseInt(token);
        	tokens.add(key);
        	cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }
        
        int[] nums = new int[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            nums[i] = tokens.get(i);
        }
        
        
        int x = Integer.parseInt(reader.readLine());
        
        for(int i=0; i <nums.length; i++) {
        	if(x-nums[i] != nums[i] && cnt.getOrDefault(x-nums[i], 0) != 0) {
        		cnt.put(x-nums[i], 0);
        		cnt.put(nums[i], 0);
        		answer++;
        	}
        }
        System.out.println(answer);
    }
}
