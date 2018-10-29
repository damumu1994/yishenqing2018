/**
 * 文件名称:  AopAspect.java
 * 文件序号:  序号
 * 内容描述:  文件简单描述，多行换行书写
 * 版权声明:  山东鸿蝶信息技术有限公司
 * 创建用户:  zhangkai
 * 创建日期:  2016/12/28 13:58
 * 修改用户:  无
 * 修改日期:  无
 * 修改说明:  无
 * 文件版本:  V1.0
 * 文件路径:
 */

package com.cmct.common.base.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 名  称:AopAspect
 * 类  型: class
 * 描  述: 全局异常处理切片，向数据库中插入异常信息
 * 路  径:com.hongdee.base.aop
 * 作  者:zhangkai
 * 日  期:2016/12/28 13:58
 */
@Aspect
@Component
public class ExceptionAop {

    /**
     * 方法名称:
     * 方法描述:捕获Service或Dao层的异常，担待
     * 参数名称: a
     * 参数名称: b
     * 返回内容:
     * 异常说明:
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    @Pointcut(value = "execution(public * com.cmct.*..*(..)) && @target(org.springframework.stereotype.Service)")
    public void errorException() {

    }

    @Before("errorException()")
    public void before() {
        System.out.println("前置条件");
    }


    @Around(value = "errorException()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("什么都没干");
        return jp.proceed();
    }

    @AfterThrowing(pointcut = "errorException()", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Exception ex) {
        System.out.println("异常发生之后");
        System.out.println("处理异常");
    }


}
