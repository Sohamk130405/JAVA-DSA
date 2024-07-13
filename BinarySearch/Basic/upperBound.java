package BinarySearch.Basic;

public class upperBound {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 23, 45, 49, 89, 400, 1200 };

        int target = 1200;
        int ub = arr.length;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] > target) {
                ub = Math.min(mid, ub);
                hi = mid - 1;
            } else
                lo = mid + 1;
        }

        System.out.println(ub);
    }
}
