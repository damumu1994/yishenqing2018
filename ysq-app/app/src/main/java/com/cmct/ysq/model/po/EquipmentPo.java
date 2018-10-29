package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 设备表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_sys_equipment")
public class EquipmentPo {
    @Id
    private String equipId;
    @Column
    private String equipName;//设备名
    @Column
    private String version;//型号
    @Column
    private String func;//功能
    @Column
    private String equipNo;//编号
    @Column
    private String company;//厂家
    @Column
    private String equipOrder;//序号
    @Column
    private String departId;
    @Column
    private Date createDate;
    @Column
    private String model;

    /**
     * 默认是隧道施工，0是隧道施工
     */
    @Column
    private Integer platform;
    /**
     * 历史数据状态，默认是0，0是当前最新数据，1是历史修改数据
     */
    @Column
    private Integer validStatus;
    /**
     * 历史修改历史编号
     */
    @Column
    private String hisCode;

    /**
     * 删除状态,默认是0，0是未删除，1是已删除
     */
    @Column
    private Integer deleteStatus;

    /**
     * 修改人
     */
    @Column
    private String modifyBy;
    /**
     * 修改时间
     */
    @Column
    private Date modifyDate;

    /**
     * 创建人
     */
    @Column
    private String createBy;

}
