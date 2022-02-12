package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareNumbers {

    String mainString;

    public CompareNumbers(String mainString){
        this.mainString = mainString;
    }

        static Pattern arabicPattern = Pattern.compile("[1-9]");
        static Pattern pattern = Pattern.compile("[0-9+\\-*/]");

        static Pattern romePattern = Pattern.compile("[IVXLC+\\-*/]");
        static Pattern firstromePattern = Pattern.compile("[IVXLC]");


    public int romeOrArabic(){
        if (mainString.isEmpty()){
            System.out.print("Неправильный ввод");
            return 0;
        }
        int returnAnswer = 0;
        char ghgj = mainString.charAt(0);
        String d = String.valueOf(ghgj);
            Matcher greate = arabicPattern.matcher(d);
            Matcher second = firstromePattern.matcher(d);

            if (greate.find()){
                int i = 1;
                while(i <= mainString.length()-1){
                    String lkk;
                    char kolo = mainString.charAt(i);
                    lkk = String.valueOf(kolo);
                    Matcher third = pattern.matcher(lkk);
                    if(!third.find()){
                        System.out.println("Неправильный ввод");
                        return returnAnswer;
                    }

                    i++;
                }
                returnAnswer =1;
                return returnAnswer;
            }else if(second.find()){
                int i = 1;
                while(i <= mainString.length()-1){
                    String lkk;
                    char kolo = mainString.charAt(i);
                    lkk = String.valueOf(kolo);
                    Matcher third = romePattern.matcher(lkk);
                    if(!third.find()) {
                        System.out.println("Неправильный ввод");
                        return returnAnswer;
                    }
                    i++;
                }
                returnAnswer = 2;
                return returnAnswer;
            }else{
                System.out.println("Вы ввели неправельные значения");
                return returnAnswer;
            }
        }
    }
