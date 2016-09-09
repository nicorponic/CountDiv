/*
Write a function:

class Solution { public int solution(int A, int B, int K); }
that, given three integers A, B and K, returns the number of integers within 
the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }
For example, for A = 6, B = 11 and K = 2, your function should return 3, 
because there are three numbers divisible by 2 within the range [6..11], 
namely 6, 8 and 10.

Assume that:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
Copyright 2009–2016 by Codility Limited. 
All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
package countdiv;

public class CountDiv {

    public static void main(String[] args) {
        int A = 6, B = 11, K = 2;

        //store in integer b the times that K can divide B
        int b = B / K;
        //store in integer a the times that K can divide A-1. If A is negative then int a equals 0
        int a = (A > 0 ? (A - 1) / K : 0);
        //if A equals zero then add 1 to integer b
        if (A == 0) {
            b++;
        }
        //print the difference between b and a. 
        System.out.println(b - a);
    }

    public static int solution1(int A, int B, int K) {
        if (B < K) {
            return 0;
        }
        int num1 = A / K;
        if (A % K != 0) {
            num1++;
        }
        int num2 = B / K;

        return num2 - num1 + 1;
    }

    public int solution2(int A, int B, int K) {
        int b = B / K + 1;  // From 0 to B the integers divisible by K
        int a = A / K + 1;  // From 0 to A the integers divisible by K

        if (A % K == 0) { // "A" is inclusive; if divisible by K then
            --a;        //   remove 1 from "a"
        }
        return b - a;     // return integers in range
    }

    public int solution3(int A, int B, int K) {
        int offsetForLeftRange = 0;
        if (A % K == 0) {
            ++offsetForLeftRange;
        }

        return (B / K) - (A / K) + offsetForLeftRange;
    }

}
