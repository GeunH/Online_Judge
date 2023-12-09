import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int minNum = arr[0];
        for(int i : arr){
            if ( minNum > i)minNum = i;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for ( int i : arr){
            if( i != minNum) list.add(i);
        }
        if ( list.isEmpty() )return new int[]{ -1};
        return list.stream().mapToInt(i -> i).toArray();
    }
}