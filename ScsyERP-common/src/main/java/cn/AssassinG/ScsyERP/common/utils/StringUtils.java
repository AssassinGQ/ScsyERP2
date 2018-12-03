package cn.AssassinG.ScsyERP.common.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static final String NUMBER_SOURCES = "1234567890";
    public static final String UPPERCASE_ALPHA_SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_ALPHA_SOURCES = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHA_SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String getRandomStr(int length){
        char[] ret = new char[length];
        Random random = new Random();
        for(int i = 0; i < length; i++)
            ret[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        return new String(ret);
    }

    public enum StrType{
        NUMBER(1), UPPERCASE(2), LOWERCASE(3), ALPHA(4), ALL(5);
        private int Value;
        private StrType(int value){
            this.Value = value;
        }

        public int getValue() {
            return Value;
        }
    }

    /**
     * @param length
     * @param type 字符类型：1：纯数字，2：纯大写字母，3：纯小写字母，4：所有字母，5：所有字符
     * @return
     */
    public static String getRandomStr(int length, StrType type){
        char[] ret = new char[length];
        String source;
        switch (type.getValue()){
            case 1:
                source = NUMBER_SOURCES;
                break;
            case 2:
                source = UPPERCASE_ALPHA_SOURCES;
                break;
            case 3:
                source = LOWERCASE_ALPHA_SOURCES;
                break;
            case 4:
                source = ALPHA_SOURCES;
                break;
            case 5:
                source = SOURCES;
                break;
            default:
                source = SOURCES;
                break;
        }
        Random random = new Random();
        for(int i = 0; i < length; i++)
            ret[i] = source.charAt(random.nextInt(source.length()));
        return new String(ret);
    }

    public static boolean isMobileNum(String number){
        if(number == null)
            return false;
        Pattern p = Pattern.compile("^((13[0-9])|(14[57])|(15[^4,\\D])|(17[5678])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
