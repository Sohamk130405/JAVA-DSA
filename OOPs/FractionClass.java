package OOPs;

public class FractionClass {

    public static class Fraction {
        int num;
        int den;

        public Fraction() {

        }

        public Fraction(int num, int den) {
            this.num = num;
            this.den = den;
            simplify();
        }

        public void simplify() {
            int hcf = gcd(num, den);
            num = num / hcf;
            den = den / hcf;
        }

        public static Fraction add(Fraction f1, Fraction f2) {
            Fraction f3 = new Fraction();
            f3.num = f1.num * f2.den + f2.num * f1.den;
            f3.den = f1.den * f2.den;
            f3.simplify();
            return f3;
        }

        public static Fraction multiply(Fraction f1, Fraction f2) {
            Fraction f3 = new Fraction();
            f3.num = f1.num *f2.num ;
            f3.den = f1.den * f2.den;
            f3.simplify();
            return f3;
        }

    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 9);
        Fraction f2 = new Fraction(3, 2);
        Fraction f3 = Fraction.add(f1, f2);
        Fraction f5 = Fraction.multiply(f1, f2);
        Fraction f4 = new Fraction(14, 21);
        System.out.println(f3.num);
        System.out.println(f3.den);
        f4.simplify();
        System.out.println(f4.num);
        System.out.println(f4.den);
        System.out.println(f5.num);
        System.out.println(f5.den);

    }

    public static int gcd(int num, int den) {
        int min = Math.min(num, den);
        for (int i = min; i >= 1; i--) {
            if (num % i == 0 && den % i == 0)
                return i;
        }

        return min;
    }
}
