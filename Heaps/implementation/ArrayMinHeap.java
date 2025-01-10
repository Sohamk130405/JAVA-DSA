package implementation;


public class ArrayMinHeap {
    // lc = 2p+1 , rc = 2p+2 , p =(c-1)/ 2
    private int[] arr = new int[50];
    private int size = 0;
    private int capacity;

    public ArrayMinHeap(int capacity) {
        this.capacity = capacity;
    }

    public void add(int x) {
        if (size == capacity)
            throw new Error("Heap is full");
        arr[size++] = x;
        upHeapify(size - 1);
    }

    public int remove() {
        if (size == 0)
            throw new Error("Heap is Empty");
        int top = arr[0];
        swap(arr, size - 1, 0);
        size--;
        downHeapify(0);
        return top;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void downHeapify(int p) {
        if (p >= size)
            return;
        int lc = 2 * p + 1;
        int rc = 2 * p + 2;
        int minIdx = p;
        if (lc < size && arr[lc] < arr[minIdx])
            minIdx = lc;
        if (rc < size && arr[rc] < arr[minIdx])
            minIdx = rc;
        if (p == minIdx)
            return;

        swap(arr, minIdx, p);
        downHeapify(minIdx);
    }

    private void upHeapify(int c) {
        int p = (c - 1) / 2;
        while (arr[p] > arr[c]) {
            swap(arr, c, p);
            c = p;
            p = (c - 1) / 2;
        }
    }

    public int size() {
        return size;
    }

    public int top() {
        if (size == 0)
            throw new Error("Heap is Empty");
        return arr[0];
    }
}
