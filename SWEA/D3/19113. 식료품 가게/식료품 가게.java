import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int []items = new int[N*2];
            boolean [] check = new boolean[N*2];
            for(int i=0; i< N*2;i ++){
            	items[i] = sc.nextInt();
            }
            Arrays.sort(items);
            for(int i=0; i< 2*N - 1 ; i++){
            	for(int j=i+1 ; j < N*2; j++){
                	if ( items[j] == items[i]/3*4 && !check[j] && !check[i]){
                    	check[j] = true;
                        break;
                    }
                }
            }
            
            System.out.print("#" + test_case+ " ");
            for(int i=0; i< N*2; i++){
            	if( !check[i]){
                    System.out.print(items[i] + " " );
                }
            }
            System.out.println();
        }	
	}
}