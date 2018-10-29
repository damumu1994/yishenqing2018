package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 施工设计信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_cons_info")
public class TunnelConsInfoPo {
    /**
     * 施工设计信息
     */
    @Id
    private String consInfoId;
    /**
     * 围岩级别
     */
    private String levelId;
    /**
     * 起始桩号
     */
    private BigDecimal pegStart;
    /**
     * 结束桩号
     */
    private BigDecimal pegEnd;
    private Long deleteStatus;
    private String createBy;
    private String modifyBy;
    private Date createDate;
    private Date modifyDate;
    /**
     * 隧道
     */
    private String tunnelId;
    /**
     * 洞别
     */
    private String tunnelHoleLinkId;
}

