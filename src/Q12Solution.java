import java.io.*;
import java.util.*;

public class Q12Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String str = bf.readLine().trim();
        int a = 0;
        int b = 0;
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch=='A'){
                a++;
            }else if(ch=='B') {
                b++;
            }
        }
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch!='-'){
                continue;
            }
            int distA = Integer.MAX_VALUE;
            int distB = Integer.MAX_VALUE;
            for(int j=i+1;j<n;j++){
                if(str.charAt(j)=='A'){
                    distA = j-i;
                    break;
                }
            }
            for(int j=i-1;j>=0;j--){
                if(str.charAt(j)=='B'){
                    distB = i-j;
                    break;
                }
            }
            if(distA<distB){
                a++;
            }else if (distB<distA){
                b++;
            }
        }
        if(a>b){
            System.out.println('A');
        }else if(b>a){
            System.out.println('B');
        }else{
            System.out.println("Coalition Government");
        }
    }
}
