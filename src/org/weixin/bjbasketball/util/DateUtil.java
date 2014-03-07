package org.weixin.bjbasketball.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * @description: 比较时间是否在一年当中的同一周
     * @author: tanyang
     * @DATE: 2014-2-19 下午04:13:40
     */
    public static boolean isOneWeekend(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        int a = c1.get(Calendar.WEEK_OF_YEAR);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        int b = c2.get(Calendar.WEEK_OF_YEAR);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 把yyyy-MM-dd HH:mm:ss 字符串 格式的日期格式化成 Date
     * @param str 需要格式的字符串
     * @return 异常返回当前Date
     */
    public static Date string2Date(String str){
        if(str!=null&&!"".equals(str)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(str);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * @description: 获取本周六的时间
     * @author: tanyang
     * @DATE: 2014-2-19 下午05:00:24
     * @param date1
     * @return
     */
    public static Date getSunday(Date date1) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.DAY_OF_YEAR, 7 - calendar
                .get(Calendar.DAY_OF_WEEK));
        return calendar.getTime();
    }
}
