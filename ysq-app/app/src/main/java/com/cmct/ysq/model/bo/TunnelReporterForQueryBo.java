package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelReporterForQueryBo extends BaseModelBo {
    @ApiModelProperty("报告模板名称")
    private String fileName;

}
