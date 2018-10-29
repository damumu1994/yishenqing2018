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
 * @date 2018-07-25 08:10:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("围岩内部位移")
public class TunnelInternalSurrRockDisplacementVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("主键")
    private String internalSurrRockDisplacementId;
    /**
     * 位置
     */

    private String locName;
    /**
     * 位置编码
     */

    private String locCode;
    /**
     * 元件号名称
     */

    private String elementName;
    /**
     * 元件号编码
     */

    private String elementCode;
    /**
     * 元件号(用户输入)
     */

    private String elementNo;
    /**
     * 标定系数
     */

    private BigDecimal ratio;
    /**
     * 量测值
     */

    private BigDecimal measurementValue;
    /**
     * 换算值
     */

    private BigDecimal conversionValue;
    /**
     * 破坏,0没有破坏，1破坏
     */

    private Integer destroy;
    /**
     * 修复,0修复，1没有修复
     */

    private Integer repaire;


}
