import java.io.*;
import java.util.*;
public class Q20Solution {
    static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int D = Integer.parseInt(str[0]);
        int p = Integer.parseInt(str[1]);
        int parts = D/p;
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=parts;i++){
            if(isPrime(i)) primes.add(i);
        }
        int count = 0;
        System.out.println(primes);
        System.out.println("parts"+parts);
        for(int i=0;i<primes.size();i++){
            int a = primes.get(i);
            int j = p;
            boolean flag = true;
            System.out.println(a);
            while(j>0){
                int lowerLimit = (parts*(j-1))+1;
                int upperLimit = (parts*j);
                int value = a+(parts*(j-1));
                System.out.print("lower: "+lowerLimit+" "+"upper: "+upperLimit+" ");
                System.out.print(value+" ");
                System.out.println();
                if(!isPrime(value)){
                    flag = false;
                    break;
                }
                if(value<lowerLimit||value>upperLimit) {
                    flag = false;
                    break;
                }
                j--;
            }
            System.out.println();
            System.out.println();
            if(flag) count++;
        }
        System.out.println(count);
    }
}
