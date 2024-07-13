package BinarySearch.Basic;

public class firstAndLastPos {
    public static void main(String[] args) {
        int[] arr = { 10, 10, 20, 20, 20, 30, 40, 40, 40, 40, 50, 60 };

        int target = 20;
        int fp = -1;
        int lp = -1;
        int lo = 0;
        int hi = arr.length - 1;

        // to find first position
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] == target) {
                if (mid > 0 && arr[mid] == arr[mid - 1]) {
                    hi = mid - 1;
                } else {
                    fp = mid;
                    break;
                }
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            }
        }

        // to find last position
        lo = 0;
        hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] == target) {
                if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
                    lo = mid + 1;
                } else {
                    lp = mid;
                    break;
                }
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            }
        }

        System.out.println(fp + " " + lp);
    }
}
