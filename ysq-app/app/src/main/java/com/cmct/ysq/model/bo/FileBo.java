package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * </p>
 *
 * @author shen123
 * @since 2018-05-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("多媒体")
public class FileBo {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("文件名")
    private String fileName;
    @ApiModelProperty("文件类型[1 图片/2 音频/3 视频/4 手绘/5 外部图片]")
    private Integer fileType;
    @ApiModelProperty("文件服务器中访问地址")
    private String linkUrl;
    @ApiModelProperty("前缀")
    private String prefix;
    @ApiModelProperty("后缀")
    private String suffix;
}
