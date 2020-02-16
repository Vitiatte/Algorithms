package GrokkingAlgorithms.recursion;

import java.util.List;

public class Box {
    private List<Integer> integers;
    private List<Box> boxes;

    public Box(List<Integer> integers, List<Box> boxes) {
        this.integers = integers;
        this.boxes = boxes;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public List<Box> getBoxes() {
        return boxes;
    }
}
