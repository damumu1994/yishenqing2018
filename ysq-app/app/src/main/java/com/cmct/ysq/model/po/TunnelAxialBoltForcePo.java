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
 * 锚杆轴力
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:10:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_axial_bolt_force")
public class TunnelAxialBoltForcePo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String surrRockInitialPressureIid;
    /**
     * 位置
     */
    @Column
    private String locName;
    /**
     * 位置编码
     */
    @Column
    private String locCode;
    /**
     * 元件号名称
     */
    @Column
    private String elementName;
    /**
     * 元件号编码
     */
    @Column
    private String elementCode;
    /**
     * 元件号(用户输入)
     */
    @Column
    private String elementNo;
    /**
     * 标定系数
     */
    @Column
    private BigDecimal ratio;
    /**
     * 量测值
     */
    @Column
    private BigDecimal measurementValue;
    /**
     * 换算值
     */
    @Column
    private BigDecimal conversionValue;
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
     * 记录id
     */
    @Column
    private String recordId;


}
