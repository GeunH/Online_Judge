import java.util.Scanner;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        StringBuilder sb = new StringBuilder(a+b);
        System.out.println(sb.toString());
    }
}