package com.cmct.ysq.conf;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 * service层日志
 * </p>
 *
 * @author shen
 * @version 1.0.0
 * @since 2017-09-09
 */
@Component
@Aspect
@Slf4j
public class ServiceLogAop {

    @Pointcut("execution(public * com.cmct.ysq.service..*(..))")
    public void serviceAspect() {

    }


    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) {

        // 获取包括包名在内的全方法名
        String allmethodName = joinPoint.getTarget().getClass().getName() + "."
                + joinPoint.getSignature().getName() + "()";


        String args = "";
        String ip = "";

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            // 获取请求的ip
            ip = request.getRemoteAddr();
            args = JSON.toJSONString(joinPoint.getArgs());
        } catch (Exception e) {
            //DO NOTHING
        }
        log.info(allmethodName + ",Ip:" + ip + ",参数:{}", args);
    }

    @AfterReturning(returning = "rvt", value = "serviceAspect()")
    public void log(JoinPoint joinPoint, Object rvt) {

        // 获取包括包名在内的全方法名
        String allmethodName = joinPoint.getTarget().getClass().getName() + "."
                + joinPoint.getSignature().getName() + "()";

        String ip = "";
        try {

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            ip = request.getRemoteAddr();
        } catch (Exception e) {
            //DO NOTHING
        }
        log.info(allmethodName + ",Ip:" + ip + ",返回值:{}", JSON.toJSON(rvt));
    }


}
