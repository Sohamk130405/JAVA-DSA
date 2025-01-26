public class NiceSubarrays {

}

class SolutionBySlidingWindow {
    public int numberOfSubarrays(int[] arr, int k) {
        int i = 0, j = 0, cnt = 0, n = arr.length, sum = 0, a = 0, b = 0;

        while (i < n && arr[i] % 2 == 0)
            i++;
        while (j < n && sum < k)
            if (arr[j++] % 2 != 0)
                sum++;
        if (sum < k)
            return 0;
        j--;
        b = j + 1;
        while (b < n && arr[b] % 2 == 0)
            b++;
        b--;

        while (b < n) {
            cnt += (i - a + 1) * (b - j + 1);
            a = ++i;
            while (i < n && arr[i] % 2 == 0)
                i++;
            j = b + 1;
            b = j + 1;
            while (b < n && arr[b] % 2 == 0)
                b++;
            b--;
        }

        return cnt;
    }
}
