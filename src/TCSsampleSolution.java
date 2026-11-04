import java.util.*;
import java.io.*;
class Points{
    int x;
    int y;
    int z;
    public Points(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class TCSsampleSolution{
    public static String face(int x,int y,int z){
        if(z==10) return "TOP";
        if(x==0) return "LEFT";
        if(x==10) return "RIGHT";
        if(y==0) return "FRONT";
        if(y==10) return "BACK";
        return "NONE";
    }
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        List<Points> list = new ArrayList<>();
        String[] str = bf.readLine().split(",");
        int i = 0;
        while(i<(3*N)){
            int x = Integer.parseInt(str[i]);
            int y = Integer.parseInt(str[i+1]);
            int z = Integer.parseInt(str[i+2]);
            list.add(new Points(x,y,z));
            i+=3;
        }
        double total = 0;
        for(int j=1;j<list.size();j++){
            Points A = list.get(j-1);
            Points B = list.get(j);
            String faceA = face(A.x,A.y,A.z);
            String faceB = face(B.x,B.y,B.z);
            if(faceA.equals(faceB)){
                double X = (A.x-B.x);
                double Y = (A.y-B.y);
                double Z = (A.z-B.z);
                double r = Math.sqrt((X*X)+(Y*Y)+(Z*Z));
                double L = (3.14*r)/3;
                total += Math.round(L*100.0)/100.0;
            }else{
                int a = Math.abs(A.x-B.x);
                int c = Math.abs(A.z-B.z);
                int b = Math.abs(A.y-B.y);
                double L = Math.sqrt(((a+c)*(a+b))+(b*b));
                total += Math.round(L*100.0)/100.0;
            }
        }
        System.out.println(total);
    }
}