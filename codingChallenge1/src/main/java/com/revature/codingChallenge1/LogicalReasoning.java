package com.revature.codingChallenge1;

import java.util.ArrayList;
import java.util.List;

public class LogicalReasoning {

    public static void main(String[] args) {
        System.out.println(factorization(5));
        System.out.println(LogicalReasoning("PROCESSOR"));

    }

    public static String LogicalReasoning(String s){
        String encrypter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        StringBuilder res = new StringBuilder();
        boolean oddSwitch = true;
        boolean evenSwitch = true;

        for(int i = 0 ; i< s.length(); i++){
            System.out.println("current letter:" + s.charAt(i));
            int temp = encrypter.indexOf(s.charAt(i)) +1;
            int[] factors = factorization(temp);



            if(factors.length==1){
                char tempSTR = encrypter.charAt(factors[0]-1);
                res.append(tempSTR+"1");
            }else{
                if(factors[0] == factors[1]){
                    String tempSTR = String.valueOf(encrypter.charAt(factors[0]-1));
                    String temp2 = String.valueOf(factors[1]);
                    res.append(tempSTR+temp2);
                }else if(temp%2==0 && evenSwitch){
                    String tempSTR = String.valueOf(encrypter.charAt(factors[1]-1));
                    String temp2 = String.valueOf(factors[0]);
                    res.append(tempSTR+temp2);
                    evenSwitch = false;
                }else if(temp % 2 ==1 && oddSwitch){
                    String tempSTR = String.valueOf(encrypter.charAt(factors[0]-1));
                    String temp2 = String.valueOf(factors[1]);
                    res.append(tempSTR+temp2);
                    oddSwitch = false;
                }else if(temp%2==0 && !evenSwitch){
                    String tempSTR = String.valueOf(encrypter.charAt(factors[1]-1));
                    String temp2 = String.valueOf(factors[0]);
                    res.append(tempSTR+temp2);
                    evenSwitch = true;
                }else if(temp%2==1 && !oddSwitch){
                    String tempSTR = String.valueOf(encrypter.charAt(factors[0]-1));
                    String temp2 = String.valueOf(factors[1]);
                    res.append(tempSTR+temp2);
                    oddSwitch = true;
                }
            }
            System.out.println("result " + res);
            System.out.println("_-----------------");
        }
        return res.toString();
    }


    public static int[] factorization( int num){
        int stopper = (int) Math.ceil(Math.sqrt(num))+2;
        List<Integer> factors = new ArrayList<>();
        int[] result = new int[2];
        System.out.println("Stopper: " + stopper);


       for (int i = 1; i< stopper; i++){
           if(i*i == num){
               factors.add(i);
               factors.add(i);
           }else if(num % i ==0){
               factors.add(i);
           }
       }
       if(factors.size()==1 || factors.size()==0){
           int[] prime_res = new int[] {num};
           return prime_res;
       }else {
           result[0] = factors.get(factors.size()-2);
           result[1] = factors.get(factors.size()-1);
       }
        System.out.println(result[0] +" " + result[1]);
       return result;
    }
}
