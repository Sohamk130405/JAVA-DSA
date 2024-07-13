package Recursion.Basics;


public class power {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;

        System.out.println(efficientPower(a, b));
    }

    private static int pow(int a, int b) {
        // T.C = O(b)
        if (b == 0)
            return 1;
        return a * pow(a, b - 1);
    }

    private static int efficientPower(int a, int b) {
        // T.C = O(log(b))
        if (b == 0 || b == 1)
            return 1;
        else{
            int ans = pow(a,b/2);
            if(b%2==0){
                return ans*ans;
            }else{
                return ans * ans*a;
            }
        }

        
    }
}
