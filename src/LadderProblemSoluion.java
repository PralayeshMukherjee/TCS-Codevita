import java.io.*;
import java.util.*;

class Triplet{
    int row;
    int col;
    int orientation;
    int moves;
    public Triplet(int row,int col,int orientation,int moves){
        this.row = row;
        this.col = col;
        this.orientation = orientation;
        this.moves = moves;
    }
}
public class LadderProblemSoluion {
    static boolean canPlace(int r,int c,int dir,int M,int N,int L,char[][] grid){
        if(dir==0){
            if(r<0||r>=M||c<0||c+L>=N){
                return false;
            }
            for(int j=0;j<L;j++){
                if(grid[r][c+j]=='B') return false;
            }
        }else{
            if(r<0||r+L>M||c<0||c>=M) return false;
            for(int i=0;i<L;i++){
                if(grid[r+i][c]=='B') return false;
            }
        }
        return true;
    }
    static boolean canRotate(int r,int c,int dir,int L,int M,int N,char[][] grid){
        int minR,maxR,minC,maxC;
        if(dir==0){
            minR = r;
            maxR = r+L-1;
            minC = c;
            maxC = c+L-1;
        }else{
            minR = r;
            maxR = r + L - 1;
            minC = c;
            maxC = c + L - 1;
        }
        if(minR<0 || maxR>=M || minC<0 || maxC>=N){
            return false;
        }
        for(int i=minR;i<=maxR;i++){
            for(int j=minC;j<=maxC;j++){
                if(grid[i][j]=='B'){
                    return false;
                }
            }
        }
        return true;
    }
    static int bfs(int sr,int sc,int dr,int dc,int orientation,int destOrientation,
    boolean isVisited[][][],int M,int N,int L,char[][] grid){
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(sr,sc,orientation,0));
        isVisited[sr][sc][orientation] = true;
        int[] rows = {-1,0,1,0};
        int[] cols = {0,-1,0,1};
        while(!queue.isEmpty()){
            Triplet triplet = queue.poll();
            int r = triplet.row;
            int c = triplet.col;
            int o = triplet.orientation;
            if(r==dr && c==dc && o==destOrientation){
                return triplet.moves;
            }
            for(int i=0;i<4;i++){
                int nr = r+rows[i];
                int nc = c+cols[i];
                if(canPlace(nr,nc,o,M,N,L,grid) && !isVisited[nr][nc][o]){
                    isVisited[nr][nc][o] = true;
                    queue.add(new Triplet(nr,nc,o,triplet.moves+1));
                }
            }
            int newDirection = 1 - o;
            if(canRotate(r,c,o,L,M,N,grid) && canPlace(r,c,o,M,N,L,grid) && !isVisited[r][c][newDirection]){
                isVisited[r][c][newDirection] = true;
                queue.add(new Triplet(r,c,newDirection,triplet.moves+1));
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] diameter = bf.readLine().split(" ");
        int M = Integer.parseInt(diameter[0]);
        int N = Integer.parseInt(diameter[1]);
        int sr = -1, sc = -1, dr = -1, dc = -1;
        char[][] grid = new char[M][N];
        for(int i=0;i<M;i++){
            String[] inputs = bf.readLine().split("");
            for(int j=0;j<N;j++){
                grid[i][j] = inputs[j].charAt(0);
                if(grid[i][j]=='l'){
                    if(sr==-1){
                        sr = i;
                        sc = j;
                    }
                }
                if(grid[i][j]=='L'){
                    if(dr==-1){
                        dr = i;
                        dc = j;
                    }
                }
            }
        }
        int ladderLen = 0;
        for(int j=sc;j<N;j++){
            if(grid[sr][j]=='l'){
                ladderLen++;
            }else{
                break;
            }
        }
        int orientation = 0;
        if(ladderLen==0){
            orientation = 1;
            for(int i=sr;i<M;i++){
                if(grid[i][sc]=='l'){
                    ladderLen++;
                }else{
                    break;
                }
            }
        }
        int destinationLen = 0;
        int DestOrientation = 0;
        for(int j=dc;j<N;j++){
            if(grid[dr][j]=='L') destinationLen++;
        }
        if(destinationLen==0){
            DestOrientation = 1;
        }
        boolean[][][] isVisited = new boolean[M][N][2];
        int res = bfs(sr,sc,dr,dc,orientation,DestOrientation,isVisited,M,N,ladderLen,grid);
        if(res==-1){
            System.out.println("Impossible");
        }else{
            System.out.println(res);
        }
    }
}
