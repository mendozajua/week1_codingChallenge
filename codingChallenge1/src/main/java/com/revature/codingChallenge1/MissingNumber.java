package com.revature.codingChallenge1;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr1={7,5,6,1,4,2};

        int[] arr2={5,3,1,2};

        System.out.println("test case 1: answer = 3, my answer: " + findMissingNumber(arr1));
        System.out.println("------------------------------------");
        System.out.println("test case 2: answer = 4, my answer: " + findMissingNumber(arr2));

    }

    public static int findMissingNumber(int[] arr){
        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[arr.length-1];

        int missingNum = 0;

        int counter = 0;

        for(int i = min ; i < max ; i++){
            if(arr[counter] != i){
                missingNum = i;
                break;
            }
            counter++;
        }

        return missingNum;
    }
}
