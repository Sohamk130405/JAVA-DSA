package BinarySearch.BsOnAnswer;

public class shipment {
    public static void main(String[] args) {
        int arr[] = { 3,2,1,2,4,1};
        int n = arr.length;
        int d = 5;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if(arr[i]>max) max = arr[i];
        }

        int lo = max;
        int hi = sum;
        int minc = lo;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(mid, arr, d)) {
                minc = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }

        System.out.println(minc);
    }

    private static boolean isPossible(int c, int[] arr, int d) {
        int load = 0 ;
        int days = 1;
        for (int i = 0; i < arr.length; i++) {
            if(load+arr[i]<=c) load+=arr[i];
            else{
                load=arr[i];
                days++;
            }
        }
        if(days>d) return false;
        return true;
    }
}
