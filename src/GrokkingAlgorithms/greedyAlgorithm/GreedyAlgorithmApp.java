package GrokkingAlgorithms.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GreedyAlgorithmApp {
    public static void main(String[] args) {
        List<Thing> store = new ArrayList<>();
        store.add(new Thing("Guitar", 100, 3));
        store.add(new Thing("Micro", 500, 2));
        store.add(new Thing("Phone", 800, 1));
        store.add(new Thing("iPad", 800, 2));
        store.add(new Thing("Pen", 100, 1));
        store.add(new Thing("Clock", 400, 1));
        store.add(new Thing("Glove", 300, 2));
        store.add(new Thing("Piano", 2000, 5));
        store.add(new Thing("Acoustic", 1500, 4));

        Backpack backpack = new Backpack(12);
        fillBackPackWithMaxPrice(backpack, store);

        System.out.println(backpack.spaceLeft());
        System.out.println(backpack.getPriceOfElementsInBackpack());
        backpack.printThingInBackpack();

    }

    //Greedy algorithm
    private static void fillBackPackWithMaxPrice(Backpack backpack, List<Thing> store) {
        int bestThingIndex = 0;
        while (backpack.spaceLeft() != 0 && bestThingIndex != -1) {
            bestThingIndex = -1; // -1 if left space not enough to get any thing
            int bestPrice = 0;
            ListIterator<Thing> iterator = store.listIterator();
            while (iterator.hasNext()) {
                Thing thing = iterator.next();
                if (backpack.spaceLeft() >= thing.getWeight()
                        && bestPrice < thing.getPrice()) {
                    bestPrice = thing.getPrice();
                    bestThingIndex = iterator.previousIndex();
                }
            }

            if (bestThingIndex != -1) {
                backpack.putThing(store.remove(bestThingIndex));
            }
        }
    }
}
