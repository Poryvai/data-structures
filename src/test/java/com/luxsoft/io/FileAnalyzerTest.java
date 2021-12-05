package com.luxsoft.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileAnalyzerTest {
    private static final String PATH_EMPTY_TEST_FILE = "/Users/igor/study/java/excersize/home/data-structures/src/test/java/com/luxsoft/io/resources/empty.txt";
    private static final String PATH_TEST_FILE = "/Users/igor/study/java/excersize/home/data-structures/src/test/java/com/luxsoft/io/resources/duck.txt";
    private static final String PATH_NOT_FOUND_FILE = "/Users/igor/study/java/excersize/home/data-structures/src/test/java/com/luxsoft/io/resources/bunny.txt";

    @Test
    void testReturnTheNumberOfWordMatchesInExistFile() throws IOException {
        String fileContent = FileAnalyzer.readContent(PATH_TEST_FILE);
        int actual = FileAnalyzer.getCountWordRepeats(fileContent, "duck");
        assertEquals(8, actual);
    }

    @Test
    void testTryToReturnOfCountsNotExistWord() throws IOException {
        String fileContent = FileAnalyzer.readContent(PATH_TEST_FILE);
        int actual = FileAnalyzer.getCountWordRepeats(fileContent, "ducker");
        assertEquals(0, actual);
    }

    @Test
    void testReturnTheNumberOfWordMatchesInEmptyFile() throws IOException {
        String fileContent = FileAnalyzer.readContent(PATH_EMPTY_TEST_FILE);
        int actual = FileAnalyzer.getCountWordRepeats(fileContent, "duck");
        assertEquals(0, actual);
    }

    @Test
    void testThrowsExceptionPathDoNotExistFile() throws IOException {
        assertThrows(FileNotFoundException.class, () -> {
            FileAnalyzer.readContent(PATH_NOT_FOUND_FILE);
        });
        }

    @Test
    void testСheckForWordNotContainedInTheSentences() {
        List<String> expected = new ArrayList<>();
        List<String> actual = FileAnalyzer.getSentencesContainingTheSearchWord(PATH_TEST_FILE, "bunny");
        assertEquals(expected, actual, "Arrays differ");
    }

    @Test
    void testReturnTheSentencesWithWordAndEndsWithASpecialSplit() throws IOException {
        String fileContent = FileAnalyzer.readContent(PATH_TEST_FILE);
        List<String> actual = FileAnalyzer.getSentencesContainingTheSearchWord(fileContent, "duck");
        assertEquals(new ArrayList<String>(), actual, "Lists do not match");
    }
}
