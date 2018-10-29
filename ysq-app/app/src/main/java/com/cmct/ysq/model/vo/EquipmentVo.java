package com.cmct.ysq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentVo extends BaseVo {
    private String equipId;
    private String equipName;//设备名
    private String version;//型号
    private String func;//功能
    private String equipNo;//编号
    private String company;//厂家
    private String equipOrder;//序号
    private Date createDate;
    private Date updateDate;
    private String departPath;


}
