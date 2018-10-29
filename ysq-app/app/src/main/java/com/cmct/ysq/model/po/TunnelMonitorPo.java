package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 断面信息
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-26 13:56:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_monitor")
public class TunnelMonitorPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    private String monitorId;
    /**
     * 隧道
     */
    @Column
    private String tunnelId;
    /**
     * 洞口
     */
    @Column
    private String tunnelHole;
    /**
     * 桩号
     */
    @Column
    private BigDecimal peg;
    /**
     * 监测项目
     */
    @Column
    private String monitorType;
    /**
     * 记录时间
     */
    @Column
    private Date recordDate;
    /**
     * 埋设时间
     */
    @Column
    private Date burialTime;
    /**
     * 设计埋深
     */
    @Column
    private BigDecimal burialDepth;
    /**
     * 施工方法
     */
    @Column
    private String method;
    /**
     * 围岩级别
     */
    @Column
    private String level;
    /**
     * 删除状态,默认是0，0是未删除，1是已删除
     */
    @Column
    private Integer deleteStatus;
    /**
     * 创建人
     */
    @Column
    private String createBy;
    /**
     * 修改人
     */
    @Column
    private String modifyBy;
    /**
     * 创建时间
     */
    @Column
    private Date createDate;
    /**
     * 修改时间
     */
    @Column
    private Date modifyDate;

    /**
     * 预留变形值
     */
    @Column
    private BigDecimal deformedDeformationValue;
    /**
     * 允许值
     */
    @Column
    private BigDecimal permissibleValue;

    /**
     * 弹性模量
     */
    @Column
    private BigDecimal elasticityModulus;

}
