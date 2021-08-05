package com.revature.codingChallenge1;

public class LongestCommonSequence {
    public static void main(String[] args) {
        String s1= "Minneapolis";
        String s2 = "Minnesota";

        System.out.println(LCS(s1,s2));
    }

    public static int LCS(String s1, String s2){

        //sizes or length
        int m = s1.length();
        int n = s2.length();

        //new Strings
//        String tmps1 = "" + s1;
//        String tmps2 = "" + s2;


        //base case

        // 2-d array for caching
        int[][] result = new int[m+1][n+1];


        //iterate through each m and n;
        for(int i = 1; i<=m ;i++){
            for(int j = 1; j<=n ; j++){
                //set column column to 0 and first row to 0;
//                if(i==0 || j ==0){
//                    result[i][j] = 0;
//                //once we reach 1 we compare i-1 or j-1 for the offset.
                 if(s1.charAt(i-1)==s2.charAt(j-1)){
                    result[i][j] = result[i-1][j-1] +1;
                }else{
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }

        return result[m-1][n-1];

    }

    public static int getMax(int num1, int num2){
        if(num1>num2){
            return num1;
        }
        return num2;
    }
}
