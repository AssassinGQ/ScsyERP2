package cn.AssassinG.ScsyERP.common.utils;

public class Utils {

    public static int getLengthOfObject(Object in) {
        String str = String.valueOf(in);
        if (str == null)
            return 0;
        else
            return str.length();
    }
}
