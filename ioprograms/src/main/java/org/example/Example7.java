package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Example7 {
    public static void main(String[] args) {
        Path path = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor(Integer.MAX_VALUE);
        try{
            Files.walkFileTree(path, statsVisitor);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static class StatsVisitor extends SimpleFileVisitor<Path> {
        private int printLevel;
        private Path initialPath = null;
        private final Map<Path, Map<String, Long>> folderSizes = new LinkedHashMap<>();
        private int initialCount;

        private static final String DIR_CNT = "DirCount";
        private static final String FILE_SIZE = "fileSize";
        private static final String File_CNT = "fileCount";

        public StatsVisitor(int printLevel){
            this.printLevel = printLevel;
        }
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);
            if(initialPath==null){
                initialPath = dir;
                initialCount = dir.getNameCount();
            }else{
                int relativeLevel = dir.getNameCount()-initialCount;
                if(relativeLevel==1){
                    folderSizes.clear();
                }
                folderSizes.put(dir, new HashMap<>());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);

            var parentMap = folderSizes.get(file.getParent());
            if(parentMap!=null){
                long fileSize = attrs.size();
                parentMap.merge(FILE_SIZE, fileSize, (o,n)->o+=n);
                parentMap.merge(File_CNT, 1L, Math::addExact);
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return super.postVisitDirectory(dir, exc);
        }
    }
}
