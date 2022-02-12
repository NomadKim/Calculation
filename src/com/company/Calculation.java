package com.company;

public class Calculation {
    public int a;
    public int b;
    public String c;

    public Calculation(int firstvalue, int secondvalue, String thirdvalue){
        this.a = firstvalue;
        this.b = secondvalue;
        this.c = thirdvalue;
    }

    public int calc(){
        int result = 0;
        switch (c){
            case "+": result = a + b;
                break;
            case "-": result = a - b;
                break;
            case "*": result = a * b;
                break;
            case "/": result = a / b;
                break;
        }
        return result;
    }

}
