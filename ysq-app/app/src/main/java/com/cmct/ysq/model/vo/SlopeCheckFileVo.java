package com.cmct.ysq.model.vo;

import java.util.Date;

/**
 * @Description 病害文件PO
 * @Author Leeg
 * @Date  2018/04/09
 */
public class SlopeCheckFileVo {
	private String checkFileId;//主键
	private String checkId;//定检ID
	private String recordDiseaseId;//病害记录ID
	private String fileName;//文件名
	private String fileType;//文件类型[1 图片/2 音频/3 视频/4 手绘/5外部图片]
	private String linkUrl;//文件服务器中访问地址
	private String prefix;//前缀
	private String suffix;//后缀
	private String fileStatus;//文件状态[0无效/1有效]
	private Date createDate;
	private Date updateDate;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCheckFileId() {
		return checkFileId;
	}

	public void setCheckFileId(String checkFileId) {
		this.checkFileId = checkFileId;
	}

	public String getRecordDiseaseId() {
		return recordDiseaseId;
	}

	public void setRecordDiseaseId(String recordDiseaseId) {
		this.recordDiseaseId = recordDiseaseId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
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

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
}
