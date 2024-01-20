package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example10 {
    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");
//        Student tim = new Student("AU", 2019, 30, "M",
//                true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        List<Student> studentList = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(10).toList();
        long maleStudent = studentList.stream().filter(s-> s.getGender().equals("M")).count();
        long femaleStudent = studentList.stream().filter(s->s.getGender().equals("F")).count();
        long firstrange = studentList.stream().filter(s-> s.getAge()<30).count();
        long secondrange = studentList.stream().filter(s->s.getAge()>60).count();
        System.out.println(studentList.stream().mapToInt(Student::getAge).summaryStatistics());
        studentList.stream().map(Student::getCountryCode).distinct().forEach(System.out::println);
        boolean stillActive= studentList.stream().map(Student::getAgeEnrolled).anyMatch(a->a>7);
        // list returned by toList in streams is unmodefiable
        // but with collec operations, I can get the modifiable list
        var longTimeLearners = studentList.stream().map(Student::getCountryCode).distinct().toArray();
        var learners = studentList.stream().map(Student::getCountryCode).distinct().collect(Collectors.toList());
        var unmodifieableList = studentList.stream().map(Student::getCountryCode).distinct().toList();
        Collections.shuffle(learners);
//        Collections.shuffle(unmodifieableList);
        // this will give the errors


    }

}

