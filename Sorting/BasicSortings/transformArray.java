package Sorting.BasicSortings;

public class transformArray {

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {40,12,78,34,100,57,23};

        for (int i = 0; i <arr.length; i++) {
            int mindx = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]<min && arr[j]>0){
                    min = arr[j];
                    mindx = j;
                }
            }
            arr[mindx] = -i;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]*=(-1);
        }
        
        print(arr);

        
    }
}
