package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example9 {
    record Person(String firstname, String lastName){
        @Override
        public String toString() {
            return firstname +" "+lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Tushar", "Gupta"),
                new Person("Paramhansa", "Yogananda"),
                new Person("Yukteshwar","Giri")
        ));
        people.sort((o1,o2)->o1.lastName().compareTo(o2.lastName()));
        people.forEach(System.out::println);

        people.sort(Comparator.comparing(Person::lastName));
        people.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstname).reversed());
    }
}
