package OOPs;

import java.util.Arrays;

public class CustomArrayList {
    public static class Arraylist{
        int[] arr = new int[4];
        int idx = 0;
        int size = 0;

        public void add(int x){
            if(size==arr.length){
                int[] brr  = Arrays.copyOf(arr, arr.length*2);
                arr = brr;
            }
            arr[idx] = x;
            idx++;
            size++;
        }

        public int size(){
            return size;
        }

        public void set(int idx , int val){
            arr[idx] = val;
        }
        public void print(){
            System.out.print("[");
            for (int i = 0; i < arr.length-1; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.print(arr[arr.length-1]+"]");
        }

    }
    public static void main(String[] args) {
        Arraylist arr = new Arraylist();
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(8);
        arr.set(1, 20);
        System.out.println(arr.size());
        arr.print();
    }
}
