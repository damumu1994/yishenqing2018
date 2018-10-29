package com.cmct.ysq.model.vo;

import java.util.Date;

public class SlopeDiseaseRecordVo {
	private String recordDiseaseId;//病害记录ID
	private String checkId;//定检ID
	private String slopeId;//边坡ID
	private String sortId;//检查类别
	private String itemId;//检查项
	private String diseaseId;//病害类别ID
	private String diseaseMess;//病害生成信息
	private Date recordDate;//记录日期
	private String diseaseStatus;//状态 1有效 0无效
	private String remark;//备注
	private Date createDate;//创建日期
	private Date updateDate;
	private String diseaseLocation;//病害位置
	private String checkSort;//检查类别
	private String checkItem;//检查项
	
	public String getCheckSort() {
		return checkSort;
	}
	public void setCheckSort(String checkSort) {
		this.checkSort = checkSort;
	}
	public String getRecordDiseaseId() {
		return recordDiseaseId;
	}
	public void setRecordDiseaseId(String recordDiseaseId) {
		this.recordDiseaseId = recordDiseaseId;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public String getSlopeId() {
		return slopeId;
	}
	public void setSlopeId(String slopeId) {
		this.slopeId = slopeId;
	}
	public String getSortId() {
		return sortId;
	}
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getDiseaseMess() {
		return diseaseMess;
	}
	public void setDiseaseMess(String diseaseMess) {
		this.diseaseMess = diseaseMess;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getDiseaseStatus() {
		return diseaseStatus;
	}
	public void setDiseaseStatus(String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getDiseaseLocation() {
		return diseaseLocation;
	}
	public void setDiseaseLocation(String diseaseLocation) {
		this.diseaseLocation = diseaseLocation;
	}
	public String getCheckItem() {
		return checkItem;
	}
	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}
}
