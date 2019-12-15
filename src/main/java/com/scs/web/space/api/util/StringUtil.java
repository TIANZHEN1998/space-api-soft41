package com.scs.web.space.api.util;

import java.util.Random;

/**
 * @ClassName StringUtil
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/2
 **/
public class StringUtil {
    private final static int LENGTH = 6;
    /**
     * 获取六位随机数短信验证码
     *
     * @return
     */
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(10)));
        }
        return stringBuilder.toString();
    }
    /**
     * 获取六位随机数字、字母字符串序列
     *
     * @return String
     */
    public static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int index;
        //生成四位随机字符
        for (int i = 0; i < LENGTH; i++) {
            //随机生成0、1、2三个整数，代表数字字符、大写字母、小写字母，保证验证码的组成比较正态随机
            index = random.nextInt(3);
            //调用本类封装的私有方法，根据编号获得对应的字符
            char result = getChar(index);
            //追加到可变长字符串
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    private static char getChar(int item) {
        //数字字符范围
        int digitalBound = 10;
        //字符范围
        int charBound = 26;
        Random random = new Random();
        int index;
        char c;
        //根据调用时候的三个选项，生成数字、大写字母、小写字母三种不同的字符
        if (item == 0) {
            index = random.nextInt(digitalBound);
            c = (char) ('0' + index);
        } else if (item == 1) {
            index = random.nextInt(charBound);
            c = (char) ('A' + index);
        } else {
            index = random.nextInt(charBound);
            c = (char) ('a' + index);
        }
        return c;
    }
}
