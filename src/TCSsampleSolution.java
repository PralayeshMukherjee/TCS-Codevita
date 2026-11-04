import java.util.*;
import java.io.*;

public class TCSsampleSolution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        List<String[]> list = new ArrayList<>();
        for(int i=1;i<N;i++){
            list.add(bf.readLine().split(" "));
        }
        char[][] grid = new char[N][list.get(0).length];
        for(int i=0;i<list.size();i++){
            String[] str = list.get(i);
            for(int j=0;j<str.length;j++){
                grid[i][j] = str[j].charAt(i);
            }
        }
        int[] rows = {-1,-1,0,1,1,1,0,-1};
        int[] cols = {0,-1,-1,-1,0,1,1,1};
    }
}
