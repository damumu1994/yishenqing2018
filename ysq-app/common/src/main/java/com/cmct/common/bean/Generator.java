/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.bean;

import com.cmct.common.log.LogUtil;

/**
 * 全局ID生成器
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class Generator {

    private final long workerId;
    private final long epoch = 1457522283555L; // 时间起始标记点，作为基准，一般取系统的最近时间
    private final long workerIdBits = 9L; // 机器标识位数
    private final long maxWorkerId = -1L ^ -1L << this.workerIdBits;// 机器ID最大值: 1023
    private long sequence = 0L; // 0，并发控制
    private final long sequenceBits = 12L; // 毫秒内自增位

    private final long workerIdShift = this.sequenceBits; // 12
    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;// 21
    private final long sequenceMask = -1L ^ -1L << this.sequenceBits; // 4095,111111111111,12位
    private long lastTimestamp = -1L;

    public Generator(long workerId) {
        if (workerId > this.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }
        this.workerId = workerId;
    }

    public synchronized String nextId() {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) { // 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环);
            // 对新的timestamp，sequence从0开始
            this.sequence = this.sequence + 1 & this.sequenceMask;
            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);// 重新生成timestamp
            }
        } else {
            this.sequence = 0;
        }

        if (timestamp < this.lastTimestamp) {
            LogUtil.error(Generator.class,
                    String.format("clock moved backwards.Refusing to generate id for %d milliseconds",
                            (this.lastTimestamp - timestamp)));
            throw new RuntimeException(
                    String.format("clock moved backwards.Refusing to generate id for %d milliseconds",
                            (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        long currentId = ((timestamp - this.epoch) << this.timestampLeftShift)
                | (this.workerId << this.workerIdShift) | this.sequence;
        return "AG" + currentId;
    }

    /**
     * 等待下一个毫秒的到来, 保证返回的毫秒数在参数lastTimestamp之后
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /**
     * 获得系统当前毫秒数
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

}
