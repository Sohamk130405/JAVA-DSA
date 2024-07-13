package BinarySearch.Basic;

public class basic {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 45, 49, 89, 400, 1200 };
        boolean flag = false;
        int target = 1201;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] == target) {
                flag = true;
                break;
            }
        }

        System.out.println(flag);
    }
}
