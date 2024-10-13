import java.util.HashSet;

class countDistinctIntegers {
    public int reverseNum(int x) {
        int sum = 0;
        while (x != 0) {
            sum = x % 10 + sum * 10;
            x /= 10;
        }
        return sum;
    }

    public int main(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            set.add(reverseNum(nums[i]));
        }
        return set.size();
    }
}