package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:04:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("掌子面，其他字段请参照修改接口")
public class TunnelFaceVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("主键")
    private String faceId;
    /**
     * 施工方法
     */
    private String methodId;
    /**
     * 距洞口距离cm
     */
    private BigDecimal distance;
    /**
     * 岩性
     */
    private String lithology;
    /**
     * 岩性说明
     */
    private String lithologyRemark;
    /**
     * 地质构造影响程度
     */
    private String degree;
    /**
     * 间距
     */
    private String spaceDistance;
    /**
     * 延伸性
     */
    private String spread;
    /**
     * 粗糙度
     */
    private String roughness;
    /**
     * 张开性
     */
    private String open;
    /**
     *
     */
    private String weatheringDegree;
    /**
     * 岩体完整状态
     */
    private String rockState;
    /**
     * 地质结构面说明
     */
    private String rockRemark;
    /**
     * 地下水
     */
    private String underwater;
    /**
     * 地下水说明
     */
    private String underwaterRemark;
    /**
     * 埋深
     */
    private BigDecimal depth;
    /**
     * 初始应力状态
     */
    private String initState;
    /**
     * 初始应力状态说明
     */
    private String initRemark;
    /**
     * 瓦斯
     */
    private String gas;
    /**
     * 岩溶/突泥
     */
    private String karstInrush;
    /**
     * 断层
     */
    private String fault;
    /**
     * 岩爆/大变形
     */
    private String rockBurstLargeDeformation;
    /**
     * 整体情况
     */
    private String overallSituation;
    /**
     * 不良地质说明
     */
    private String badRockRemark;
    /**
     * 设计围岩级别
     */
    private String designSurrLevel;
    /**
     * 施工围岩级别
     */
    private String constructSurrLevel;
    /**
     * 天气情况
     */
    private String weatherLevel;

}
