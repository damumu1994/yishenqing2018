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
 * 施工进度-CD法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_prog_cd")
public class TunnelProgCdPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 施工进度-CD法id
     */
    @Id
    private String tunnelProgCdId;
    /**
     * 施工进度id
     */
    @Column
    private String prgId;
    /**
     * 左侧壁1起始桩号,单位cm
     */
    @Column
    private BigDecimal leftWallOnePegNoStart;
    /**
     * 左侧壁1结束桩号,单位cm
     */
    @Column
    private BigDecimal leftWallOnePegNoEnd;
    /**
     * 左侧壁2起始桩号,单位cm
     */
    @Column
    private BigDecimal leftWallTwoPegNoStart;
    /**
     * 左侧壁2结束桩号,单位cm
     */
    @Column
    private BigDecimal leftWallTwoPegNoEnd;
    /**
     * 左侧壁3起始桩号,单位cm
     */
    @Column
    private BigDecimal leftWallThreePegNoStart;
    /**
     * 左侧壁3结束桩号,单位cm
     */
    @Column
    private BigDecimal leftWallThreePegNoEnd;
    /**
     * 右侧壁1起始桩号,单位cm
     */
    @Column
    private BigDecimal rightWallOnePegNoStart;
    /**
     * 侧壁1结束桩号,单位cm
     */
    @Column
    private BigDecimal rightWallOnePegNoEnd;
    /**
     * 右侧壁2起始桩号,单位cm
     */
    @Column
    private BigDecimal rightWallTwoPegNoStart;
    /**
     * 右侧壁2结束桩号,单位cm
     */
    @Column
    private BigDecimal rightWallTwoPegNoEnd;
    /**
     * 右侧壁3起始桩号,单位cm
     */
    @Column
    private BigDecimal rightWallThreePegNoStart;
    /**
     * 右侧壁3结束桩号,单位cm
     */
    @Column
    private BigDecimal rightWallThreePegNoEnd;
    /**
     * 左侧壁1累计长度,单位cm
     */
    @Column
    private BigDecimal leftWallOneAccumulationLength;
    /**
     * 左侧壁2累计长度,单位cm
     */
    @Column
    private BigDecimal leftWallTwoAccumulationLength;
    /**
     * 左侧壁3累计长度,单位cm
     */
    @Column
    private BigDecimal leftWallThreeAccumulationLength;
    /**
     * 右侧壁1累计长度,单位cm
     */
    @Column
    private BigDecimal rightWallOneAccumulationLength;
    /**
     * 右侧壁2累计长度,单位cm
     */
    @Column
    private BigDecimal rightWallTwoAccumulationLength;
    /**
     * 右侧壁3累计长度,单位cm
     */
    @Column
    private BigDecimal rightWallThreeAccumulationLength;
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
