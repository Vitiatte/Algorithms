package GrokkingAlgorithms.breadthFirstSearch;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Person person1 = new Person("B1", false);
        Person person2 = new Person("B2", false);
        Person person3 = new Person("B3", false);
        Person person4 = new Person("B4", false);
        Person person5 = new Person("B5", false);
        Person person6 = new Person("B6", false);
        Person person7 = new Person("B7", false);
        Person person8 = new Person("B8", false);
        Person person9 = new Person("B9", true);

        Set<Person> friendsPerson1 = new HashSet<>();
        Set<Person> friendsPerson2 = new HashSet<>();
        Set<Person> friendsPerson3 = new HashSet<>();

        friendsPerson1.add(person2);
        friendsPerson1.add(person4);
        friendsPerson1.add(person5);
        friendsPerson2.add(person3);
        friendsPerson3.add(person6);
        friendsPerson3.add(person7);
        friendsPerson3.add(person8);
        friendsPerson3.add(person9);

        Map<Person, Set<Person>> persons = new HashMap<>();
        persons.put(person1, friendsPerson1);
        persons.put(person2, friendsPerson2);
        persons.put(person3, friendsPerson3);

        System.out.println("Result: " + findDeveloper(person1, persons));
    }

    private static Person findDeveloper(Person startPerson, Map<Person, Set<Person>> persons) {
        Queue<Person> personQueue = new LinkedList<>();
        Set<Person> checkedPersons = new HashSet<>();
        personQueue.add(startPerson);
        while (!personQueue.isEmpty()) {
            Person person = personQueue.poll();
            System.out.println("Checking person: " + person);
            if (person.isDeveloper()) {
                return person;
            }
            if (persons.containsKey(person) && !checkedPersons.contains(person)) {
                personQueue.addAll(persons.get(person));
            }
            checkedPersons.add(person);
        }
        return null;
    }
}
