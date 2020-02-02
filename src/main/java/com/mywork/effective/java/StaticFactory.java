package com.mywork.effective.java;

import java.util.Date;

public class StaticFactory {

    public static void main(String[] args){
        DateTimeProvider dateTimeProvider = DateTimeProvider.getDateTimeProvider();
        Date date = dateTimeProvider.getDate();
        System.out.println(date);

    }
}

final class  DateTimeProvider{

    private final Date date = new Date();

    public static DateTimeProvider dateTimeProvide = new DateTimeProvider();

    private DateTimeProvider(){
    }

    public Date getDate(){
        return date;
    }

    public static DateTimeProvider getDateTimeProvider(){
        return dateTimeProvide;
    }
}

