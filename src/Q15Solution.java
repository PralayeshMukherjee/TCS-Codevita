import java.util.*;
import java.io.*;
class PairTrain{
    int arrival;
    int departure;
    public PairTrain(int arrival,int departure){
        this.arrival = arrival;
        this.departure = departure;
    }
}
public class Q15Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        int[] arrivals = new int[N];
        int[] departure = new int[N];
        for(int i=0;i<N;i++){
            String[] str = bf.readLine().split(" ");
            arrivals[i] = Integer.parseInt(str[0]);
            departure[i] = Integer.parseInt(str[1])+arrivals[i];
        }
        Arrays.sort(arrivals);
        Arrays.sort(departure);
        // [5,10,13]
        // [12,15,18]
        int i = 0,j = 0;
        int min = 0;
        int count = 0;
        while(i<N && j<N){
            if(arrivals[i]<departure[j]){
                i++;
                count++;
            }else{
                j++;
                count--;
            }
            min = Math.max(count,min);
        }
        System.out.println(min);
    }
}
