import java.io.*;

public class Q13Solution {
    public static char checker(char[][]grid,int col){
        String top = "" + grid[0][col] + grid[0][col + 1] + grid[0][col + 2];
        String mid = "" + grid[1][col] + grid[1][col + 1] + grid[1][col + 2];
        String bot = "" + grid[2][col] + grid[2][col + 1] + grid[2][col + 2];
        if (top.equals("*.*") && mid.equals("*.*") && bot.equals("***"))
            return 'U';

        if (top.equals("***") && mid.equals("*.*") && bot.equals("***"))
            return 'O';

        if (top.equals(".*.") && mid.equals(".*.") && bot.equals("***"))
            return 'I';

        if (top.equals("***") && mid.equals("**.") && bot.equals("***"))
            return 'E';

        if (top.equals(".*.") && mid.equals("*.*") && bot.equals("***"))
            return 'A';

        return '\0';
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        char[][] input = new char[3][n];
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                input[i][j] = bf.readLine().trim().charAt(0);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (input[0][i] == '#') {
                ans.append('#');
                i++;
            } else if (i + 2 < n) {
                char vowel = checker(input, i);

                if (vowel != '\0') {
                    ans.append(vowel);
                    i += 3;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        System.out.println(ans);
    }
}
