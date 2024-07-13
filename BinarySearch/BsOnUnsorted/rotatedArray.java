package BinarySearch.BsOnUnsorted;
//inefficient code
class rotatedArray {

    public static int bs(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] arr, int target) {

        if (arr.length <= 3) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target)
                    return i;
            }
            return -1;
        }

        int lo = 1;
        int hi = arr.length - 2;
        int idx = -1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                idx = mid;
                break;
            } else if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                idx = mid - 1;
                break;
            } else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                if (arr[mid] > arr[arr.length - 1])
                    lo = mid + 1;
            }
        }

        if (idx == -1) {
            return bs(arr, 0, arr.length - 1, target);
        }
        int left = bs(arr, 0, idx, target);
        if (left != -1)
            return left;
        int right = bs(arr, idx, arr.length - 1, target);
        return right;

    }
}