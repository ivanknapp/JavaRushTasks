package com.javarush.task.task24.task2411;

class WithInner {
    class Inner {}
}

public class Inner extends WithInner.Inner {
     //InheritInner() {} // He компилируется
    Inner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi = new WithInner();
        Inner ii = new Inner(wi);
    }
}