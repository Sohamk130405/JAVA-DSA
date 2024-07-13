package BinarySearch.BsOnUnsorted;

import java.util.ArrayList;
import java.util.Collections;

public class kClosestElement {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 23, 45, 49, 300, 400, 1200 };
        int target = 46;
        int k = 3;
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();

        if (target < arr[0]) {
            for (int i = 0; i < k; i++) {
                al.add(arr[i]);
            }
            System.out.println(al);
            return;
        }
        if (target > arr[n - 1]) {
            for (int i = n - k; i < n; i++) {
                al.add(arr[i]);
            }
            System.out.println(al);
            return;
        }

        int lb = n;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] >= target) {
                lb = Math.min(mid, lb);
                hi = mid - 1;
            } else
                lo = mid + 1;
        }

        lo = lb - 1;
        hi = lb;
        while (k > 0 && lo >= 0 && hi < n) {
            int dlo = Math.abs(target - arr[lo]);
            int dhi = Math.abs(target - arr[hi]);
            if (dlo <= dhi) {
                al.add(arr[lo]);
                lo--;
            } else {
                al.add(arr[hi]);
                hi++;
            }
            k--;
        }

        while (lo < 0 && k > 0) {
            al.add(arr[hi]);
            hi++;
            k--;
        }
        while (hi == n && k > 0) {
            al.add(arr[lo]);
            lo--;
            k--;
        }
        
        Collections.sort(al);
        System.out.println(al);
    }
}
