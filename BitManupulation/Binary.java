package BitManupulation;

public class Binary {
    public static int convertToDecimal(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ans += Math.pow(2, n - i - 1);
            }
        }
        return ans;
    }

    public static String convertToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public static int findPower2(int n) {
        // 2^n , n>=0
        return 1 << n;
    }

    public static void main(String[] args) {
        String s = "1010";
        System.out.println(convertToDecimal(s));
        System.out.println(convertToBinary(10));
        System.out.println(findPower2(3));

        // Swap two numbers
        int a = 10, b = 20;
        a = a ^ b;
        b = a ^ b;  // a^(b^b) = a
        a = a ^ b;  // (a^a)^b = b
        System.out.println(a + " " + b);
    }
}
