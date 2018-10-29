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
 * @date 2018-07-25 08:05:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("隧道拱顶下沉详情，其他字段请参照修改接口")
public class TunnelHoleArcDownVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("主键")
    private String holeArcDownId;
    /**
     * 测点
     */

    private String testPointName;
    /**
     * 测点编码
     */

    private String testPointCode;
    /**
     * 基点名称
     */

    private String basePointName;
    /**
     * 测点与基点高差(mm)
     */

    private BigDecimal height;
    /**
     * 与第一次差值(mm)
     */

    private BigDecimal firstValueSub;
    /**
     * 破坏,0没有破坏，1破坏
     */

    private Integer destroy;
    /**
     * 修复,0修复，1没有修复
     */

    private Integer repaire;

}
