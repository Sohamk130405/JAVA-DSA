package Queues.Implementation;

public class CircularArrayQueue {
    public static class Queue {
        int f = -1;
        int r = -1;
        int size = 0;
        int[] arr = new int[5];
        int n = arr.length;

        public void add(int val) {
            if (size == n) {
                System.out.println("Queue is full!");
                return;
            }
            if (size == 0) {
                f = r = 0;
                arr[0] = val;
            } else if (r < n - 1)
                arr[++r] = val;
            else if (r == n - 1) {
                r = 0;
                arr[0] = val;
            }
            size++;
        }

        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int x = arr[f];
            if (f == n - 1)
                f = 0;
            else
                f++;
            size--;
            return x;
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
            if(f<=r){
                for (int i = f; i <=r; i++) {
                    System.out.print(arr[i]+" ");
                }
            }else{
                for (int i = f; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i < f; i++) {
                    System.out.print(arr[i] + " ");
                }

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
        q.add(5);
        q.add(6);
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
        q.remove();
        q.add(6);
        q.display();
    }
}
