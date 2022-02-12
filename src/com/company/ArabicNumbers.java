package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicNumbers {

    static String regEx  = "[+/*\\-]";
    static int a;
    static int b;
    static String calculationNumbers;

    String mainString;
    static Pattern pattern = Pattern.compile(regEx);


    public ArabicNumbers(String mainString){
        this.mainString = mainString;
    }


    public int rightNumbers(){

        int result =0;

        Matcher matcher = pattern.matcher(mainString);
        int v = 0;
        int c = 0;

        if(matcher.find()) {
            v = matcher.start();
            calculationNumbers = String.valueOf(mainString.charAt(v));
            c++;
        }



        while (matcher.find()){
            c++;
        }


        if(v>2 || c>1){


            System.out.print("Неправильный ввод");
            return result;
        }

        String[] newStrings = mainString.split(regEx);



        try{
            a = Integer.parseInt(newStrings[0]);
            b = Integer.parseInt(newStrings[1]);


        }catch(Exception e){

            System.out.print("Неправильный ввод");
            return result;

        }

        if (a>10 || b>10){
            System.out.print("Неправильный ввод");
            return result;
        }

        return result+1;


    }

    public int calculationArabic(){

        Calculation calc = new Calculation(a, b, calculationNumbers);
        int result = calc.calc();
        return result;

    }

























}
