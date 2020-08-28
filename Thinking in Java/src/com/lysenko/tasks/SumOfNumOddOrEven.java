package com.lysenko.tasks;

public class SumOfNumOddOrEven {
    public static void main(String[] args) {
        System.out.println(returnResult("123").toString());
        System.out.println(returnResult("124").toString());
        System.out.println(returnResult("234").toString());
        System.out.println(isPalindrome("1001").toString());
        System.out.println(isPalindrome("125000521").toString());
        System.out.println(isPalindrome("1234").toString());
        System.out.println(isPalindrome("1234567890").toString());
    }

    private static Result returnResult(String numberAsString) {
        char[] digitsInNumber = numberAsString.toCharArray();
        int digitsInt = 0;
        for (char digits : digitsInNumber) {
            digitsInt += Integer.valueOf(digits + "");
        }
        if (digitsInt % 2 == 0 && digitsInt != 0) {
            return new Result("even", digitsInt);
        }
        return new Result("odd", digitsInt);
    }

    private static Result isPalindrome(String numberAsString) {
        char[] digitsInNumber = numberAsString.toCharArray();
        boolean flag = false;
        int leftIndex = 0;
        int rightIndex = numberAsString.length() - 1;
        while (leftIndex < numberAsString.length()) {
            if (digitsInNumber[leftIndex] == digitsInNumber[rightIndex]) {
                flag = true;
            }
            leftIndex++;
            rightIndex--;
        }
        if (flag) {
            return new Result("palindrome", Integer.valueOf(numberAsString));
        }
        return new Result("not palindrome", Integer.valueOf(numberAsString));
    }
}

class Result {
    private String name;
    private int value;

    public Result(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{name}=" + name + " " + "{value}=" + value;
    }
}