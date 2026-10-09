import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(",");
        long N = Long.parseLong(input[0].trim());
        int k = Integer.parseInt(input[1].trim());
        int count = 0;
        long result = 1;
        for(long i=N;i>=2;i--){
            if(N%i==0){
                count++;
            }
            if(count==k){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
