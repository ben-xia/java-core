package com.ben.java.core.datetime;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ben-xia
 * @date 2021/05/15
 * @Description TODO
 **/
public class CalendarTest01 {

    @Test
    public void testCalendar(){
        Calendar itemDay = Calendar.getInstance();
        itemDay.add(Calendar.DAY_OF_MONTH, 0);
        itemDay.set(Calendar.HOUR_OF_DAY, 0);
        itemDay.set(Calendar.MINUTE, 0);
        itemDay.set(Calendar.SECOND, 0);
        itemDay.set(Calendar.MILLISECOND, 0);

        Date todayFrom = itemDay.getTime();

        itemDay.set(Calendar.HOUR_OF_DAY, 23);
        itemDay.set(Calendar.MINUTE, 59);
        itemDay.set(Calendar.SECOND, 59);
        itemDay.set(Calendar.MILLISECOND, 999);

        Date todayTo = itemDay.getTime();
        System.out.println(todayFrom+"--"+todayTo);
        System.out.println(Calendar.getInstance().get(Calendar.SECOND));
    }
}
