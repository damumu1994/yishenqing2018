package com.cmct.ysq.model.vo;

import java.util.Date;

public class CheckVo extends BaseVo {
	private String pegNoStart;//起始桩号
	private String pegNoEnd;//结束桩号
	private String side;//位置,边坡位于道路左侧还是右侧:0左侧;1右侧
    private Date checkDate;// 检查开始时间
    private Date checkDateEnd;// 检查结束时间
    private String diseaseCount;//病害数量
    private String picCount;//外部图片数量
    private String checkStatus;//状态
    private String needPic;//需求外部图片数量
    private String matchedPic;//已匹配外部图片
    private String projectName;//项目名
    private String checkId;//定期检查ID
    private String fileType;//图片类型
    private String checkEquip;//检查设备
    private String recordEquip;//原始记录设备

	public String getCheckEquip() {
		return checkEquip;
	}
	public void setCheckEquip(String checkEquip) {
		this.checkEquip = checkEquip;
	}
	public String getRecordEquip() {
		return recordEquip;
	}
	public void setRecordEquip(String recordEquip) {
		this.recordEquip = recordEquip;
	}
	public String getPegNoStart() {
		return pegNoStart;
	}
	public void setPegNoStart(String pegNoStart) {
		this.pegNoStart = pegNoStart;
	}
	public String getPegNoEnd() {
		return pegNoEnd;
	}
	public void setPegNoEnd(String pegNoEnd) {
		this.pegNoEnd = pegNoEnd;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Date getCheckDateEnd() {
		return checkDateEnd;
	}
	public void setCheckDateEnd(Date checkDateEnd) {
		this.checkDateEnd = checkDateEnd;
	}
	public String getDiseaseCount() {
		return diseaseCount;
	}
	public void setDiseaseCount(String diseaseCount) {
		this.diseaseCount = diseaseCount;
	}
	public String getPicCount() {
		return picCount;
	}
	public void setPicCount(String picCount) {
		this.picCount = picCount;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getNeedPic() {
		return needPic;
	}
	public void setNeedPic(String needPic) {
		this.needPic = needPic;
	}
	public String getMatchedPic() {
		return matchedPic;
	}
	public void setMatchedPic(String matchedPic) {
		this.matchedPic = matchedPic;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
