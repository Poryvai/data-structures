package com.luxsoft.io;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagerITest {
    private static FileManager fileManager = new FileManager();
    private static String path = "/Users/igor/study/java/excersize/home/data-structures/src/main/java/com/luxsoft/io/test";

    @BeforeEach
    public void generateDataTest()throws IOException {
        File makeDirectionOne = new File(path+File.separator+"one");
        File makeDirectionTwo = new File(path+File.separator+"two");
        File makeDirectionThree = new File(path+File.separator+"three");
        makeDirectionOne.mkdirs();
        makeDirectionTwo.mkdirs();
        makeDirectionThree.mkdirs();

        File createFileOne = new File(makeDirectionOne.getPath()+File.separator+"testFileOne.txt");
        File createFileTwo = new File(makeDirectionOne.getPath()+File.separator+"testFileTwo.txt");
        File createFileThree = new File(makeDirectionTwo.getPath()+File.separator+"testFileOne.txt");
        File createFileFour = new File(makeDirectionTwo.getPath()+File.separator+"testFileTwo.txt");
        createFileOne.createNewFile();
        createFileTwo.createNewFile();
        createFileThree.createNewFile();
        createFileFour.createNewFile();

        File createFileFive = new File(path+File.separator+"testFileTwo.txt");
        File createFileSix = new File(path+File.separator+"testFileOne.txt");
        File createFileSeven = new File(path+File.separator+"testFileThree.txt");
        createFileFive.createNewFile();
        createFileSix.createNewFile();
        createFileSeven.createNewFile();
    }

    @Test
    public void testReturnCountsOfFilesInFolders(){
        int counts = FileManager.countFiles(path);
        assertEquals(9, counts);
    }

    @Test
    public void testReturnZeroCountOfFileInEmptyFolder(){
        int counts = FileManager.countFiles(path+File.separator+"three");
        assertEquals(0, counts);
    }

    @Test
    public void testReturnCountDirectoriesInDirectoryAndSubdirectories() {
        int actual = FileManager.countDirs(path);
        assertEquals(7, actual);
    }


}
