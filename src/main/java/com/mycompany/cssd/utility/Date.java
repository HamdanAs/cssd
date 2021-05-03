package com.mycompany.cssd.utility;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {
    private static final LocalDateTime date = LocalDateTime.now();
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static String formatted = date.format(format);
    
    public static String now(){
        return formatted;
    }
    
    public static String plusTwo(){
        LocalDateTime addTwo = date.plusDays(2);
        Date.formatted = addTwo.format(format);
        
        return formatted;
    }
}
