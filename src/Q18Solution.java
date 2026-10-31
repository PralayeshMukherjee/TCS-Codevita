import java.util.*;
import java.io.*;
public class Q18Solution {
    public static void helper(String[] inputs, int i, List<String>list,List<List<String>>ll){
        if(i==inputs.length){
            ll.add(new ArrayList<>(list));
            return;
        }
        helper(inputs,i+1,list,ll);
        list.add(inputs[i]);
        helper(inputs,i+1,list,ll);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(",");
        int R = Integer.parseInt(bf.readLine().trim());
        List<String> list = new ArrayList<>();
        List<List<String>> ll = new ArrayList<>();
        helper(inputs,0,list,ll);
        System.out.println(ll);
    }
}
