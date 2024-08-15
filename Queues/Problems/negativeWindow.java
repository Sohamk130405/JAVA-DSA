package Queues.Problems;

import java.util.*;

public class negativeWindow {
    public static void main(String[] args) {

        int[] a = { -8, 2, 3, -6, 10 };
        int n = a.length;
        int k = 2;

        int[] res = new int[n - k + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                q.add(i);
            }
        }

        for (int i = 0; i < n - k + 1; i++) {
            if (q.size() > 0 && q.peek() < i)
                q.remove();
            if (q.size() > 0 && q.peek() <= i + k - 1) {
                res[i] = a[q.peek()];
            } else
                res[i] = 0;
        }

        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }

    }
}
