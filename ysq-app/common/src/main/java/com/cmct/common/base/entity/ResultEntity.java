/**
 * 文件名称:  ResultEntity.java
 * 文件序号:  序号
 * 内容描述:  文件简单描述，多行换行书写
 * 版权声明:  山东鸿蝶信息技术有限公司
 * 创建用户:  zhangkai
 * 创建日期:  2016/12/28 16:16
 * 修改用户:  无
 * 修改日期:  无
 * 修改说明:  无
 * 文件版本:  V1.0
 * 文件路径:
 */

package com.cmct.common.base.entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 名  称:ResultEntity
 * 类  型: class
 * 描  述: 用一句话描述类的作用
 * 路  径:com.hongdee.Result
 * 作  者:zhangkai
 * 日  期:2016/12/28 16:16
 */
public class ResultEntity {
    private String msg;
    private Boolean success;
    private Object data;
    private List<Object> dataList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {

        return null == data ? new HashMap() : data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getDataList() {
        return null == dataList ? new ArrayList() : dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }
}
