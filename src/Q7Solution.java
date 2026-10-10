import java.io.BufferedReader;
import java.nio.Buffer;
import java.io.*;
import java.util.*;

public class Q7Solution {
    public static boolean isPrime(long n){
        for(long i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static long primeGenerator(long N){
        long count = 0;
        long sum = 0;
        for(long i=2;i<=N;i++){
            if(isPrime(i)){
                sum+=i;
            }
            if(sum>N)break;
            if(sum>=3&&isPrime(sum)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine().trim());
        System.out.println(primeGenerator(N));
    }
}
