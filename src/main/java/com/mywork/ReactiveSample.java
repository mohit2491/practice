package com.mywork;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ReactiveSample {

    public static void main (String[] args){
        Flowable.interval(1, 1, TimeUnit.SECONDS) //can be any data source
                .map(e -> transform(e))
                .subscribe(System.out::println,
                 err -> System.out.println("ERROR" + err), //Gracefully we get the error rather than it is thrown
                 () -> System.out.println("Done"));

        sleep(10000);
    }

    public static long transform(long value){
        if(value == 5)
            throw new RuntimeException("Something went wrong"); //blow up here, no further data transformation
        return value*2;
    }

    private static boolean sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
            return true;
        } catch (InterruptedException e)
        {
            return false;
        }
    }
}
