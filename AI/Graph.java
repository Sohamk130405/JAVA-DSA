package AI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int n = scanner.nextInt();
        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        menuChoices(graph, scanner, n);

    }

    public static void menuChoices(int[][] graph, Scanner sc, int n) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. DFS");
            System.out.println("2. BFS");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter starting vertex for DFS (0 to " + (n - 1) + "): ");
                    int dfsStart = sc.nextInt();
                    System.out.println("DFS: " + DFS(graph, n, dfsStart));
                    break;

                case 2:
                    System.out.print("Enter starting vertex for BFS (0 to " + (n - 1) + "): ");
                    int bfsStart = sc.nextInt();
                    System.out.println("BFS: " + BFS(graph, n, bfsStart));
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static StringBuilder BFS(int[][] graph, int n, int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];

        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int front = q.remove();
            sb.append(front).append("->");
            visited[front] = 1;

            for (int i = 0; i < n; i++) {
                boolean edge = graph[front][i] == 1;
                boolean isVisited = visited[i] == 1;
                if (edge && !isVisited) {
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Remove the last arrow
        }   
                
        return sb;
    }

    public static StringBuilder DFS(int[][] graph, int n, int start) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[n];

        st.push(start);
        visited[start] = 1;

        while (!st.isEmpty()) {
            int front = st.pop();
            sb.append(front).append("->");
            visited[front] = 1;

            for (int i = 0; i < n; i++) {
                boolean edge = graph[front][i] == 1;
                boolean isVisited = visited[i] == 1;
                if (edge && !isVisited) {
                    st.push(i);
                    visited[i] = 1;
                }
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Remove the last arrow
        }
        return sb;
    }
}
