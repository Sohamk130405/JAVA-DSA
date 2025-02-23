package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        bfs(rooms, 0, isVisited);
        for (boolean ele : isVisited) {
            if (!ele)
                return false;
        }
        return true;
    }

    public void bfs(List<List<Integer>> adj, int i, boolean[] isVisited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        isVisited[i] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int ele : adj.get(node)) {
                if (!isVisited[ele]) {
                    q.add(ele);
                    isVisited[ele] = true;
                }
            }
        }
    }
}
