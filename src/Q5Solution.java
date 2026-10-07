import java.util.*;
import java.io.*;

public class Q5Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        String[] inputs = bf.readLine().split(" ");
        int totalUnit = 0;
        for(int i=0;i<N;i++){
            StringBuilder str = new StringBuilder(inputs[i].trim());
            for(int j=0;j<str.length()-1;j++){
                if(str.charAt(j)=='J' && str.charAt(j+1)=='A'){
                    str.setCharAt(j,'0');
                }else if(str.charAt(j)=='I' && str.charAt(j+1)=='B'){
                    str.setCharAt(j,'1');
                }else if(str.charAt(j)=='H' && str.charAt(j+1)=='C'){
                    str.setCharAt(j,'2');
                }else if(str.charAt(j)=='D' && str.charAt(j+1)=='G'){
                    str.setCharAt(j,'3');
                }else if(str.charAt(j)=='E' && str.charAt(j+1)=='F'){
                    str.setCharAt(j,'4');
                }else{
                    int temp = str.charAt(j)-'A';
                    str.setCharAt(j,String.valueOf(temp).charAt(0));
                }
            }
            int temp = str.charAt(str.length()-1)-'A';
            str.setCharAt(str.length()-1,String.valueOf(temp).charAt(0));
            totalUnit += Integer.parseInt(str.toString());
        }
        int centralMeterUnit = Integer.parseInt(bf.readLine().trim());
        if(totalUnit<centralMeterUnit){
            System.out.println("INNOCENT");
        }else{
            System.out.println("GREEDY");
            System.out.println(((long)totalUnit-(long)centralMeterUnit));
        }
    }
}
