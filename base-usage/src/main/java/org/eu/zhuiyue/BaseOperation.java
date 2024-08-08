package org.eu.zhuiyue;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * Java 基础语法
 *
 */
public class BaseOperation
{

    /**
     * a = a + b 与 a += b 的区别
     * byte、short 或者 int，首先会将它们提升到 int 类型, 以及float计算时会提升成double，然后在执行加法操作；+= 隐式的将加操作的结果类型强制转换为持有结果的类型。
     *
     */
    public static void sinceAdd(){
        byte a = 127;
        byte b = 127;
        /**
         *  byte、short 或者 int，首先会将它们提升到 int 类型，然后在执行加法操作
         */
        //b = a +b;// error: cannot convert from int to byte

        /**
         * += 隐式的将加操作的结果类型强制转换为持有结果的类型
         */
        b += a;
    }



    /**
     * 浮点数比较不能直接用 ==, 因为有些浮点数不能完全精确的表示出来, 所以判断相等需要用根据精确位数来比较如：Math.abs(a-b) < 0.0000001
     * 或者如果确定的浮点数比较大小，可以使用Double.compare(a,b) == 0;
     *
     * @return true or false
     */
    public static boolean compare(){
        double a = 0.1 *3;
        double b = 0.3;
        //return Math.abs(a-b) < 0.0000001;
        //return Double.compare(a,b) == 0 ? true : false;
        return a == b;

    }

    /**
     * 移位运算
     *
     */
    public static void gression(){

        /**
         * << 左移运算符，相当于乘以2(不溢出的情况下),低位补0
         */
        int a = 1;  // 1
        a = a << 1; // 10
        System.out.println(a);//2


        /**
         * >> 带符号右移运算符，相当于除以2,正数高位补0,负数高位补1
         */
        int b = -10;
        System.out.println(Integer.toBinaryString(-10));//11111111111111111111111111110110
        b = b >> 1;
        System.out.println(Integer.toBinaryString(b));//11111111111111111111111111111011
        System.out.println(b);//-5

        /**
         * >> 无符号右移运算符，忽略符号位,空位都以0补齐
         * -100 转化二进制过程，需要将 -100 转换成32位的二进制补码形式。
         * 将 100 转换成二进制表示： 100的二进制是 1100100。
         * 补全到32位： 0000 0000 0000 0000 0000 0000 0110 0100
         * 取反得到反码： 1111 1111 1111 1111 1111 1111 1001 1011
         * 加1得到补码（即 -100 的二进制表示）： 1111 1111 1111 1111 1111 1111 1001 1100
         */
        int c = -100;
        System.out.println(Integer.toBinaryString(c));//  11111111111111111111111110011100
        c = c >>> 2;
        System.out.println(Integer.toBinaryString(c));//00111111111111111111111111100111
        System.out.println(c);//1073741799
    }


    public static void main( String[] args )
    {
        System.out.println( "Base operation!" );
        System.out.println(compare());
        gression();
        sinceAdd();

    }
}
