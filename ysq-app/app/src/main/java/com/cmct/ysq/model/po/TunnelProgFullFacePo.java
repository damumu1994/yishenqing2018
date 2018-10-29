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
 * 施工进度-全断面法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_prog_full_face")
public class TunnelProgFullFacePo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 全断面法id
     */
    @Id
    private String tunnelProgFullFace;
    /**
     * 施工进度id
     */
    @Column
    private String consProgId;
    /**
     * 掌子面起始桩号,单位cm
     */
    @Column
    private BigDecimal facePegNoStart;
    /**
     * 掌子面结束桩号,单位cm
     */
    @Column
    private BigDecimal facePegNoEnd;
    /**
     * 掌子面累计长度,单位cm
     */
    @Column
    private BigDecimal faceAccumulaLength;
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
     * 修改时间
     */
    @Column
    private Date modifyDate;
    /**
     * 删除状态,默认是0，0是未删除，1是已删除
     */
    @Column
    private Integer deleteStatus;
    /**
     * 创建时间
     */
    @Column
    private Date createDate;
    /**
     * 修改人
     */
    @Column
    private String modifyBy;
    /**
     * 创建人
     */
    @Column
    private String createBy;

}
