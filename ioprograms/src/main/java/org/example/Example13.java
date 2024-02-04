package org.example;

import org.example.student.Course;
import org.example.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Example13 {
    public static void main(String[] args) {
        Course jmc = new Course("JMC","Java MasterClass");
        Course pymc = new Course("PYC","Python MasterClass");
        List<Student> students = Stream.generate(()-> Student.getRandomStudent(jmc, pymc))
                .limit(5)
                .toList();
        students.forEach(s-> s.getEngagementRecords().forEach(System.out::println));

        Path path = Path.of("student.csv");
//        try{
//            for(Student student: students){
//                Files.write(path, student.getEngagementRecords(), StandardOpenOption.APPEND);
//            }
////            Files.writeString(p)
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        try{
            List<String>data = new ArrayList<>();
            for(Student student: students){
                data.addAll(student.getEngagementRecords());
            }
            Files.write(path, data);
//            Files.writeString(p)
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
