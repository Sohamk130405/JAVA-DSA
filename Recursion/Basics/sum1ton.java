package Recursion.Basics;

public class sum1ton {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(sum(n));
        sum(n,0);
    }

    private static int sum(int n) {
        if(n<=1) return n;
        return n+sum(n-1);
    }

    private static void sum(int n,int s) {
        if(n==0){
            System.out.println(s);
            return;
        }else{
            sum(n-1,s+n);
        }
        
    } 
}
