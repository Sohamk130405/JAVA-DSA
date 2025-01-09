package Heaps;
class Triplet implements Comparable<Triplet> {
    int d;
    int x;
    int y;

    public Triplet(int d, int x, int y) {
        this.d = d;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Triplet t) {
        return this.d - t.d;
    }
}

