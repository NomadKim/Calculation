package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int lastResult=0;

        Scanner inward = new Scanner(System.in);

        System.out.println("Введите ваш пример");

        String userIn = inward.nextLine();
        userIn = userIn.replaceAll("\\s","");

        CompareNumbers compareNumbers= new CompareNumbers(userIn);
        int resultCompare = compareNumbers.romeOrArabic();
        if (resultCompare==0){
            return;
        }else if(resultCompare==1){
            ArabicNumbers arabicNumbers = new ArabicNumbers(userIn);
            int arabicResult = arabicNumbers.rightNumbers();
            if (arabicResult==0){
                return;
            }
            lastResult = arabicNumbers.calculationArabic();
            System.out.print("Ответ:"+lastResult);
        }else if(resultCompare == 2){
            String b = "";
            RomeNumbers romeNumbers = new RomeNumbers(userIn);
            int romeResult = romeNumbers.rightNumbers();
            if (romeResult==0){
                return;
            }
            b = romeNumbers.calculationRome();

            System.out.print("Ответ:" + b);
        }



    }
}
