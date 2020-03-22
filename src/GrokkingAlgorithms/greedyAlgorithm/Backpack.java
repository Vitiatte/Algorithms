package GrokkingAlgorithms.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int size;
    private int occupiedSpace = 0;
    private int priceOfElementsInBackpack = 0;
    private List<Thing> things;

    public Backpack(int size) {
        this.size = size;
        things = new ArrayList<>();
    }

    public boolean putThing(Thing thing) {
        if (thing.getWeight() <= size - occupiedSpace) {
            things.add(thing);
            occupiedSpace += thing.getWeight();
            priceOfElementsInBackpack += thing.getPrice();
            return true;
        }
        return false;
    }

    public int spaceLeft() {
        return size - occupiedSpace;
    }

    public int getPriceOfElementsInBackpack() {
        return priceOfElementsInBackpack;
    }

    public void printThingInBackpack() {
        for (Thing thing : things) {
            System.out.print("[" + thing.getName() + "]");
        }
        System.out.println();
    }
}
