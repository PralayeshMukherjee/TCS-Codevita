import java.util.*;
import java.io.*;
public class Q17Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        String[] inputs = bf.readLine().split(" ");
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (String input : inputs) {
            pq.add(Integer.parseInt(input));
        }
        while(K-->0){
            int maxi = pq.poll();
            maxi /=2;
            pq.add(maxi);
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        System.out.println(sum);
    }
}
