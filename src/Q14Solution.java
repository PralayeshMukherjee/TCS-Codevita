import java.io.*;
import java.util.*;
public class Q14Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String str = bf.readLine().trim();
        int occupied = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='O') occupied++;
        }
        int countO = 0;
        for(int i=0;i<occupied;i++){
            if(str.charAt(i)=='O'){
                countO++;
            }
        }
        int minSwap = occupied-countO;
        int times = 1;
        int i = occupied;
        while(i<str.length()){
            int rear = i-occupied;
            if(str.charAt(rear)=='O'){
                countO--;
            }
            if(str.charAt(i)=='O') countO++;
            if(minSwap>(occupied-countO)){
                times = 1;
                minSwap = occupied-countO;
            }else if(minSwap==(occupied-countO)){
                times++;
            }
            i++;
        }
        System.out.println(minSwap+" "+times);
    }
}
