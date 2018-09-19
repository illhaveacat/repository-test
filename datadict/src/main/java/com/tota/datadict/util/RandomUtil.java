package com.tota.datadict.util;

import java.util.Random;

public class RandomUtil {
    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERCHAR = "0123456789";

    public RandomUtil() {
    }

    public static String generateNum(int length, boolean firstZero) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for(long i = 0L; i < (long)length; ++i) {
            char num;
            do {
                num = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789".length()));
            } while(!firstZero && i == 0L && String.valueOf(num).equals("0"));

            sb.append(num);
        }

        return sb.toString();
    }

    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        }

        return sb.toString();
    }

    public static String generateMixString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        }

        return sb.toString();
    }

    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    public static String generateZeroString(int length) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            sb.append('0');
        }

        return sb.toString();
    }

    public static String toFixdLengthString(long num, int fixdlenth) {
        StringBuffer sb = new StringBuffer();
        String strNum = String.valueOf(num);
        if (fixdlenth - strNum.length() >= 0) {
            sb.append(generateZeroString(fixdlenth - strNum.length()));
            sb.append(strNum);
            return sb.toString();
        } else {
            throw new RuntimeException("将数字" + num + "转化为长度为" + fixdlenth + "的字符串发生异常！");
        }
    }

    public static int getNotSimple(int[] param, int len) {
        Random rand = new Random();

        int result;
        int i;
        for(result = param.length; result > 1; --result) {
            i = rand.nextInt(result);
            int tmp = param[i];
            param[i] = param[result - 1];
            param[result - 1] = tmp;
        }

        result = 0;

        for(i = 0; i < len; ++i) {
            result = result * 10 + param[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("返回一个定长的随机字符串(只包含数字):" + generateNum(19, false));
    }
}