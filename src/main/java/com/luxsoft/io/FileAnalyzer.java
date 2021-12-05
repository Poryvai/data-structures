package com.luxsoft.io;


/*Используем классы FileInputStream, FileOutputStream, File
Практика:
1: Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:
1) путь к файлу
2) слово
Usage:
java FileAnalyzer C:/test/story.txt duck

Выводит:
1) Кол-во вхождений искомого слова в файле
2) Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!").
Каждое предложение выводится с новой строки.*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        String pathToFile = args[0];
        String word = args[1];
        String fileContent = readContent(pathToFile).toLowerCase();

        int wordOccurrencesInFile = getCountWordRepeats(fileContent, word);
        List<String> containWordSentences = getSentencesContainingTheSearchWord(fileContent, word);

        printCountWordRepeats(wordOccurrencesInFile, word);
        printSentencesContainingTheSearchWord(containWordSentences, word);
    }

    public static String readContent(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        if (!file.isFile()) {
            throw new FileNotFoundException("File not found: " + pathToFile);
        }
        FileInputStream textFile = new FileInputStream(file);
        byte[] fileContent = textFile.readAllBytes();
        textFile.close();

        return new String(fileContent);
    }

    public static int getCountWordRepeats(String fileContent, String word) {
        Pattern pattern = Pattern.compile("\s*" + word.toLowerCase() + "\s*[,.?!]*");
        Matcher matcher = pattern.matcher(fileContent.toLowerCase());

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static List<String> getSentencesContainingTheSearchWord(String fileContent, String word) {
        Pattern pattern = Pattern.compile("\\s*[^.!?]*" + word.toLowerCase() + "\\s*[^.!?]*[.!?]");
        Matcher matcher = pattern.matcher(fileContent.toLowerCase());

        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group().trim());
        }
        return sentences;
    }

    private static void printCountWordRepeats(int count, String word) {
        System.out.println("Found " + count + " repeats of the word " + word.toUpperCase() + " in the text");
    }

    private static void printSentencesContainingTheSearchWord(List<String> sentences, String word) {
        for (String sentence : sentences) {
            System.out.println(sentence.replaceAll(word, word.toUpperCase()));
        }
    }

}

