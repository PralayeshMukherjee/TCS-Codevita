import java.io.*;
import java.util.*;

public class Q9Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        String[] inputs = bf.readLine().split(" ");
        long sum = 0;
        for(int i=0;i<N;i++){
            long x = Long.parseLong(inputs[i].trim());
            String str = Long.toString((long)Math.pow(2,x));
            if(str.length()>2){
                str = str.substring(str.length()-2);
            }
            sum += Long.parseLong(str);
        }
        System.out.println(sum%100);
    }
}
