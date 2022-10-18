package com.example.fibonacci.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/fibonacci")
@RequiredArgsConstructor
public class FibonacciController {

    @GetMapping("/all")
    public int [] getFibonacciNumbers(@RequestParam Integer n){
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
    @GetMapping("/recursion")
    public int getFibonacciNumbersWithRecursion(@RequestParam Integer n){
        if (n == 1 || n == 2) {
            return 1;
        }
        return getFibonacciNumbersWithRecursion(n - 1) + getFibonacciNumbersWithRecursion(n - 2);
    }

    @GetMapping("/iterator")
    public int getFibonacciNumbersWithIterator(@RequestParam Integer n){
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = b + a;
            a = b;
            b = c;
        }
        return c;
    }

}


