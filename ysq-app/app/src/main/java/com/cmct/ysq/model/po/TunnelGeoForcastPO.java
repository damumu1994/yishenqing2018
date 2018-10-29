package com.cmct.ysq.model.po;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Table(name = "t_tunnel_geo_forcast")
public class TunnelGeoForcastPO {
    /**
     * 地质预报id
     */
    @Id
    private String geoForcastId;
    /*    @OneToOne
        @JoinColumn(name = "tunnel_id")
        private TunnelInfoPo tunnelProPO;*/
    /**
     * 隧道
     */
    private String tunnelId;
    /**
     * 方向id
     */
    private String dirId;
    /**
     * 洞口
     */
    private String holeId;
    /**
     * 预报时间
     */
    private Date forcastDate;
    /**
     * 预报方法
     */
    private String forcastMethod;
    /**
     * 原始记录
     */
    private String originalRecord;
    /**
     * 起始桩号
     */
    private BigDecimal pegStart;
    /**
     * 结束桩号
     */
    private BigDecimal pegEnd;
    /**
     * 围岩级别上限
     */
    private String surrRockLevelLower;
    /**
     * 默认强，0是强，1是/，2是弱
     */
    private Long surrRockLevelLowerStren;
    /**
     * 围岩级别下限
     */
    private String surrRockLevelUpper;
    /**
     * 默认强，0是强，1是/，2是弱
     */
    private Long surrRockLevelUpperStren;
    /**
     * 地质情况
     */
    private String geoDes;
    /**
     * 异常(0,1)
     */
    private Long error;
    /**
     * 删除状态,默认是0，0是未删除，1是已删除
     */
    private Long deleteStatus;
    private String createBy;
    private String modifyBy;
    private Date createDate;
    private Date modifyDate;


}
