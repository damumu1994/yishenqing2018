package com.cmct.ysq.model.bo;


import com.cmct.common.bean.BaseWhere;
import lombok.Data;

@Data
public class TunnelCheckItemBO extends BaseWhere {
    private String inspectionReportId;
    private String checkItemId;

}
