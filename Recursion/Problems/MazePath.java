package Recursion.Problems;

public class MazePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        System.out.println(ways(1,1,m, n));
        System.out.println(ways( m, n));
        ;
    }

    private static int ways(int m, int n) {
        if(n==1 || m==1) return 1;
        return ways(m,n-1) + ways(m-1,n);

    }
    
    private static int ways(int row,int col ,int m, int n) {
        if (n == col || m == row)
            return 1;
        int rightWays = ways(row,col+1,m,n);
        int downWays = ways(row+1, col , m, n);
        return rightWays + downWays;

    }
}
