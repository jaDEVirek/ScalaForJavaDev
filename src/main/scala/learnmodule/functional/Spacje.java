package org.jadevirek.learnmodule.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Spacje
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        List<String> SMS = new ArrayList<>();
        while(true)
        {
            String line = input.nextLine();
            SMS.add(line);
            if(line.contains("."))
                break;
        }
        String sentences = "";
        for(String sentence : SMS)
        {
            String[] words = sentence.split(" ");
            for(String word : words)
            {
                String first_letter = word.substring(0, 1);
                String big_letter = first_letter.toUpperCase();
                word = word.substring(1, word.length());
                word = big_letter + word;
                sentences += word;
            }
            sentences += "\n";
        }
        System.out.println(sentences);
        input.close();
    }
}