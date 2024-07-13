package BinarySearch.BsOnUnsorted;

public class rotatedArray2 {
    public static void main(String[] args) {
        int[] arr = { 89, 400, 1200, 1, 2, 3, 45, 49};
        int ans = -1;
        int target = 400;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] <= arr[hi]) { // right sorted array (mid to hi is sorted)
                if (target >= arr[mid] && target <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else { // left sorted array (lo to mid is sorted)
                if (target <= arr[mid] && target >= arr[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        System.out.println(ans);
    }

}