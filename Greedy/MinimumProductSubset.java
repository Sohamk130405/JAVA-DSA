package Greedy;

public class MinimumProductSubset {
    public static void main(String[] args) {
        int[] arr = { 0, -1, -2, -3, -4 };
        System.out.println(minProductSubset(arr));
    }

    public static int minProductSubset(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int negativeCount = 0, zeroCount = 0, smallestPositive = Integer.MAX_VALUE,
                largestNegative = Integer.MIN_VALUE, product = 1;

        for (int ele : arr) {
            if (ele < 0) {
                negativeCount++;
                largestNegative = Math.max(largestNegative, ele);
            }

            else if (ele > 0) {
                smallestPositive = Math.min(smallestPositive, ele);
            } else
                zeroCount++;
        }

        if (negativeCount == 0 && zeroCount > 0)
            return 0;
        else if (negativeCount == 0)
            return smallestPositive;
        else if (negativeCount > 0) {
            for (int ele : arr) {
                if (ele != 0)
                    product *= ele;
            }
            return negativeCount % 2 == 0 ? product / largestNegative : product;
        } else
            return smallestPositive;
    }
}
