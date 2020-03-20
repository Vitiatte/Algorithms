package GrokkingAlgorithms.shortestPathFirstAlgorithm;

import javafx.util.Pair;

import java.util.*;

public class SpfApp {
    //<Element, <Its neighborhoods, Weight>>
    private static HashMap<String, HashMap<String, Integer>> weights;

    //<Element, <Parent of the element with smallest weight, Smallest sum of all weight to get to the element>>
    private static HashMap<String, Pair<String, Integer>> result;

    public static void main(String[] args) {
        initialize();

        System.out.println(findShortestPath("A"));
    }

    private static String findShortestPath(String startElement) {

        result.put(startElement, new Pair<>(startElement, 0));
        Queue<String> queue = new LinkedList<>();
        queue.add(startElement);
        do {
            String parent = queue.poll();
            if (Objects.isNull(weights.get(parent))) {
                break;
            }
            Set<String> neighbors = weights.get(parent).keySet();
            int bestParentWeight = result.get(parent).getValue();
            for (String neighbor : neighbors) {
                Pair<String, Integer> pair = result.get(neighbor);
                int weightToElementOverParent = bestParentWeight + weights.get(parent).get(neighbor);

                if (Objects.isNull(pair) || weightToElementOverParent < pair.getValue()) {
                    result.put(neighbor, new Pair<>(parent, weightToElementOverParent));
                }
            }
            queue.addAll(neighbors);
        } while (!queue.isEmpty());
        return bestPath(startElement, "F");
    }

    private static String bestPath(String startElement, String endElement) {
        StringBuilder builder = new StringBuilder();
        String lastPartOfPath = endElement;
        builder.append(endElement).append(" -> ");
        while (!result.get(lastPartOfPath).getKey().equals(startElement)) {
            lastPartOfPath = result.get(lastPartOfPath).getKey();
            builder.append(lastPartOfPath).append(" -> ");
        }
        builder.append(startElement).append(" || SUM: ").append(result.get(endElement).getValue());
        return builder.toString();
    }


    // ------- Util methods -------
    private static void initialize() {
        weights = new HashMap<>();
        addElementToWeight("A", "B", 5);
        addElementToWeight("A", "C", 3);
        addElementToWeight("B", "D", 4);
        addElementToWeight("C", "D", 8);
        addElementToWeight("C", "F", 15);
        addElementToWeight("D", "F", 4);
        weights.put("F", null);

        result = new HashMap<>();
    }

    private static void addElementToWeight(String ell, String neighbor, int weight) {
        HashMap<String, Integer> map = weights.get(ell);
        if (Objects.isNull(map)) {
            map = new HashMap();
            weights.put(ell, map);
        }
        map.put(neighbor, weight);
    }
}
