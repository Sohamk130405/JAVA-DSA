package PrefixSum;

public class minimumPenaltyOfShop {
    
}

class Solution {
    public int bestClosingTime(String s) {
        int n = s.length();
        int[] preN = new int[n + 1];
        int[] sufY = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preN[i] = preN[i - 1];
            int ch = s.charAt(i - 1);
            if (ch == 'N')
                preN[i]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            sufY[i] = sufY[i + 1];
            int ch = s.charAt(i);
            if (ch == 'Y')
                sufY[i]++;

        }
        int min = Integer.MAX_VALUE;
        int hour = 0;
        for (int i = 0; i <= n; i++) {
            int no = preN[i];
            int yes = sufY[i];
            int sum = yes + no;
            if (min > sum) {
                min = sum;
                hour = i;
            }
        }
        return hour;

    }
}