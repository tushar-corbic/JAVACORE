package org.example;

import java.io.File;
import java.io.IOException;

public class Example1 {
    public static void main(String[] args) throws IOException {
        String filename = "testing.csv";

        File file = new File(filename);
        System.out.println(file.getAbsolutePath()+" " +file.getCanonicalPath());
        for(File f : File.listRoots()){
            System.out.println(f);
        }

        File ff = new File("/testing.csv");
        System.out.println(ff.getAbsolutePath());
    }
}
// there is only file and filereader in io package, and filreader user file inside of it
// in nio, there is path, paths and files. all the functinos in paths are static and file uses path as instance to work.
// path here is interface
