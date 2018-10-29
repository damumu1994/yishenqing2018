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
 * 施工进度-二衬的详细数据
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_prog_liner")
public class TunnelProgLinerPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 二衬的详细数据id
     */
    @Id
    private String progLinerId;
    /**
     * 所属的进度记录id
     */
    @Column
    private String prgRecordId;
    /**
     * 二衬起始桩号,单位cm
     */
    @Column
    private BigDecimal facePegNoStart;
    /**
     * 二衬结束桩号,单位cm
     */
    @Column
    private BigDecimal facePegNoEnd;
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
