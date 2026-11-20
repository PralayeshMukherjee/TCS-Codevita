import java.util.*;
import java.io.*;

class TripletPath{
    int row;
    int col;
    int dist;
    public TripletPath(int row,int col,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
public class PathFinderSolution {
    static int[] rows = {-1,-1,0,1,1,1,0,-1};
    static int[] cols = {0,-1,-1,-1,0,1,1,1};
//    static int helper(int[][] grid,int[][]block,int r,int c,int dr,int dc,int valueAdded,boolean[][] isVisited){
//        if(r==dr && c==dc){
//            return valueAdded;
//        }
//        int mini = Integer.MAX_VALUE;
//        for(int j=0;j<8;j++){
//            int nr = r+rows[j];
//            int nc = c+cols[j];
//            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !isVisited[nr][nc] && block[nr][nc]!=-1){
//                int maxValueAmongNeighbour = grid[nr][nc];
//                isVisited[nr][nc] = true;
//                for(int i=0;i<8;i++){
//                    if(i==j) continue;
//                    int row = r+rows[i];
//                    int col = c+cols[i];
//                    if(row>=0 && row<grid.length && col>=0 && col<grid[0].length){
//                        maxValueAmongNeighbour = Math.max(maxValueAmongNeighbour,grid[row][col]);
//                    }
//                }
//                int res = helper(grid,block,nr,nc,dr,dc,valueAdded+(maxValueAmongNeighbour-grid[nr][nc]+1),isVisited);
//                mini = Math.min(mini,res);
//                isVisited[nr][nc] = false;
//            }
//        }
//        return mini;
//    }  this is the DFS solution but it won't work here so going to implement the Dijkstra's
    static int helper(int[][] grid,int[][] block,int sr,int sc,int dr,int dc){
        int N = grid.length;
        int M = grid[0].length;
        int[][] dist = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        Queue<TripletPath> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        dist[sr][sc] = 0;
        pq.add(new TripletPath(sr,sc,0));
        while(!pq.isEmpty()){
            TripletPath tripletPath = pq.poll();
            int r = tripletPath.row;
            int c = tripletPath.col;
            int d = tripletPath.dist;
            if(d>dist[r][c]) continue;
            if(r==dr && c==dc) return d;
            for(int i=0;i<8;i++){
                int nr = r+rows[i];
                int nc = c+cols[i];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&block[nr][nc]!=-1) {
                    int maxValueNeighbour = grid[r][c];
                    for (int j = 0; j < 8; j++) {
                        if (i == j) continue;
                        int row = r + rows[j];
                        int col = c + cols[j];
                        if (row >= 0 && row < N && col >= 0 && col < M && block[row][col] != -1) {
                            maxValueNeighbour = Math.max(maxValueNeighbour, grid[row][col]);
                        }
                    }
                    int cost = Math.max(0, maxValueNeighbour - grid[nr][nc] + 1);
                    int newCost = cost+d;
                    if(newCost<dist[nr][nc]){
                        dist[nr][nc] = newCost;
                    }
                    pq.add(new TripletPath(nr,nc,newCost));
                }
            }
        }
        return -1;
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
        int res = helper(grid,block,sr,sc,dr,dc);
        System.out.println(res);
    }
}
