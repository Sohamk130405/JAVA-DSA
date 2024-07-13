package BinarySearch.BsOnAnswer;

import java.util.Scanner;

public class sqrtX {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int lo = 0;
        int hi = x;
        int sqrt = 0;

        
        if(x<=1) {
            System.out.println(x);
            return;
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid == x / mid) {
                sqrt = mid;
                break;
            }
            else if (mid < x / mid) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        // while (lo <= hi) {
        // int mid = (lo + hi) / 2;
        // if (mid * mid <= x) {
        // sqrt = Math.max(sqrt,mid);
        // lo = mid + 1;
        // }else{
        // hi = mid - 1;
        // }
        // }

        if(sqrt*sqrt != x) sqrt = hi;

        System.out.println(sqrt);
        
    }
}
