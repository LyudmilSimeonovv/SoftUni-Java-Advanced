package com.company.Stekove_Opashki._exersises;import java.util.ArrayDeque;import java.util.Arrays;import java.util.Collections;import java.util.Scanner;public class BasicStackOperations_02 {    public static void main(String[] args) {        Scanner scanner = new Scanner(System.in);        String[] input = scanner.nextLine().split("\\s+");        int n = Integer.parseInt(input[0]);        int s = Integer.parseInt(input[1]);        int x = Integer.parseInt(input[2]);        ArrayDeque<Integer> numbers = new ArrayDeque<>();        int[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))                .mapToInt(Integer::parseInt).toArray();        for (int i = 0; i < n; i++) {            numbers.push(inputNumbers[i]);        }        for (int i = 0; i < s; i++) {            numbers.pop();        }        if (numbers.isEmpty()) {            System.out.println(0);        } else {            if (numbers.contains(x)) {                System.out.println("true");            } else {                System.out.println(Collections.min(numbers));            }        }    }}