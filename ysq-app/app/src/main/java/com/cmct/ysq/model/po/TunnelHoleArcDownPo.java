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
 * 隧道拱顶下沉
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:05:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_hole_arc_down")
public class TunnelHoleArcDownPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String holeArcDownId;
    /**
     * 测点
     */
    @Column
    private String testPointName;
    /**
     * 测点编码
     */
    @Column
    private String testPointCode;
    /**
     * 基点名称
     */
    @Column
    private String basePointName;
    /**
     * 测点与基点高差(mm)
     */
    @Column
    private BigDecimal height;
    /**
     * 与第一次差值(mm)
     */
    @Column
    private BigDecimal firstValueSub;
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
