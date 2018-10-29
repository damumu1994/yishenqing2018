package com.cmct.ysq.model.vo;

import java.util.Date;
import java.util.List;

public class SlopeSysParamVo extends BaseVo {
    private String paramId;//
    private String paramName;//参数名
    private String paramCode;//参数代码
    private String parentId;//父参数ID
    private String departId;//单位ID
    private String paramStatus;//参数状态  0无效 1有效
    private String paramOrder;//排序
    private Date createDate;//
    private Date updateDate;//
    private String title;
    private List<SlopeSysParamVo> children;

    @Override
    public String getDepartId() {
        return departId;
    }

    @Override
    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParamStatus() {
        return paramStatus;
    }

    public void setParamStatus(String paramStatus) {
        this.paramStatus = paramStatus;
    }

    public String getParamOrder() {
        return paramOrder;
    }

    public void setParamOrder(String paramOrder) {
        this.paramOrder = paramOrder;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SlopeSysParamVo> getChildren() {
		return children;
	}

	public void setChildren(List<SlopeSysParamVo> children) {
		this.children = children;
	}
}
