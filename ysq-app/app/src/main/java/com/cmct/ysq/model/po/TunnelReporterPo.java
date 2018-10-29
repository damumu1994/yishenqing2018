package com.cmct.ysq.model.po;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_reporter")
public class TunnelReporterPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 报告主键
     */
    @Id
    private String reporterId;
    /**
     * 报告模板请求地址
     */
    @Column
    private String url;
    /**
     * 报告模板名称
     */
    @Column
    private String fileName;
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
     * 历史修改状态，0是最新，1是历史修改
     */
    @Column
    private Integer validStauts;
    /**
     * 报告模板描述
     */
    @Column
    private String des;
    /**
     * 类型,0,日报1,周报,2月报,3地质预报,4质量检查报告
     */
    @Column
    private Integer type;

    /**
     * 部门id
     */
    @Column
    private String departId;

}
