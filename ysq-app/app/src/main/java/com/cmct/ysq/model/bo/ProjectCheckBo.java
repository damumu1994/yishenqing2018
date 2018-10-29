/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.ysq.model.bo;

import com.cmct.common.bean.BaseWhere;

/**
 * 检测项目查询条件
 *
 * @author losing
 * @Date 2016年9月24日
 * @since v0.1
 */
public class ProjectCheckBo extends BaseWhere {

    private String projectId;
    private String projectName;// 项目名称
    private String departId;// 部门ID

    private String bridgeName;//桥梁名称
    private String bridgeCode;//桥梁编码
    private String pileNo;//桥位桩号

    private String[] bridgeIds;

    private String year;//查询年限

    private String checkId;//检测id

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getBridgeName() {
        return bridgeName;
    }

    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    public String getBridgeCode() {
        return bridgeCode;
    }

    public void setBridgeCode(String bridgeCode) {
        this.bridgeCode = bridgeCode;
    }

    public String getPileNo() {
        return pileNo;
    }

    public void setPileNo(String pileNo) {
        this.pileNo = pileNo;
    }

    public String[] getBridgeIds() {
        return bridgeIds;
    }

    public void setBridgeIds(String[] bridgeIds) {
        this.bridgeIds = bridgeIds;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }
}
