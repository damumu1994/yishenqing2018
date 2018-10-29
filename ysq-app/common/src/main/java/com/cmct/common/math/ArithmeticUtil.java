/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.math;

import java.math.BigDecimal;

/**
 * 算术运算
 *
 * @author cjp
 * @Date 2016年4月9日
 * @since v1.0.0
 */
public class ArithmeticUtil {

    /**
     * 2个数相加 number1 + number2
     *
     * @return number1 + number2
     */
    public static Double add(Number number1, Number number2) {
        BigDecimal decimal1 = new BigDecimal(number1.doubleValue());
        BigDecimal decimal2 = new BigDecimal(number2.doubleValue());
        return decimal1.add(decimal2).doubleValue();
    }

    /**
     * 2个数相减 number1 - number2
     *
     * @return number1 - number2
     */
    public static Double sub(Number number1, Number number2) {
        BigDecimal decimal1 = new BigDecimal(number1.doubleValue());
        BigDecimal decimal2 = new BigDecimal(number2.doubleValue());
        return decimal1.subtract(decimal2).doubleValue();
    }

    /**
     * 2个数相乘 number1 × number2
     *
     * @return number1 × number2
     */
    public static Double multiply(Number number1, Number number2) {
        BigDecimal decimal1 = new BigDecimal(number1.doubleValue());
        BigDecimal decimal2 = new BigDecimal(number2.doubleValue());
        return decimal1.multiply(decimal2).doubleValue();
    }

    /**
     * 2个数相除 number1 ÷ number2
     *
     * @param scale:精确多少位
     * @return number1 ÷ number2
     */
    public static Double divide(Number number1, Number number2, Integer scale) {
        BigDecimal decimal1 = new BigDecimal(number1.doubleValue());
        BigDecimal decimal2 = new BigDecimal(number2.doubleValue());
        return decimal1.divide(decimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
