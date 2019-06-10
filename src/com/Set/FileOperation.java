/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/28 01:00
 */

package com.Set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by robin on 2019/1/28.
 */
public class FileOperation {

    public static boolean readFile(String filename, ArrayList<String> words){

        if(filename == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }
        Scanner scanner;

        try {
            File file = new File(filename);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else{
                System.out.println("file.exists: " + file.exists());
                return false;
            }
        }catch (IOException e){
            System.out.println("Cannot open " + filename);
            return false;
        }

        if(scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for(int i = start + 1; i <= contents.length();){
                if(i == contents.length() || !Character.isLetter(contents.charAt(i))){
                    String word = contents.substring(start, i).toLowerCase();
                    word = word.trim();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                }else
                    i++;
            }
        }
        return true;


    }

    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i)))
                return start;
        }
        return s.length();
    }

}
