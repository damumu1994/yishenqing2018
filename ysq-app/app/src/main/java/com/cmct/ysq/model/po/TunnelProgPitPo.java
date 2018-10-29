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
 * 施工进度-双层壁导坑法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_prog_pit")
public class TunnelProgPitPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 施工进度-双层壁导坑法id
     */
    @Id
    private String prgPitId;
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
     * 右侧壁4起始桩号,单位cm
     */
    @Column
    private BigDecimal rightWallFourPegNoStart;
    /**
     * 右侧壁4结束桩号,单位cm
     */
    @Column
    private BigDecimal rightWallFourPegNoEnd;
    /**
     * 中间部5起始桩号,单位cm
     */
    @Column
    private BigDecimal middleWallFivePegNoStart;
    /**
     * 中间部5结束桩号,单位cm
     */
    @Column
    private BigDecimal middleWallFivePegNoEnd;
    /**
     * 中间部6起始桩号,单位cm
     */
    @Column
    private BigDecimal middleWallSixPegNoStart;
    /**
     * 中间部6结束桩号,单位cm
     */
    @Column
    private BigDecimal middleWallSixPegNoEnd;
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
     * 右侧壁3累计长度,单位cm
     */
    @Column
    private BigDecimal rightWallThreeAccumulationLength;
    /**
     * 右侧壁4累计长度,单位cm
     */
    @Column
    private BigDecimal rightWallFourAccumulationLength;
    /**
     * 中间部5累计长度,单位cm
     */
    @Column
    private BigDecimal middleWallFiveAccumulationLength;
    /**
     * 中间部6累计长度,单位cm
     */
    @Column
    private BigDecimal middleWallSixAccumulationLength;
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
