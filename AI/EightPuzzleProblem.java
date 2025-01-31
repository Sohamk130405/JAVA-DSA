package AI;

class ArrayNode {
    int[][] arr;
    ArrayNode up;
    ArrayNode down;
    ArrayNode left;
    ArrayNode right;

    public ArrayNode(int[][] arr) {
        this.arr = arr;
    }
}

public class EightPuzzleProblem {
    public static void main(String[] args) {
        int[][] puzzle = {
                { 1, 2, 4},
                { 3, 5, 0},
                { 6, 7, 8}
        };
        ArrayNode root = new ArrayNode(puzzle);
        bfs(puzzle, root);
    }

    public static void bfs(int[][] arr, ArrayNode root) {

    }
}
