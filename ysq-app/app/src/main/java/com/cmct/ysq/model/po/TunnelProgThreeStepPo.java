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
 * 施工进度-三台阶法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_prog_three_step")
public class TunnelProgThreeStepPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 施工进度-三台阶法id
     */
    @Id
    private String prgThreeStepId;
    /**
     * 施工进度id
     */
    @Column
    private String prgId;
    /**
     * 上台阶起始桩号,单位cm
     */
    @Column
    private BigDecimal upStepPegNoStart;
    /**
     * 上台阶结束桩号,单位cm
     */
    @Column
    private BigDecimal upStepPegNoEnd;
    /**
     * 中台阶起始桩号,单位cm
     */
    @Column
    private BigDecimal middleStepPegNoStart;
    /**
     * 中台阶结束桩号,单位cm
     */
    @Column
    private BigDecimal middleStepPegNoEnd;
    /**
     * 下台阶起始桩号,单位cm
     */
    @Column
    private BigDecimal downStepPegNoStart;
    /**
     * 下台阶结束桩号,单位cm
     */
    @Column
    private BigDecimal downStepPegNoEnd;
    /**
     * 上台阶累计长度,单位cm
     */
    @Column
    private BigDecimal upAccumulationLength;
    /**
     * 中台阶累计长度,单位cm
     */
    @Column
    private BigDecimal middleAccumulationLength;
    /**
     * 下台阶累计长度,单位cm
     */
    @Column
    private BigDecimal downAccumulationLength;
    /**
     * 仰拱隧底起始桩号,单位cm
     */
    @Column
    private BigDecimal bottomPegNoStart;
    /**
     * 仰拱隧底结束桩号,单位cm
     */
    @Column
    private BigDecimal bottomPegNoEnd;
    /**
     * 仰拱隧底累计长度,单位cm
     */
    @Column
    private BigDecimal bottomAccumulationLength;
    /**
     * 二衬累计长度,单位cm
     */
    @Column
    private BigDecimal linerAccumulationLength;
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
