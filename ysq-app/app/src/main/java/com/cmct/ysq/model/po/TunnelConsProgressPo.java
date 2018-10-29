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
 * 隧道施工进度
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 06:08:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_cons_progress")
public class TunnelConsProgressPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 施工进度id
     */
    @Id
    private String constructProgressId;
    /**
     * 隧道id
     */
    @Column
    private String tunnelId;
    /**
     * 隧道方向id
     */
    @Column
    private String tunnelDirId;
    /**
     * 隧道洞口id
     */
    @Column
    private String tunnelHoleId;

    /**
     * 施工方法：0,全面断法，1，二台阶法，2，三台阶法，3，CD法，4，双层壁导坑法
     */
    @Column
    private Integer method;

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
