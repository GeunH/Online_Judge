class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        else if (arr1.length < arr2.length)return -1;
        else {
            int sum1= 0;
            int sum2= 0;
            
            for(int element1 : arr1){
                sum1 += element1;
            }
            for(int element2 : arr2){
                sum2 += element2;
            }
            
            if( sum1 > sum2)return 1;
            if( sum2 > sum1)return -1;
        }
        return 0;
    }
}