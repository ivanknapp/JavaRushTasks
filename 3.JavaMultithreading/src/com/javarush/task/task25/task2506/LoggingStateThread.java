package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    @Override
    public void run() {
        Thread.State currentState = thread.getState();
        System.out.println(currentState);

        while (!currentState.equals(State.TERMINATED)){
            Thread.State newState = thread.getState();
            if (!currentState.equals(newState)){
                System.out.println(newState);
                currentState = newState;
            }
        }
        interrupt();
    }

    public LoggingStateThread(Thread target) {
        thread = target;
    }
}
