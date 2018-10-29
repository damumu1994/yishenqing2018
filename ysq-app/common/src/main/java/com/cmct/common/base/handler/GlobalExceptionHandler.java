/**
 * 文件名称:  GlobalExceptionHandler.java
 * 文件序号:  序号
 * 内容描述:  文件简单描述，多行换行书写
 * 版权声明:  山东鸿蝶信息技术有限公司
 * 创建用户:  zhangkai
 * 创建日期:  2016/12/28 16:30
 * 修改用户:  无
 * 修改日期:  无
 * 修改说明:  无
 * 文件版本:  V1.0
 * 文件路径:
 */

package com.cmct.common.base.handler;


import com.cmct.common.base.entity.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 名  称:GlobalExceptionHandler
 * 类  型: class
 * 描  述: 用一句话描述类的作用
 * 路  径:com.hongdee.edm.demo.controller
 * 作  者:zhangkai
 * 日  期:2016/12/28 16:30
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ResultEntity r = new ResultEntity();
        r.setMsg(e.getMessage());
        r.setSuccess(false);
        return r;
    }
}
