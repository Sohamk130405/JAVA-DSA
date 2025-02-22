package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] cookies = { 4, 2, 1, 2, 1, 3 };
        int[] greed = { 1, 5, 3, 3, 4 };

        int i = 0, j = 0;
        Arrays.sort(cookies);
        Arrays.sort(greed);
        int count = 0;
        while (i < cookies.length && j < greed.length) {
            if (cookies[i] >= greed[j]) {
                count++;
                j++;
            }
            i++;
        }
        System.out.println(count);
    }

}
