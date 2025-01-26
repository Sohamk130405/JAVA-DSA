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
            } else if (f==r) {
                f = r = -1;
                size--;
                return arr[0];
            } else {
                size--;
                return arr[f++];
            }
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
        q.add(4);
        q.add(5);
        q.remove();
        q.display();
        q.remove();
        q.display();
        q.remove();
        q.display();
        q.remove();
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.peek());

        // for (int i = 0; i < 100; i++) {
        //     q.add(i);
        // }
        // for (int i = 0; i < 100; i++) {
        //     q.remove();
        // }
        // for (int i = 0; i < 100; i++) {
        //     q.add(i);
        // }
        // for (int i = 0; i < 100; i++) {
        //     q.remove();
        // }
        // q.display();
        // System.out.println(q.size);
    }
}
