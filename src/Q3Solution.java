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


//the above is the O(N^2) approch which doesn't get accepted

//below approch will be accepted because its time complexity is

public class Q3Solution{
    public static void main(String[] args) {

    }
}