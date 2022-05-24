package com.fis.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {


    public static int MaximumOfMonth (String searchMonth) {

        int year = Integer.parseInt(searchMonth.substring(0, 4));
        int month = Integer.parseInt(searchMonth.substring(5, 7));
        int day = 1;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        cal.set(year, month-1, day); //월은 -1해줘야 해당월로 인식

        System.out.println(dateFormat.format(cal.getTime()));

        System.out.println("해당년도: "+cal.get(Calendar.YEAR));
        System.out.println("해당월: "+(cal.get(Calendar.MONTH)+1)); //보여줄때 +1로 하여 사람기준으로 설정
        System.out.println("첫번째 일: "+cal.getMinimum(Calendar.DAY_OF_MONTH));

        System.out.println("마지막 일(현재 날짜 기준 최대수): "+cal.getActualMaximum(Calendar.DAY_OF_MONTH)); //기본적으로 이걸 사용
        System.out.println("마지막 일(Calender이 가진 최대수): "+cal.getMaximum(Calendar.DAY_OF_MONTH));

        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
