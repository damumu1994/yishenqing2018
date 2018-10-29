/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * 日志工具类
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class LogUtil {

    public static final String DEFAULT_LOGGER = "ROOT";

    public static boolean isTraceEnabled(Class<?> loggerCls) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isTraceEnabled();
    }

    public static void trace(Class<?> loggerCls, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(msg);
    }

    public static void trace(Class<?> loggerCls, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(format, arg);
    }

    public static void trace(Class<?> loggerCls, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(format, arg1, arg2);

    }


    public static void trace(Class<?> loggerCls, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(format, arguments);
    }


    public static void trace(Class<?> loggerCls, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(msg, t);
    }


    public static boolean isTraceEnabled(Class<?> loggerCls, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isTraceEnabled(marker);
    }


    public static void trace(Class<?> loggerCls, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(marker, msg);
    }


    public static void trace(Class<?> loggerCls, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(marker, format, arg);
    }


    public static void trace(Class<?> loggerCls, Marker marker, String format, Object arg1,
                             Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(marker, format, arg1, arg2);
    }


    public static void trace(Class<?> loggerCls, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(marker, format, argArray);
    }


    public static void trace(Class<?> loggerCls, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.trace(marker, msg, t);
    }


    public static boolean isDebugEnabled(Class<?> loggerCls) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isDebugEnabled();
    }


    public static void debug(Class<?> loggerCls, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(msg);
    }

    public static void debug(Class<?> loggerCls, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(format, arg);
    }

    public static void debug(Class<?> loggerCls, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(format, arg1, arg2);

    }


    public static void debug(Class<?> loggerCls, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(format, arguments);
    }


    public static void debug(Class<?> loggerCls, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(msg, t);
    }


    public static boolean isDebugEnabled(Class<?> loggerCls, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isDebugEnabled(marker);
    }


    public static void debug(Class<?> loggerCls, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(marker, msg);
    }


    public static void debug(Class<?> loggerCls, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(marker, format, arg);
    }


    public static void debug(Class<?> loggerCls, Marker marker, String format, Object arg1,
                             Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(marker, format, arg1, arg2);
    }


    public static void debug(Class<?> loggerCls, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(marker, format, argArray);
    }


    public static void debug(Class<?> loggerCls, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.debug(marker, msg, t);
    }

    public static boolean isInfoEnabled(Class<?> loggerCls) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isInfoEnabled();
    }


    public static void info(Class<?> loggerCls, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(msg);
    }

    public static void info(Class<?> loggerCls, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(format, arg);
    }

    public static void info(Class<?> loggerCls, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(format, arg1, arg2);

    }


    public static void info(Class<?> loggerCls, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(format, arguments);
    }


    public static void info(Class<?> loggerCls, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(msg, t);
    }


    public static boolean isInfoEnabled(Class<?> loggerCls, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isInfoEnabled(marker);
    }


    public static void info(Class<?> loggerCls, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(marker, msg);
    }


    public static void info(Class<?> loggerCls, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(marker, format, arg);
    }


    public static void info(Class<?> loggerCls, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(marker, format, arg1, arg2);
    }


    public static void info(Class<?> loggerCls, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(marker, format, argArray);
    }


    public static void info(Class<?> loggerCls, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.info(marker, msg, t);
    }

    public static boolean isWarnEnabled(Class<?> loggerCls) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isWarnEnabled();
    }


    public static void warn(Class<?> loggerCls, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(msg);
    }

    public static void warn(Class<?> loggerCls, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(format, arg);
    }

    public static void warn(Class<?> loggerCls, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(format, arg1, arg2);

    }


    public static void warn(Class<?> loggerCls, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(format, arguments);
    }


    public static void warn(Class<?> loggerCls, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(msg, t);
    }


    public static boolean isWarnEnabled(Class<?> loggerCls, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isWarnEnabled(marker);
    }


    public static void warn(Class<?> loggerCls, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(marker, msg);
    }


    public static void warn(Class<?> loggerCls, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(marker, format, arg);
    }


    public static void warn(Class<?> loggerCls, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(marker, format, arg1, arg2);
    }


    public static void warn(Class<?> loggerCls, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(marker, format, argArray);
    }


    public static void warn(Class<?> loggerCls, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.warn(marker, msg, t);
    }

    public static boolean isErrorEnabled(Class<?> loggerCls) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isErrorEnabled();
    }


    public static void error(Class<?> loggerCls, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(msg);
    }

    public static void error(Class<?> loggerCls, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(format, arg);
    }

    public static void error(Class<?> loggerCls, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(format, arg1, arg2);

    }


    public static void error(Class<?> loggerCls, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(format, arguments);
    }


    public static void error(Class<?> loggerCls, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(msg, t);
    }


    public static boolean isErrorEnabled(Class<?> loggerCls, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        return logger.isErrorEnabled(marker);
    }


    public static void error(Class<?> loggerCls, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(marker, msg);
    }


    public static void error(Class<?> loggerCls, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(marker, format, arg);
    }


    public static void error(Class<?> loggerCls, Marker marker, String format, Object arg1,
                             Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(marker, format, arg1, arg2);
    }


    public static void error(Class<?> loggerCls, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(marker, format, argArray);
    }


    public static void error(Class<?> loggerCls, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerCls);
        logger.error(marker, msg, t);
    }


    public static boolean isTraceEnabled(String loggerName) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isTraceEnabled();
    }


    public static void trace(String loggerName, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(msg);
    }

    public static void trace(String loggerName, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(format, arg);
    }

    public static void trace(String loggerName, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(format, arg1, arg2);

    }


    public static void trace(String loggerName, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(format, arguments);
    }


    public static void trace(String loggerName, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(msg, t);
    }


    public static boolean isTraceEnabled(String loggerName, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isTraceEnabled(marker);
    }


    public static void trace(String loggerName, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(marker, msg);
    }


    public static void trace(String loggerName, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(marker, format, arg);
    }


    public static void trace(String loggerName, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(marker, format, arg1, arg2);
    }


    public static void trace(String loggerName, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(marker, format, argArray);
    }


    public static void trace(String loggerName, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.trace(marker, msg, t);
    }


    public static boolean isDebugEnabled(String loggerName) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isDebugEnabled();
    }


    public static void debug(String loggerName, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(msg);
    }

    public static void debug(String loggerName, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(format, arg);
    }

    public static void debug(String loggerName, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(format, arg1, arg2);

    }


    public static void debug(String loggerName, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(format, arguments);
    }


    public static void debug(String loggerName, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(msg, t);
    }


    public static boolean isDebugEnabled(String loggerName, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isDebugEnabled(marker);
    }


    public static void debug(String loggerName, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(marker, msg);
    }


    public static void debug(String loggerName, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(marker, format, arg);
    }


    public static void debug(String loggerName, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(marker, format, arg1, arg2);
    }


    public static void debug(String loggerName, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(marker, format, argArray);
    }


    public static void debug(String loggerName, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.debug(marker, msg, t);
    }

    public static boolean isInfoEnabled(String loggerName) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isInfoEnabled();
    }


    public static void info(String loggerName, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(msg);
    }

    public static void info(String loggerName, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(format, arg);
    }

    public static void info(String loggerName, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(format, arg1, arg2);

    }


    public static void info(String loggerName, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(format, arguments);
    }


    public static void info(String loggerName, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(msg, t);
    }


    public static boolean isInfoEnabled(String loggerName, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isInfoEnabled(marker);
    }


    public static void info(String loggerName, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(marker, msg);
    }


    public static void info(String loggerName, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(marker, format, arg);
    }


    public static void info(String loggerName, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(marker, format, arg1, arg2);
    }


    public static void info(String loggerName, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(marker, format, argArray);
    }


    public static void info(String loggerName, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.info(marker, msg, t);
    }

    public static boolean isWsrnEnabled(String loggerName) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isWarnEnabled();
    }


    public static void warn(String loggerName, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(msg);
    }

    public static void warn(String loggerName, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(format, arg);
    }

    public static void warn(String loggerName, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(format, arg1, arg2);

    }


    public static void warn(String loggerName, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(format, arguments);
    }


    public static void warn(String loggerName, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(msg, t);
    }


    public static boolean isWarnEnabled(String loggerName, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isWarnEnabled(marker);
    }


    public static void warn(String loggerName, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(marker, msg);
    }


    public static void warn(String loggerName, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(marker, format, arg);
    }


    public static void warn(String loggerName, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(marker, format, arg1, arg2);
    }


    public static void warn(String loggerName, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(marker, format, argArray);
    }


    public static void warn(String loggerName, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.warn(marker, msg, t);
    }

    public static boolean isErrorEnabled(String loggerName) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isErrorEnabled();
    }


    public static void error(String loggerName, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(msg);
    }

    public static void error(String loggerName, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(format, arg);
    }

    public static void error(String loggerName, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(format, arg1, arg2);

    }


    public static void error(String loggerName, String format, Object... arguments) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(format, arguments);
    }


    public static void error(String loggerName, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(msg, t);
    }


    public static boolean isErrorEnabled(String loggerName, Marker marker) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        return logger.isErrorEnabled(marker);
    }


    public static void error(String loggerName, Marker marker, String msg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(marker, msg);
    }


    public static void error(String loggerName, Marker marker, String format, Object arg) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(marker, format, arg);
    }


    public static void error(String loggerName, Marker marker, String format, Object arg1, Object arg2) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(marker, format, arg1, arg2);
    }


    public static void error(String loggerName, Marker marker, String format, Object... argArray) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(marker, format, argArray);
    }


    public static void error(String loggerName, Marker marker, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        logger.error(marker, msg, t);
    }


}
