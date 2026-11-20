import java.util.*;
import java.io.*;

public class PathFinderSolution {
    static int[] rows = {-1,-1,0,1,1,1,0,-1};
    static int[] cols = {0,-1,-1,-1,0,1,1,1};
    static int helper(int[][] grid,int[][]block,int r,int c,int dr,int dc,int valueAdded,boolean[][] isVisited){
        if(r==dr && c==dc){
            return valueAdded;
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<8;j++){
            int nr = r+rows[j];
            int nc = c+cols[j];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !isVisited[nr][nc] && block[nr][nc]!=-1){
                int maxValueAmongNeighbour = grid[nr][nc];
                isVisited[nr][nc] = true;
                for(int i=0;i<8;i++){
                    if(i==j) continue;
                    int row = r+rows[i];
                    int col = c+cols[i];
                    if(row>=0 && row<grid.length && col>=0 && col<grid[0].length){
                        maxValueAmongNeighbour = Math.max(maxValueAmongNeighbour,grid[row][col]);
                    }
                }
                int res = helper(grid,block,nr,nc,dr,dc,valueAdded+(maxValueAmongNeighbour-grid[nr][nc]+1),isVisited);
                mini = Math.min(mini,res);
                isVisited[nr][nc] = false;
            }
        }
        return mini;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] gridSize = bf.readLine().split(" ");
        int N = Integer.parseInt(gridSize[0]);
        int M = Integer.parseInt(gridSize[1]);
        int[][] grid = new int[N][M];
        for(int i=0;i<N;i++){
            String[] inputs = bf.readLine().split(" ");
            for(int j=0;j<inputs.length;j++){
                grid[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        String[] currLocation = bf.readLine().split(" ");
        int sr = Integer.parseInt(currLocation[0])-1;
        int sc = Integer.parseInt(currLocation[1])-1;
        String[] destLocation = bf.readLine().split(" ");
        int dr = Integer.parseInt(destLocation[0])-1;
        int dc = Integer.parseInt(destLocation[1])-1;
        int K = Integer.parseInt(bf.readLine().trim());
        int[][] block = new int[N][M];
        for(int i=0;i<K;i++){
            String[] location = bf.readLine().split(" ");
            int r = Integer.parseInt(location[0])-1;
            int c = Integer.parseInt(location[1])-1;
            block[r][c] = -1;
        }
        boolean[][] isVisited = new boolean[N][M];
        isVisited[sr][sc] = true;
        int res = helper(grid,block,sr,sc,dr,dc,0,isVisited);
        System.out.println(res);
    }
}
