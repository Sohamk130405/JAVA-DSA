package Greedy;

import java.util.Arrays;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double maxValue = 0.0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            if (currentWeight + items[i].weight <= W) {
                maxValue += items[i].value;
                currentWeight += items[i].weight;
            } else {
                int remainingWeight = W - currentWeight;
                maxValue += (double) items[i].value * remainingWeight / items[i].weight;
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int W = 50;
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        System.out.println("Maximum Total Value: " + fractionalKnapsack(W, weights, values));
    }
}
