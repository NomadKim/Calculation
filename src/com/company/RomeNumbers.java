package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomeNumbers {

    static String regEx  = "[+/*\\-]";
    static int a;
    static int b;
    static String calculationNumbers;
    String mainString;
    static Pattern pattern = Pattern.compile(regEx);

    public RomeNumbers(String b){
        this.mainString = b;
    }



    public static int romanToInt(String s) {

            int output = 0;

            Map<String ,Integer> map = new HashMap<>();
            map.put("I",1);
            map.put("V",5);
            map.put("X",10);
            map.put("L",50);
            map.put("C",100);
            map.put("D",500);
            map.put("M",1000);

            if(s.length()==0) return 0;
            if(s.length() ==1) return map.get(String.valueOf(s.charAt(0)));

            for(int i = 0;i<(s.length()-1);i++){
                if(map.get(String.valueOf(s.charAt(i)))>=
                        map.get(String.valueOf(s.charAt(i+1)))){
                    output = output + map.get(String.valueOf(s.charAt(i)));
                }else{
                    output = output - map.get(String.valueOf(s.charAt(i)));
                }

            }
            output = output + map.get(String.valueOf(s.charAt(s.length()-1)));
            return output;
    }

    public static String intToRoman(int s) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(9, "IX");
        map.put(8, "VIII");
        map.put(20, "XX");
        map.put(10, "X");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXX");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(100, "C");

        if (s>10){
            String newString = String.valueOf(s);
            char[] a = newString.toCharArray();
            String b = (a[0])+"0";
            String c = String.valueOf(a[1]);
            int d = Integer.parseInt(b);
            int e = Integer.parseInt(c);
            String f = map.get(d);
            String fg = map.get(e);
            return f+fg;
        }else if(s==0){
            return "0";
        }else if(s<0){
            int lkl = s-s-s;

            return "-"+map.get(lkl);
        }
        else{
            return map.get(s);

        }
    }

    public int rightNumbers(){

        int result =0;

        Matcher matcher = pattern.matcher(mainString);
        int v;
        int c = 0;

        if(matcher.find()) {
            v = matcher.start();
            calculationNumbers = String.valueOf(mainString.charAt(v));
            c++;
        }else{
            return result;
        }

        while (matcher.find()){
            c++;
        }

        if(c>1){
            System.out.print("Неправильный ввод");
            return result;
        }

        String[] newStrings = mainString.split(regEx);
        try {
            a = romanToInt(newStrings[0]);
            b = romanToInt(newStrings[1]);

        }catch (Exception e){
            System.out.print("Неправильный ввод");
            return result;
        }

        if (a>10 || b>10){
            System.out.print("Неправильный ввод");
            return result;
        }
        return result+1;


    }

    public String calculationRome(){

        Calculation calc = new Calculation(a, b, calculationNumbers);
        int result = calc.calc();
        return intToRoman(result);

    }




}
