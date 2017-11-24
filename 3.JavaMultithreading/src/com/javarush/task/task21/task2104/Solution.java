package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;
    private int count = 0;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null || n.getClass() != getClass()) return false;
        if (n instanceof Solution) {

            Solution anotherObject = (Solution) n;

            return first == anotherObject.first && last == anotherObject.last;
        }
        return false;
    }

    public int hashCode() {
        int result = 1;
        result = (first == null ? 0:first.hashCode()) + (last==null?0:last.hashCode());
        return 31 + result;
    }

    public static void main(String[] args) throws InterruptedException {
/*        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));*/

        Solution solution = new Solution("s1","d2");
        Thread t = new Thread(){
            @Override
            public void run() {
                solution.count++;

            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                solution.count++;
            }
        };
        t.start();
        t2.start();

        System.out.println(solution.count);


/*
        Solution s1 = new Solution("Donald", "Duck");
        Solution s2 = new Solution("Donald", "d");

        System.out.println(s1.equals(s2));*/
    }
}
