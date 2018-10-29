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
 * 掌子面
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:04:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_face")
public class TunnelFacePo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    private String faceId;
    /**
     * 施工方法
     */
    @Column
    private String methodId;
    /**
     * 距洞口距离cm
     */
    @Column
    private BigDecimal distance;
    /**
     * 岩性
     */
    @Column
    private String lithology;
    /**
     * 岩性说明
     */
    @Column
    private String lithologyRemark;
    /**
     * 地质构造影响程度
     */
    @Column
    private String degree;
    /**
     * 间距
     */
    @Column
    private String spaceDistance;
    /**
     * 延伸性
     */
    @Column
    private String spread;
    /**
     * 粗糙度
     */
    @Column
    private String roughness;
    /**
     * 张开性
     */
    @Column
    private String open;
    /**
     *
     */
    @Column
    private String weatheringDegree;
    /**
     * 岩体完整状态
     */
    @Column
    private String rockState;
    /**
     * 地质结构面说明
     */
    @Column
    private String rockRemark;
    /**
     * 地下水
     */
    @Column
    private String underwater;
    /**
     * 地下水说明
     */
    @Column
    private String underwaterRemark;
    /**
     * 埋深
     */
    @Column
    private BigDecimal depth;
    /**
     * 初始应力状态
     */
    @Column
    private String initState;
    /**
     * 初始应力状态说明
     */
    @Column
    private String initRemark;
    /**
     * 瓦斯
     */
    @Column
    private String gas;
    /**
     * 岩溶/突泥
     */
    @Column
    private String karstInrush;
    /**
     * 断层
     */
    @Column
    private String fault;
    /**
     * 岩爆/大变形
     */
    @Column
    private String rockBurstLargeDeformation;
    /**
     * 整体情况
     */
    @Column
    private String overallSituation;
    /**
     * 不良地质说明
     */
    @Column
    private String badRockRemark;
    /**
     * 设计围岩级别
     */
    @Column
    private String designSurrLevel;
    /**
     * 施工围岩级别
     */
    @Column
    private String constructSurrLevel;
    /**
     * 天气情况
     */
    @Column
    private String weatherLevel;
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
     * 监测项目记录id
     */
    @Column
    private String recordId;
}
