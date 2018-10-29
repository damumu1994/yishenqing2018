package com.cmct.ysq.model.bo;

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
@ApiModel("修改掌子面")
public class TunnelFaceForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private String faceId;
    @ApiModelProperty("监测项目记录id")
    private String recordId;
    @ApiModelProperty("施工方法")
    private String methodId;
    @ApiModelProperty("距洞口距离cm")
    private BigDecimal distance;
    @ApiModelProperty("岩性")
    private String lithology;
    @ApiModelProperty("岩性说明")
    private String lithologyRemark;
    @ApiModelProperty("地质构造影响程度")
    private String degree;
    @ApiModelProperty("间距")
    private String spaceDistance;
    @ApiModelProperty("延伸性")
    private String spread;
    @ApiModelProperty("粗糙度")
    private String roughness;
    @ApiModelProperty("张开性")
    private String open;
    @ApiModelProperty("风化程度")
    private String weatheringDegree;
    @ApiModelProperty("岩体完整状态")
    private String rockState;
    @ApiModelProperty("地质结构面说明")
    private String rockRemark;
    @ApiModelProperty("地下水")
    private String underwater;
    @ApiModelProperty("地下水说明")
    private String underwaterRemark;
    @ApiModelProperty("埋深")
    private BigDecimal depth;
    @ApiModelProperty("初始应力状态")
    private String initState;
    @ApiModelProperty("初始应力状态说明")
    private String initRemark;
    @ApiModelProperty("瓦斯")
    private String gas;
    @ApiModelProperty("岩溶/突泥")
    private String karstInrush;
    @ApiModelProperty("断层")
    private String fault;
    @ApiModelProperty("岩爆/大变形")
    private String rockBurstLargeDeformation;
    @ApiModelProperty("整体情况")
    private String overallSituation;
    @ApiModelProperty("不良地质说明")
    private String badRockRemark;
    @ApiModelProperty("设计围岩级别")
    private String designSurrLevel;
    @ApiModelProperty("施工围岩级别")
    private String constructSurrLevel;
    @ApiModelProperty("天气情况")
    private String weatherLevel;

}
