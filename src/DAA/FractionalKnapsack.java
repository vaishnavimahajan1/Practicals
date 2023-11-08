package DAA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(List<Item> items, int capacity) {
        Collections.sort(items, Comparator.comparingDouble(item -> -1.0 * item.value / item.weight));
        
        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                totalValue += (item.value * remainingCapacity) / (double)item.weight;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));
        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value: " + maxValue);
    }
}
