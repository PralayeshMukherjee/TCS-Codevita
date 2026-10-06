import java.io.*;
import java.util.*;

//class Pair2{
//    int minRange;
//    int maxRange;
//    public Pair2(int minRange,int maxRange){
//        this.minRange = minRange;
//        this.maxRange = maxRange;
//    }
//}
//public class Q3Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = bf.readLine().split(" ");
//        int S = Integer.parseInt(input[0]);
//        int R = Integer.parseInt(input[1]);
//        String[] SAre = bf.readLine().split(" ");
//        List<Pair2> list = new ArrayList<>();
//        for(int i=0;i<R;i++){
//            String[] RAre = bf.readLine().split(" ");
//            int minRange = Integer.parseInt(RAre[0]);
//            int maxRange = Integer.parseInt(RAre[1]);
//            Pair2 pair2 = new Pair2(minRange,maxRange);
//            list.add(pair2);
//        }
//        int[] result = new int[R];
//        Arrays.fill(result,0);
//        for(int i=0;i<SAre.length;i++){
//            int stone = Integer.parseInt(SAre[i]);
//            for(int j=0;j<R;j++){
//                int minRange = list.get(j).minRange;
//                int maxRange = list.get(j).maxRange;
//                if(minRange<=stone && stone<=maxRange){
//                    result[j]++;
//                    break;
//                }
//            }
//        }
//        for(int i=0;i<R-1;i++){
//            System.out.print(result[i]+" ");
//        }
//        System.out.print(result[result.length-1]);
//    }
//}


//the above is the O(N^2) approach which doesn't get accepted

//below approach will be accepted because its time complexity is O(S+1001+R)

public class Q3Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int[] freq = new int[1001];
        String[] samples = bf.readLine().split(" ");
        for(int i=0;i<S;i++){
            int sample = Integer.parseInt(samples[i]);
            freq[sample]++;
        }
        int[] prefix = new int[1001];
        prefix[0] = freq[0];
        for(int i=1;i<1001;i++){
            prefix[i] = prefix[i-1]+freq[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<R;i++){
            String[] ranges = bf.readLine().split(" ");
            int min = Integer.parseInt(ranges[0]);
            int max = Integer.parseInt(ranges[1]);
            int count = prefix[max]-prefix[min-1];
            sb.append(count);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}