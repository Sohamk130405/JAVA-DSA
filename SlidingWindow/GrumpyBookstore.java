public class GrumpyBookstore {
    public static void main(String[] args) {
        int customers[] = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int grumpy[] =    { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
    
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i = 1, j = minutes, n = customers.length, maxUnsatisfied = 0, unsatisfied = 0;
        for (int l = 0; l < minutes; l++) {
            if (grumpy[l] == 1)
                unsatisfied += customers[l];
        }
        int left = 0, right = j - 1;
        maxUnsatisfied = unsatisfied;

        while (j < n) {
            int windowSumI = grumpy[i - 1] == 1 ? customers[i - 1] : 0;
            int windowSumJ = grumpy[j] == 1 ? customers[j] : 0;
            unsatisfied = unsatisfied - windowSumI + windowSumJ;
            if (maxUnsatisfied < unsatisfied) {
                maxUnsatisfied = unsatisfied;
                left = i;
                right = j;
            }
            i++;
            j++;
        }

        for (int l = left; l <= right; l++) {
                grumpy[l] = 0;
        }

        int cnt = 0;
        for (int l = 0; l < n; l++) {
            if (grumpy[l] == 0)
                cnt += customers[l];
        }

        return cnt;

    }
}
