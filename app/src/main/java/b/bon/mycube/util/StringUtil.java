package b.bon.mycube.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * 字符串工具
 */
public final class StringUtil {

    public static String getTimeFormatString(String format, Date date){
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.CHINA);
        return dateFormat.format(date);
    }

    public static String getNowTimeFormatString(String format){
        return getTimeFormatString(format,Calendar.getInstance().getTime());
    }
}
