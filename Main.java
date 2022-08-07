package com.jdbc;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
	    String s = "ABCD";
        long possibleSolutions = Main.factorial(s.length());
        result(s, "", 0);
    }
    public static void result(String s, String perm, int index){
        if(s.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            String st = s.substring(0,i) + s.substring(i+1);
            result(st, perm+curr, index+1);
        }
    }

    static Long factorial(int s){
        if(s==1) return 1L;
        if(s==0) return 1L;
        return s*factorial(s-1);
    }


}
