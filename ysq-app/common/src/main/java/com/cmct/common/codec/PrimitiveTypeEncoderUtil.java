/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.codec;

/**
 * 基本类型的编码解码 转换的字节数组都采用大端表示
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public class PrimitiveTypeEncoderUtil {

    /**
     * short类型转换为 字节数组
     *
     * @param data 待转换的值
     * @return byte[] 编码后的数组
     */
    public static byte[] shortToBytes(short data) {
        byte[] b = new byte[2];
        b[0] = (byte) (data >> 8);
        b[1] = (byte) data;
        return b;
    }

    /**
     * 字节数组转换为short
     *
     * @param data 字节数组
     * @return short 转换后的short值
     */
    public static short bytesToShort(byte[] data) {
        return bytesToShort(data, 0);
    }

    /**
     * 字节数组转换为short
     *
     * @param data     字节数组
     * @param startPos 要转换的起始位置从0开始计算
     * @return short 转换后的值
     */
    public static short bytesToShort(byte[] data, int startPos) {
        if (data == null || data.length == 0 || (data.length - startPos) < 2) {
            throw new IllegalArgumentException("bytes len must more than 2 ");
        }
        short s = 0;
        s |= (data[startPos] & 0xff);
        s <<= 8;
        s |= (data[startPos + 1] & 0xff);
        return s;

    }

    /**
     * int转换为字节数组
     *
     * @param data 待转换的值
     * @return byte[] 转换后的字节数组
     */
    public static byte[] intToBytes(int data) {
        byte[] b = new byte[4];
        b[0] = (byte) (data >> 24);
        b[1] = (byte) (data >> 16);
        b[2] = (byte) (data >> 8);
        b[3] = (byte) (data);
        return b;
    }

    /**
     * 字节数组转换为int
     *
     * @param data 待转换的字节数组
     * @return int 转换后的值
     */
    public static int bytesToInt(byte[] data) {
        return bytesToInt(data, 0);
    }

    /**
     * 字节数组转换为int
     *
     * @param data     字节数组
     * @param startPos 要转换的起始位置从0开始计算
     * @return int 转换后的值
     */
    public static int bytesToInt(byte[] data, int startPos) {
        if (data == null || data.length == 0 || (data.length - startPos) < 4) {
            throw new IllegalArgumentException("bytes len must more than 2 ");
        }
        int s = 0;
        s |= (data[startPos] & 0xff);
        s <<= 8;
        s |= (data[startPos + 1] & 0xff);
        s <<= 8;
        s |= (data[startPos + 2] & 0xff);
        s <<= 8;
        s |= (data[startPos + 3] & 0xff);
        return s;

    }

    /**
     * long转换为字节数组
     *
     * @param data 待转换的值
     * @return byte[] 转换后的字节数组
     */
    public static byte[] longToBytes(long data) {

        byte[] b = new byte[8];

        for (int i = 0; i < 8; ++i) {
            b[i] = (byte) (data >> (8 * (7 - i)));
        }
        return b;
    }

    /**
     * 字节数组转换为long
     *
     * @param data 待转换的字节数组
     * @return long 转换后的值
     */
    public static long bytesToLong(byte[] data) {
        return bytesToLong(data, 0);
    }

    /**
     * 字节数组转换为long
     *
     * @param data     字节数组
     * @param startPos 要转换的起始位置从0开始计算
     * @return long 转换后的值
     */
    public static long bytesToLong(byte[] data, int startPos) {
        if (data == null || data.length == 0 || (data.length - startPos) < 8) {
            throw new IllegalArgumentException("bytes len must more than 8 ");
        }

        long longData = 0L;
        for (int i = 0; i < 8; ++i) {
            longData <<= 8;
            longData |= (data[i + startPos] & 0xff);
        }
        return longData;
    }

    /**
     * float转换为字节数组
     *
     * @param data 待转换的值
     * @return byte[] 转换后的字节数组
     */
    public static byte[] floatToBytes(float data) {
        int intBit = Float.floatToIntBits(data);

        return intToBytes(intBit);
    }

    /**
     * 字节数组转换为float
     *
     * @param data 待转换的字节数组
     * @return float 转换后的值
     */
    public static float bytesToFloat(byte[] data) {
        return bytesToFloat(data, 0);
    }

    /**
     * 字节数组转换为float
     *
     * @param data     字节数组
     * @param startPos 要转换的起始位置从0开始计算
     * @return float 转换后的值
     */
    public static float bytesToFloat(byte[] data, int startPos) {
        int intBit = bytesToInt(data, startPos);

        return Float.intBitsToFloat(intBit);
    }

    /**
     * double转换为字节数组
     *
     * @param data 待转换的值
     * @return byte[] 转换后的字节数组
     */
    public static byte[] doubleToBytes(double data) {
        long longBit = Double.doubleToLongBits(data);

        return longToBytes(longBit);
    }

    /**
     * 字节数组转换为double
     *
     * @param data 待转换的字节数组
     * @return double 转换后的值
     */
    public static double bytesToDouble(byte[] data) {
        return bytesToDouble(data, 0);
    }

    /**
     * 字节数组转换为double
     *
     * @param data     字节数组
     * @param startPos 要转换的起始位置从0开始计算
     * @return double 转换后的值
     */
    public static double bytesToDouble(byte[] data, int startPos) {
        long longBit = bytesToLong(data, startPos);

        return Double.longBitsToDouble(longBit);
    }

    /**
     * 无符号byte类型转换为int
     *
     * @param data 待转换的值
     * @return int 无符号byte代表的值，0-255
     */
    public static int unsignedByteToInt(byte data) {
        return data < 0 ? (int) data + 256 : (int) data;
    }

    /**
     * 无符号short类型转换为int
     *
     * @param data 待转换的值
     * @return int 无符号byte代表的值，0-65535
     */
    public static int unsigedShortToInt(short data) {
        return data < 0 ? (int) data + 65536 : (int) data;
    }

    /**
     * 无符号int类型转换为long
     *
     * @param data 待转换的值
     * @return long 无符号byte代表的值，0-4294967295L
     */
    public static long unsigendIntToLong(int i) {
        return i < 0 ? (4294967296L + i) : (long) i;
    }

    public static void main(String[] args) {
        float h = 123.888f;
        byte[] b = floatToBytes(h);
        System.out.println(bytesToFloat(b));
        int x = 122434;
        b = intToBytes(x);
        System.out.println(bytesToInt(b));
    }
}
