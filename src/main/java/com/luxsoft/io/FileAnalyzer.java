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
import java.net.URL;

public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        String dirname = "/Users/igor/study/java/excersize/home/data-structures/src/main/java/com/luxsoft/io/file0.txt";

        String to ="/Users/igor/study/java/excersize/home/data-structures/src/main/java/com/luxsoft/io/test2/file0.txt";
        new File(dirname).renameTo(new File(to));


//        File after = new File("/Users/igor/study/java/excersize/home/data-structures/src/main/java/com/luxsoft/io/test2/file0.txt");
//        boolean success = f.renameTo(after);
//        if (success) {
//            f = after;
//        }
//        System.out.println(f);



//        String parentPath = spec.getParent();
//        File parentFolder = spec.getParentFile();
//        RandomAccessFile f1 = new RandomAccessFile(f, "rw");
//        f1.writeChars();

//        boolean exists = f.createNewFile();
//        if (exists){
//            System.out.println("create new file");
//        }else{
//            System.out.println("work with ");
//        }

//        boolean isDir = f.isDirectory();
//        if (isDir == true){
//            String [] s = f.list();
//            for (int i =0; i<s.length; i++){
//                File f1 = new File(dirname + File.separator+s[i]);
//                if (f1.isDirectory()){
//                    System.out.println(s[i]+" являеться каталогом");
//                }else{
//                    System.out.println(s[i]+" являеться файлом");
//                }
//            }
//
//        }else{
//            System.out.println(dirname+" не являеться каталогом");
//        }
//        int size;
//       try( FileInputStream fis = new FileInputStream("FileAnalyzer.java")){
//           System.out.println("щбщее число доступных байтов" + (size=fis.available()));
//       }
/////////////////////////////////////////
//        String s = "ti kuku otkuda takoy \n to come to the \n of country";
//        byte [] barr = s.getBytes();
//        FileOutputStream f0 = null;
//        FileOutputStream f1 = null;
//        try {
//            f0 = new FileOutputStream("/Users/igor/study/java/excersize/home/data-structures/src/main/java/com/luxsoft/io/file0.txt");
//            f1 = new FileOutputStream("/Users/igor/study/java/excersize/home/data-structures/src/main/java/com/luxsoft/io/file1.txt");
//
//            for (int i = 0; i < barr.length; i += 2) {
//                System.out.println((char)barr[i]);
//                f0.write(barr[i]);
//            }
//            f1.write(barr);
//        }catch (IOException e){
//            System.out.println("f0"+f0.toString());
//        }finally {
//            try{
//                if(f0!=null){
//                    f0.close();
//                }
//            }catch (IOException e){}
//
//            try{
//                if(f1!=null){
//                    f1.close();
//                }
//            }catch (IOException e){}
//        }
//        System.out.println("f0"+f0.toString());
//        System.out.println("(c)");
 /////////////////////////////////////////////////////////
    }
}
