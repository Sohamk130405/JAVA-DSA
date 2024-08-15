package Queues.Implementation;

public class ArrayImplementation {

    public static class Queue {
        int f = -1;
        int r = -1;
        int size = 0;
        int[] arr = new int[100];

        public void add(int val) {
            if (r == arr.length - 1) {
                System.out.println("Queue is full!");
                return;
            }
            if (f == -1) {
                f = r = 0;
                arr[f] = val;
            }

            else
                arr[++r] = val;
            size++;
        }

        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            f++;
            size--;
            return arr[f - 1];
        }

        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[f];
        }

        public boolean isEmpty() {
            return size == 0 ? true : false;
        }

        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return;
            }
            for (int i = f; i <= r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
    }
}
