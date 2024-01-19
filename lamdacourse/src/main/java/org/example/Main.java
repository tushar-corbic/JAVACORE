package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    record Person(String firstname, String lastName){
        @Override
        public String toString() {
            return firstname +" "+lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Tushar", "Gupta"),
                new Person("Paramhansa", "Yogananda"),
                new Person("Yukteshwar","Giri")
        ));
        // using anonumous class
        var comparatorLastname = new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return o1.lastName().compareTo(o2.lastName());
            }
        };

//        people.sort(comparatorLastname);
        people.sort(new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return o1.lastName().compareTo(o2.lastName());
            }
        });

        people.sort((o1, o2)-> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);
    }
}