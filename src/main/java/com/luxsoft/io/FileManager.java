package com.luxsoft.io;

import java.io.*;
import java.nio.file.*;
import java.util.Objects;

public class FileManager {
    public static int countFiles(String path) {
        File walkDir = new File(path);
        int count = 0;
        File[] dirList = walkDir.listFiles();
        for (File o : dirList) {
            if (!o.isDirectory()) {
                count++;
            } else {
                count += countFiles(o.getPath());
            }
        }
        return count;
    }

    public static int countDirs(String path) {
        File walkDir = new File(path);
        int count = 0;
        File[] dirList = walkDir.listFiles();
        for (File o : dirList) {
            if (o.isDirectory()) {
                count++;
                count += countFiles(o.getPath());
            }
        }
        return count;
    }

    public static void move(String from, String to)throws IOException {
        new File(from).renameTo(new File(to));
    }

    private static void copy(String from, String to) throws IOException {
        File sourceFile = new File(from);
        File[] listOfFiles = sourceFile.listFiles();
        Path destinationDirection = Paths.get(to);

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                Files.copy(file.toPath(), destinationDirection.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
