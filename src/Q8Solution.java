import java.util.*;
import java.io.*;

public class Q8Solution {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        int k = 0;
        for(int i=2;i<=19;i++){
            if(N%i==0){
                k++;
                while(N%i==0){
                    N /= i;
                }
            }
        }
        System.out.println((1<<k)-1);
    }
}
