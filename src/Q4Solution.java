import java.util.*;
import java.io.*;

public class Q4Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int count = 0;
        String[] elements = bf.readLine().split(" ");
        int[] intElements = new int[N];
        for(int i=0;i<elements.length;i++){
            intElements[i] = Integer.parseInt(elements[i]);
        }
        Arrays.sort(intElements);
        for(int i=1;i<elements.length;i++){
            int temp = Math.abs(intElements[i-1]
                    - intElements[i]);
            if(temp<K){
                if(i==1) count++;
                count++;
            }
        }
        System.out.println(count);
    }
}
