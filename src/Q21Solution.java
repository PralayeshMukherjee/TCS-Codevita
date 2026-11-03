import java.util.*;
import java.io.*;

public class Q21Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        int[][] grid = new int[N][2];
        for(int i=0;i<N;i++){
            String[] str = bf.readLine().split(" ");
            grid[i][0] = Integer.parseInt(str[0]);
            grid[i][1] = Integer.parseInt(str[1]);
        }
        int sum = 0;
        for(int i=1;i<N;i++){
            int x1 = grid[i-1][0];
            int x2 = grid[i][0];
            int y1=  grid[i-1][1];
            int y2 = grid[i][1];
            sum += ((x1*y2)-(y1*x2));
        }
        System.out.println((double)sum/2);
    }
}
