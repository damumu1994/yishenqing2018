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
 * 周边收敛
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:05:12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_surr_con")
public class TunnelSurrConPo implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 周边收敛id
     */
    @Id
    private String surrConId;
    /**
     * 测线
     */
    @Column
    private String testLineCode;
    /**
     *
     */
    @Column
    private String basePointLoc;
    /**
     * 读数(mm)
     */
    @Column
    private BigDecimal value;
    /**
     * 第一次差值
     */
    @Column
    private BigDecimal firstValue;
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
     * 记录id
     */
    @Column
    private String recordId;
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

}
