package Heaps;

class Pair implements Comparable<Pair> {
    int d;
    int x;

    public Pair(int d, int x) {
        this.d = d;
        this.x = x;
    }

    public int compareTo(Pair t) {
        int diff = this.d - t.d;
        if (diff == 0)
            return this.x - t.x;
        return diff;
    }
}
