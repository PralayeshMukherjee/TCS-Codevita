import java.util.*;
import java.io.*;
public class Q16Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(bf.readLine().trim());
            double sum = 0;
            String[] arr = bf.readLine().split(" ");
            for(int i=0;i<n;i++){
                sum += Double.parseDouble(arr[i]);
            }
            System.out.println(Math.round(sum));
        }
    }
}
