import java.util.*;
import java.io.*;

public class Q11Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bf.readLine().split(",");
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int temp = Integer.parseInt(numbers[i]);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        String hh = "";
        for(int i=24;i>=1;i--){
            int second = i%10;
            int first = i/10;
            if(map.containsKey(first)&&map.get(first)!=0&&map.containsKey(second)&&map.get(second)!=0){
                hh = String.valueOf(i);
                map.put(first,map.get(first)-1);
                map.put(second,map.get(second)-1);
                break;
            }
        }
        String mm = "";
        if(!hh.isEmpty()){
            for(int i=59;i>=1;i--){
                int second = i%10;
                int first = i/10;
                if(map.containsKey(first)&&map.get(first)!=0&&map.containsKey(second)&&map.get(second)!=0){
                    if(hh.equals("24") && i==59) continue;
                    mm=String.valueOf(i);
                    map.put(first,map.get(first)-1);
                    map.put(second,map.get(second)-1);
                    break;
                }
            }
        }
        String ss = "";
        if(!mm.isEmpty()){
            for(int i=59;i>=1;i--){
                int second = i%10;
                int first = i/10;
                if(map.containsKey(first)&&map.get(first)!=0&&map.containsKey(second)&&map.get(second)!=0){
                    if(hh.equals("24") && i==59) continue;
                    ss=String.valueOf(i);
                    map.put(first,map.get(first)-1);
                    map.put(second,map.get(second)-1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(hh.isEmpty()||mm.isEmpty()||ss.isEmpty()){
            sb.append("Impossible");
        }else{
            sb.append(hh);
            sb.append(":");
            sb.append(mm);
            sb.append(":");
            sb.append(ss);
        }
        System.out.println(sb.toString());
    }
}
