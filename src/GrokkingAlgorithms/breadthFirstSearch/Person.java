package GrokkingAlgorithms.breadthFirstSearch;

public class Person {
    private String name;
    private boolean isDeveloper;

    public Person(String name, boolean isDeveloper) {
        this.name = name;
        this.isDeveloper = isDeveloper;
    }

    public String getName() {
        return name;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
