import java.io.*;
import java.util.*;

public class Q10Solution {
    public static int monthDate(int hh){
        if(hh==1||hh==3||hh==5||hh==7||hh==8||hh==10||hh==12){
            return 31;
        }else if(hh==2){
            return 28;
        }else{
            return 30;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(",");
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inputs.length;i++){
            int temp = Integer.parseInt(inputs[i]);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        String yy = "";
        for(int i=12;i>=1;i--){
            int second = i%10;
            int first = i/10;
            if(map.containsKey(first) && map.get(first)!=0 && map.containsKey(second) && map.get(second)!=0){
                yy = String.valueOf(i);
                map.put(first,map.get(first)-1);
                map.put(second,map.get(second)-1);
                break;
            }
        }
        String date = "";
        if(!yy.isEmpty()) {
            int dateOfMonth = monthDate(Integer.parseInt(yy));
            for(int i=dateOfMonth;i>=1;i--){
                int second = i%10;
                int first = i/10;
                if(map.containsKey(first) && map.get(first)!=0 && map.containsKey(second) && map.get(second)!=0){
                    date = String.valueOf(i);
                    map.put(first,map.get(first)-1);
                    map.put(second,map.get(second)-1);
                    break;
                }
            }
        }
        String hh = "";
        if(!date.isEmpty()){
            for(int i=23;i>=1;i--){
                int second = i%10;
                int first = i/10;
                if(map.containsKey(first) && map.get(first)!=0 && map.containsKey(second) && map.get(second)!=0){
                    hh = String.valueOf(i);
                    map.put(first,map.get(first)-1);
                    map.put(second,map.get(second)-1);
                    break;
                }
            }
        }
        String mm = "";
        if(!hh.isEmpty()){
            for(int i=59;i>=1;i--){
                int second = i%10;
                int first = i/10;
                if(map.containsKey(first) && map.get(first)!=0 && map.containsKey(second) && map.get(second)!=0){
                    mm = String.valueOf(i);
                    map.put(first,map.get(first)-1);
                    map.put(second,map.get(second)-1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        String result = "";
        sb.append(yy);
        sb.append("/");
        sb.append(date);
        sb.append(" ");
        sb.append(hh);
        sb.append(":");
        sb.append(mm);
        if(yy.isEmpty()||date.isEmpty()||hh.isEmpty()||mm.isEmpty()){
            result="0";
        }else{
            result = sb.toString();
        }
        System.out.println(result);
    }
}
