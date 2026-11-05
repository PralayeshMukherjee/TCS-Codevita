import java.io.*;
import java.util.*;
class ObstacleTriplet{
    int row;
    int col;
    char val;
    public ObstacleTriplet(int row,int col,char val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
public class TCSSampleSolution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        List<String[]> inputList = new ArrayList<>();
        for(int i=0;i<N;i++){
            inputList.add(bf.readLine().split(" "));
        }
        int M = inputList.get(0).length;
        char[][] grid = new char[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j] = inputList.get(i)[j].charAt(0);
            }
        }
        int[][] isVisited = new int[N][M];
        Stack<ObstacleTriplet> stk = new Stack<>();
        stk.push(new ObstacleTriplet(0,0,grid[0][0]));
        isVisited[0][0] = 1;
        int[] rows = {-1,-1,0,1,1,1,0,-1};
        int[] cols = {0,-1,-1,-1,0,1,1,1};
        List<String> list = new ArrayList<>();
        while(!stk.isEmpty()){
            ObstacleTriplet obstacleTriplet = stk.pop();
            int r = obstacleTriplet.row;
            int c = obstacleTriplet.col;
            char v = obstacleTriplet.val;
            if(v=='R'){
                String str = "";
                for(int i=0;i<8;i++){
                    int nr = r+rows[i];
                    int nc = c+cols[i];
                    if(nr>=0 && nr<N && nc>=0 && nc<M && grid[nr][nc]!='R' && grid[nr][nc]!='M' && grid[nr][nc]!='A' && grid[nr][nc]!='D') {
                        str+=grid[nr][nc];
                        str+=" ";
                    }
                }
                if(str.isEmpty()){
                    list.add("NO HURDLES");
                }else{
                    list.add(str);
                }
            }else if(v=='D'){
                list.add("DESTINATION");
            }
            for(int i=0;i<8;i++){
                int nr = r+rows[i];
                int nc = c+cols[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && (grid[nr][nc]=='R' || grid[nr][nc]=='D')  && isVisited[nr][nc]==0){
                    isVisited[nr][nc] = 1;
                    stk.push(new ObstacleTriplet(nr,nc,grid[nr][nc]));
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for(String s: list){
            if(!s.equals("DESTINATION")||!s.equals("NO HURDLES")){
                String[] needToSort = s.trim().split(" ");
                Arrays.sort(needToSort);
                String ans = "";
                for(int i=0;i<needToSort.length;i++){
                    ans+=needToSort[i];
                }
                answer.add(ans);
            }else{
                answer.add(s);
            }
        }
        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i));
            if(i!=answer.size()-1) System.out.println();
        }
    }
}
