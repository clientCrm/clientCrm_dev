package zkz.bangong.utils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 格式规范工具类
 * @author mmmgdzl
 * @since 2019/3/28
 */
public class FormatUtil {

    /**
     * 获取日期(yyyy-MM-dd)
     */
    public static String formatDate(Date date) {
        LocalDateTime localDateTime = LocalDateTimeUtil.convertDateToLDT(date);
        String result = LocalDateTimeUtil.formatTime(localDateTime, "yyyy-MM-dd");
        return result;
    }

    /**
     * 获取时间(yyyy-MM-dd HH:mm:ss)
     */
    public static String formatTime(Date date) {
        LocalDateTime localDateTime = LocalDateTimeUtil.convertDateToLDT(date);
        String result = LocalDateTimeUtil.formatTime(localDateTime, "yyyy-MM-dd HH:mm:ss");
        return result;
    }

    /**
     * 获取简介
     */
    public static String getSmallDescribe(String describe) {
        String regex = "<[^>]*>";
        String result = describe.replaceAll(regex, "");
        if(result.length() > 255)
            result = result.substring(0, 255);
        return result;
    }

}
