package org.example;

import org.example.student.Course;
import org.example.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Example14 {
    public static void main(String[] args) {
        Course jmc = new Course("JMC","Java Masterclass");
        Course pumc = new Course("PYMC", "Python Masterclass");
        String dilimiter = ", "+System.lineSeparator();
        List<String> studentList = Stream.generate(()->Student.getRandomStudent(jmc, pumc)).limit(2).map(Student::toJSON).toList();

        studentList.forEach(System.out::println);

        String students = Stream.generate(()->Student.getRandomStudent(jmc, pumc)).limit(2).map(Student::toJSON).collect(Collectors.joining(",","[","]"));
        System.out.println(students);

        try{
            Files.writeString(Path.of("students.json"),students);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
