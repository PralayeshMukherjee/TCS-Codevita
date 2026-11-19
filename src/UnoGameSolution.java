import java.io.*;
import java.util.*;

class PairForUno{
    String name;
    int skill;
    public PairForUno(String name,int skill){
        this.name = name;
        this.skill = skill;
    }
}
public class UnoGameSolution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());
        String[] names = bf.readLine().split(" ");
        String[] skills = bf.readLine().split(" ");
        int N1 = Integer.parseInt(bf.readLine().trim());
        Map<String,String> friends = new HashMap<>();
        for(int i=0;i<N1;i++){
            String[] friendsPair = bf.readLine().split(" ");
            friends.put(friendsPair[0],friendsPair[1]);;
        }
        int N2 = Integer.parseInt(bf.readLine().trim());
        Map<String,String> rivals = new HashMap<>();
        for(int i=0;i<N2;i++){
            String[] rivalsPair = bf.readLine().split(" ");
            rivals.put(rivalsPair[0],rivalsPair[1]);
        }
        int skillLimit = Integer.parseInt(bf.readLine().trim());
        Queue<PairForUno> pq = new PriorityQueue<>((a,b)->a.skill-b.skill);
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            pq.add(new PairForUno(names[i],Integer.parseInt(skills[i])));
            map.put(names[i],Integer.parseInt(skills[i]));
        }
        int count = 0;
        int countNumber = 0;
        while(!pq.isEmpty()){
            PairForUno pairForUno = pq.poll();
            String name = pairForUno.name;
            int skill = pairForUno.skill;
            if(map.containsKey(name)){
                if(friends.containsKey(name) && (count+skill+map.get(friends.get(name)))<=skillLimit){
                    count += (skill+map.get(friends.get(name)));
                    map.remove(name);
                    map.remove(friends.get(name));
                    countNumber+=2;
                }
                if(rivals.containsKey(name) && (count+skill)<skillLimit){
                    map.remove(rivals.get(name));
                }
                if(!friends.containsKey(name) && (count+skill)<=skillLimit){
                    count += skill;
                    countNumber++;
                }
            }
        }
        System.out.println(countNumber);
    }
}
