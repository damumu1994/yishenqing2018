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
 * @date 2018-07-26 16:22:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("初期支护与二次衬砌接触压力")
public class TunnelIniSupportTwoPressureVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("主键")
    private String iniSupportTwoPressureId;
    /**
     * 位置
     */

    private String locName;
    /**
     * 位置编码
     */

    private String locCode;
    /**
     * 仪器编号
     */

    private String equipNo;
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
