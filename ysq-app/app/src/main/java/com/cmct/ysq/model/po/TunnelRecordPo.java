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
 * 检测记录表
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 10:00:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_record")
public class TunnelRecordPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String recordId;
    /**
     * 桩号
     */
    @Column
    private BigDecimal peg;
    /**
     * 监测项目
     */
    @Column
    private String monitorId;
    /**
     * 备注
     */
    @Column
    private String remark;
    /**
     * 隧道id
     */
    @Column
    private String tunnelId;
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
     * 温度
     */
    @Column
    private BigDecimal temprature;
    /**
     * 掌子面距离
     */
    @Column
    private BigDecimal faceDistance;

    /**
     * 历史修改状态，0是最新的数据，1是历史修改数据
     */
    @Column
    private Integer validStatus;

    /**
     * 历史修改历史编号
     */
    @Column
    private String hisCode;


}
