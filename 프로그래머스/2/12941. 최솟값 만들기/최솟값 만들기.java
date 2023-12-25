import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int minNum =0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i< A.length ; i++){
            minNum += A[i] * B[A.length- i-1];
        }
        
        return minNum;
    }
}