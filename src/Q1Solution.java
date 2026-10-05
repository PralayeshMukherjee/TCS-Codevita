import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Q1Solution {
    public static String intToEng(int n){
        String[] ones = {
                "","one","two","three","four","five",
                "six","seven","eight","nine","ten",
                "eleven","twelve","thirteen","fourteen",
                "fifteen","sixteen","seventeen","eighteen",
                "nineteen"
        };
        String[] tens = {
                "","","twenty","thirty","forty","fifty",
                "sixty","seventy","eighty","ninety"
        };
        if(n>=1&&n<=19){
            return ones[n];
        }
        if(n>=20 && n<=99){
            return tens[n/10]+(n%10==0?"":ones[n%10]);
        }
        if(n==100) return "hundred";
        return "";
    }
    public static int calD(String str){
        int ch = str.charAt(0)-'0';
        int count = 0;
        String english = intToEng(ch);
        for(char c:english.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') count++;
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = bf.readLine().charAt(0)-'0';
        String[] str = bf.readLine().split(" ");
        int d = 0;
        for(int i=0;i<str.length;i++){
            d+= calD(str[i]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(str[i].charAt(0)-'0');
        }
        int result = 0;
        for(int i=0;i<n;i++){
            int temp = d-(str[i].charAt(0)-'0');
            set.remove((str[i].charAt(0)-'0'));
            if(set.contains(temp)){
                result++;
            }
        }
        System.out.println(intToEng(result));
    }
}
