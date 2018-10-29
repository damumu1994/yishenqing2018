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
 * 地表沉降具体采集数据
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:04:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_surface_down")
public class TunnelSurfaceDownPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 地表沉降
     */
    @Id
    private String surfaceDownId;
    /**
     * 测点号
     */
    @Column
    private Integer order;
    /**
     * 基点号
     */
    @Column
    private String baseNo;
    /**
     * 转点与基点高差
     */
    @Column
    private BigDecimal turnBaseValue;
    /**
     * 测点与转点高差
     */
    @Column
    private BigDecimal testTurnValue;
    /**
     * 测点与基点高差
     */
    @Column
    private BigDecimal testBaseValue;
    /**
     * 与第一次差值
     */
    @Column
    private BigDecimal compareFirstValue;
    /**
     * 破坏,0没有破坏，1破坏
     */
    @Column
    private Integer destroy;
    /**
     * 修复,0修复，1没有修复
     */
    @Column
    private Integer repaire;
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
     * 监测项目记录id
     */
    @Column
    private String recordId;

}
