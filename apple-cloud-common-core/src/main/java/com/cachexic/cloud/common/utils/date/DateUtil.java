package com.cachexic.cloud.common.utils.date;

import com.cachexic.cloud.common.exceptions.BizException;
import com.cachexic.cloud.common.exceptions.BizExceptionEnum;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * @author tangmin
 * @Description: 日期工具类 简单封装常用的方法，更多的用法直接用 org.apache.commons.lang3.time.DateFormatUtils;
 * org.apache.commons.lang3.time.DateUtils;
 * @date 2017-09-11 19:00:32
 */
public class DateUtil {

  private static final String DATE_PATTERNS = "yyyy-MM-dd";
  private static final String DATE_TIME_PATTERNS = "yyyy-MM-dd HH:mm:ss";

  public static Date parseDate(String dateStr) {
    Date date = null;
    try {
      date = DateUtils.parseDate(dateStr, DATE_PATTERNS);
    } catch (ParseException e) {
      throw new BizException(BizExceptionEnum.PARSE_DATE_ERROR);
    }
    return date;
  }

  public static Date parseDateTime(String dateStr) {
    Date date = null;
    try {
      date = DateUtils.parseDate(dateStr, DATE_TIME_PATTERNS);
    } catch (ParseException e) {
      throw new BizException(BizExceptionEnum.PARSE_DATE_ERROR);
    }
    return date;
  }

  public static Date parseDatePatterns(String dateStr, String parsePatterns) {
    Date date = null;
    try {
      date = DateUtils.parseDate(dateStr, parsePatterns);
    } catch (ParseException e) {
      throw new BizException(BizExceptionEnum.PARSE_DATE_ERROR);
    }
    return date;
  }

  public static String formatDate(Date date) {
    return DateFormatUtils.format(new Date(), DATE_PATTERNS);
  }

  public static String formatDateTime(Date date) {
    return DateFormatUtils.format(new Date(), DATE_TIME_PATTERNS);
  }

  public static String formatDatePatterns(Date date, String parsePatterns) {
    return DateFormatUtils.format(new Date(), parsePatterns);
  }
}
