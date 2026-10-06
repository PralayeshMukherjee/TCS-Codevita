import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Pair{
    double rate;
    double year;
    public Pair(double rate,double year){
        this.rate = rate;
        this.year = year;
    }
}
public class Q2Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p = sc.nextInt();
        int t = sc.nextInt();
        int n1 = sc.nextInt();
        List<Pair> bankA = new ArrayList<>();
        for(int i=0;i<n1;i++){
            int r = sc.nextInt();
            int y = sc.nextInt();
            Pair pair = new Pair(r,y);
            bankA.add(pair);
        }
        int n2 = sc.nextInt();
        List<Pair> bankB = new ArrayList<>();
        for(int i=0;i<n2;i++){
            double r = sc.nextInt();
            double y = sc.nextInt();
            Pair pair = new Pair(r,y);
            bankB.add(pair);
        }
        double totalInterestOfA = 0, totalInterestOfB = 0;
        double principleOfA = p, amountToBePaidToA = 0;
        for(int i=0;i< bankA.size();i++){
            double rate = bankA.get(i).rate;
            double year = bankA.get(i).year;
            double monthlyInterestRateForA = (rate/12)/100;
            double emi = (principleOfA*monthlyInterestRateForA)/(1-(1/Math.pow((1+monthlyInterestRateForA),((t-i)*12))));
            principleOfA = p - (emi*year*12);
            System.out.println("emi of A "+emi);
            amountToBePaidToA+=(emi*year*12);
            System.out.println("amount to be paid "+amountToBePaidToA);
            System.out.println("new Principle "+principleOfA);
        }
        totalInterestOfA = amountToBePaidToA - p;
        double principleOfB = p, amountToBePaidToB = 0;
        for(int i=0;i< bankB.size();i++){
            double rate = bankB.get(i).rate;
            double year = bankB.get(i).year;
            double monthlyInterestRateForB = (rate/12)/100;
            double emi = (principleOfB*monthlyInterestRateForB)/(1-(1/Math.pow((1+monthlyInterestRateForB),((t-i)*12))));
            principleOfB = p - (emi*year*12);
            amountToBePaidToB+=principleOfB;
        }
        totalInterestOfB = amountToBePaidToB-p;
        System.out.println(totalInterestOfA);
        System.out.println(totalInterestOfB);
        if(totalInterestOfA<totalInterestOfB){
            System.out.println("Bank A");
        }else{
            System.out.println("Bank B");
        }
    }
}
