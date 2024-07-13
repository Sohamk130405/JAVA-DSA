package Recursion.Arrays;

import java.util.ArrayList;

public class subsets {
    static ArrayList<ArrayList<Integer>> al;

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        al = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();

        addSubsets(arr, 0, x);
        System.out.println(al);
    }

    private static void addSubsets(int[] arr, int i, ArrayList<Integer> x) {

        if (arr.length == i) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < x.size(); j++) {
                list.add(x.get(j));
            }
            al.add(list);
            return;
        }
        addSubsets(arr, i + 1, x);// not take
        x.add(arr[i]);
        addSubsets(arr, i + 1, x);// take
        x.remove(x.size() - 1);
    }

}
