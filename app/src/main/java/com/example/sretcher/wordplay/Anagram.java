package com.example.sretcher.wordplay;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by sretcher on 3/1/2017.
 */

public class Anagram {

    private ArrayList<String> myWords = new ArrayList<>();


    public Anagram(Context myContext, String fileName )
    {

        readWords(myContext,fileName);

    }

public void readWords(Context myContext, String fileName) {

    BufferedReader myReader;

    try {

        InputStream fin = myContext.getAssets().open(fileName);

        myReader = new BufferedReader(new InputStreamReader(fin));


        String line = myReader.readLine();
        while (line != null) {
            Log.i("Anagram", line);

            String line1 = line.replaceAll("\\W", " ");

            String[] words = line1.split("\\s");

            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals(""))
                    myWords.add(words[i]);
            }

            line = myReader.readLine();
        }

    } catch (IOException e) {

        Log.i("Anagram", "No file found");

    }
}

    public ArrayList<String> getWords()
    {

        return myWords;

    }

    public boolean isAnagram(String word1,String word2)
    {
        int numLetters=0;

        for(int i=0;i<word1.length()-1;i++)
        {

            if(word1.length()!=word2.length())
            {

                return false;

            }
            else if(word1.contains(word2.charAt(i)+""))
            {

                    numLetters++;

            }



        }

        return numLetters==(word1.length()-1);

    }


    public String getRandomWord()
    {
        return getWords().get((int)(Math.random()*myWords.size()));
    }

public String scramble(String letters)
{

for(int i=0;i<letters.length();i++)


}





}









