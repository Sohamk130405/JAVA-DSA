package Greedy;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int fiveDollars = 0;
        int tenDollars = 0;
        for (int bill : bills) {
            if (bill == 5)
                fiveDollars++;
            else if (bill == 10 && fiveDollars > 0) {
                fiveDollars--;
                tenDollars++;
            } else if (bill == 20) {
                if (tenDollars > 0 && fiveDollars > 0) {
                    fiveDollars--;
                    tenDollars--;
                } else if (fiveDollars >= 3)
                    fiveDollars -= 3;
                else
                    return false;
            } else
                return false;
        }
        return true;
    }

}
