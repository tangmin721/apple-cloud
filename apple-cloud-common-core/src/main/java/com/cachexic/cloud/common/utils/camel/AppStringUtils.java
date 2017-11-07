package com.cachexic.cloud.common.utils.camel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驼峰式 转 下划线
 *
 * @author tangmin
 * @date 2017年3月2日
 */
public class AppStringUtils {

  public static final char UNDERLINE = '_';

  public static final char MIDLINE = '_';


  public static String camelToline(String param,char line) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      char c = param.charAt(i);
      if (Character.isUpperCase(c)) {
        sb.append(line);
        sb.append(Character.toLowerCase(c));
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static String camelToUnderline(String param) {
    return camelToline(param,UNDERLINE);
  }

  public static String camelToMidline(String param) {
    return camelToline(param,MIDLINE);
  }

  public static String underlineToCamel(String param) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      char c = param.charAt(i);
      if (c == UNDERLINE) {
        if (++i < len) {
          sb.append(Character.toUpperCase(param.charAt(i)));
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static String underlineToCamel2(String param) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    StringBuilder sb = new StringBuilder(param);
    Matcher mc = Pattern.compile("_").matcher(param);
    int i = 0;
    while (mc.find()) {
      int position = mc.end() - (i++);
      // String.valueOf(Character.toUpperCase(sb.charAt(position)));
      sb.replace(position - 1, position + 1,
          sb.substring(position, position + 1).toUpperCase());
    }
    return sb.toString();
  }

  /**
   * 补齐不足长度的字符前面补0
   *
   * @param length 长度
   * @param number 数字
   */
  public static String addZero(int length, int number) {
    String f = "%0" + length + "d";
    return String.format(f, number);
  }

  public static String addZero(int length, Long number) {
    String f = "%0" + length + "d";
    return String.format(f, number);
  }

  /**
   * 测试下
   */
  public static void main(String[] args) {
    String name = "dictCatlogController";
    System.out.println(camelToUnderline(name));
    String name33 = "dict_catlog_controller";
    System.out.println(camelToUnderline(name33));

    String name2 = "dict_catlog_controller";
    System.out.println(underlineToCamel(name2));

    String name3 = "dict_catlog_controller";
    System.out.println(underlineToCamel2(name3));

    System.out.println(addZero(10, 12112));
    System.out.println(addZero(10, 33l));
  }
}
