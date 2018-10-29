package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelDataUploadBo implements Serializable {
    @ApiModelProperty("施工进度")
    private List<TunnelConsProgressForAddBo> consProgressForAdds;
    @ApiModelProperty("监测数据")
    private List<TunnelMonitorItemDataUploadBo> monitorItemDataUploads;
    @ApiModelProperty("上传断面")
    private List<TunnelCrossSectionForAddBo> crossSectionForAdds;
}
