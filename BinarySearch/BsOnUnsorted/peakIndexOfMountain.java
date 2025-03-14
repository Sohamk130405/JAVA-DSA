package BinarySearch.BsOnUnsorted;

public class peakIndexOfMountain {
    public static void main(String[] args) {
        int[] arr = { 10,20,30,40,50,70,20,10 };
        int idx = -1;
        int lo = 1;
        int hi = arr.length - 2;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                idx = mid;
                break;
            } else if (arr[mid] < arr[mid-1]) {
                hi = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            }
        }

        System.out.println(idx);
    }
}


class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int idx = -1;
        int lo = 1;
        int hi = n - 2;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                idx = mid;
                break;
            } else if (arr[mid] < arr[mid - 1]) {
                hi = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            }
        }
        if (idx == -1) {
            if (arr[0] > arr[n - 1])
                return 0;
            else
                return n - 1;
        }
        return idx;

    }
}